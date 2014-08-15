package com.bc.search.impl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

import com.bc.search.BingSearchClient;
import com.bc.search.BingSearchException;
import com.bc.search.constant.BingSearchApiUrls;
import com.bc.search.constant.BingSearchApiUrls.BingSearchApiUrlBuilder;
import com.bc.search.entity.SearchRequest;
import com.bc.search.entity.SearchResponse;

/**
 * The Class BaseBingSearchApiClient.
 */
public abstract class BaseBingSearchApiClient implements BingSearchClient {

    /** The Constant GZIP_ENCODING. */
    private static final String GZIP_ENCODING = "gzip";

    /** The LOG. */
    protected final Logger LOG = Logger.getLogger(getClass().getCanonicalName());
    
    /** The request headers. */
    private Map<String, String> requestHeaders;
    
    /** The task executor. */
    protected ExecutorService taskExecutor;

    /**
     * Instantiates a new base bing search api client.
     */
    protected BaseBingSearchApiClient() {
        requestHeaders = new HashMap<String, String>();

        // by default we compress contents
        requestHeaders.put("Accept-Encoding", "gzip, deflate");
    }

    /**
     * Sets the request headers.
     * 
     * @param requestHeaders the request headers
     */
    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    /**
     * Gets the request headers.
     * 
     * @return the request headers
     */
    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    /**
     * Adds the request header.
     * 
     * @param headerName the header name
     * @param headerValue the header value
     */
    public void addRequestHeader(String headerName, String headerValue) {
        requestHeaders.put(headerName, headerValue);
    }

    /**
     * Removes the request header.
     * 
     * @param headerName the header name
     */
    public void removeRequestHeader(String headerName) {
        requestHeaders.remove(headerName);
    }

    /**
     * Execute.
     * 
     * @param task the task
     * 
     * @return the future
     */
    @SuppressWarnings("unchecked")
	protected Future execute(Runnable task) {
        return taskExecutor.submit(task);
    }

    /**
     * Execute.
     * 
     * @param task the task
     * 
     * @return the future< t>
     */
    protected <T> Future<T> execute(Callable<T> task) {
        return taskExecutor.submit(task);
    }
    
    /* (non-Javadoc)
     * @see com.bc.search.client.BingSearchClient#search(com.bc.search.entity.SearchRequest)
     */
	@Override
	public SearchResponse search(SearchRequest request) {
        assertNotNull("search request", request);

        BingSearchApiUrlBuilder builder = createBingSearchApiUrlBuilder(BingSearchApiUrls.BASE_URL);
        String                apiUrl  =
            builder.withSearchRequest(request).buildUrl();

        return readResponse(SearchResponse.class, callApiMethod(apiUrl));
	}

    /* (non-Javadoc)
     * @see com.bc.search.client.BingSearchClient#searchAsync(com.bc.search.entity.SearchRequest)
     */
	@Override
	public Future<SearchResponse> searchAsync(final SearchRequest request) {
		return execute(new Callable<SearchResponse>() {
            @Override
            public SearchResponse call() throws Exception {
                return search(request);
            }
        });	
     }
	
    /**
     * Read response.
     * 
     * @param clazz the clazz
     * @param is the is
     * 
     * @return the t
     */
    protected <T> T readResponse(Class<T> clazz, InputStream is) {
        try {
            return unmarshallObject(clazz, is);
        } finally {
            closeStream(is);
        }
    }

    /**
     * Call api method.
     * 
     * @param apiUrl the api url
     * 
     * @return the input stream
     */
    protected InputStream callApiMethod(String apiUrl) {
        return callApiMethod(apiUrl, HttpURLConnection.HTTP_OK);
    }

    /**
     * Call api method.
     * 
     * @param apiUrl the api url
     * @param expected the expected
     * 
     * @return the input stream
     */
    protected InputStream callApiMethod(String apiUrl, int expected) {
        try {
            URL               url     = new URL(apiUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            for (String headerName : requestHeaders.keySet()) {
                request.setRequestProperty(headerName, requestHeaders.get(headerName));
            }
            
            request.connect();

            if (request.getResponseCode() != expected) {
                Error error = readResponse(Error.class,
                                           getWrappedInputStream(request.getErrorStream(),
                                               GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding())));

                throw createBingSearchApiClientException(error);
            } else {
                return getWrappedInputStream(request.getInputStream(),
                                             GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
            }
        } catch (IOException e) {
            throw new BingSearchException(e);
        }
    }

    /**
     * Close stream.
     * 
     * @param is the is
     */
    protected void closeStream(InputStream is) {
        try {
            is.close();
        } catch (IOException e) {
        	LOG.log(Level.SEVERE, "An error occurred while closing stream.", e);	
        }
    }

    /**
     * Close connection.
     * 
     * @param connection the connection
     */
    protected void closeConnection(HttpURLConnection connection) {
        try {
        	if (connection != null) {
        		connection.disconnect();
        	}
        } catch (Exception e) {
        	LOG.log(Level.SEVERE, "An error occurred while disconnecting connection.", e);	
        }
    }
    
    /**
     * Creates the bing search api client exception.
     * 
     * @param error the error
     * 
     * @return the bing search exception
     */
    protected BingSearchException createBingSearchApiClientException(Error error) {
        return new BingSearchException();
    }

    /**
     * Gets the wrapped input stream.
     * 
     * @param is the is
     * @param gzip the gzip
     * 
     * @return the wrapped input stream
     * 
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected InputStream getWrappedInputStream(InputStream is, boolean gzip) throws IOException {
        if (gzip) {
            return new BufferedInputStream(new GZIPInputStream(is));
        } else {
            return new BufferedInputStream(is);
        }
    }

    /**
     * Checks if is null or empty.
     * 
     * @param s the s
     * 
     * @return true, if is null or empty
     */
    protected boolean isNullOrEmpty(String s) {
        return ((s == null) || (s.length() == 0));
    }

    /**
     * Assert not null or empty.
     * 
     * @param name the name
     * @param value the value
     */
    protected void assertNotNullOrEmpty(String name, String value) {
        if (isNullOrEmpty(value)) {
            throw new IllegalArgumentException(name + " cannot be null or empty.");
        }
    }

    /**
     * Assert not null or empty.
     * 
     * @param name the name
     * @param value the value
     */
    protected void assertNotNullOrEmpty(String name, Collection<?> value) {
        if ((value == null) || value.isEmpty()) {
            throw new IllegalArgumentException(name + " cannot be null or empty.");
        }
    }

    /**
     * Assert positive number.
     * 
     * @param name the name
     * @param value the value
     */
    protected void assertPositiveNumber(String name, int value) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " cannot be less than zero.");
        }
    }

    /**
     * Assert not null.
     * 
     * @param name the name
     * @param value the value
     */
    protected void assertNotNull(String name, Object value) {
        if (value == null) {
            throw new IllegalArgumentException(name + " cannot be null.");
        }
    }

    /**
     * Unmarshall object.
     * 
     * @param clazz the clazz
     * @param xmlContent the xml content
     * 
     * @return the t
     */
    protected abstract <T> T unmarshallObject(Class<T> clazz, InputStream xmlContent);

    /**
     * Marshall object.
     * 
     * @param element the element
     * 
     * @return the string
     */
    protected abstract String marshallObject(Object element);

    /**
     * Creates the bing search api url builder.
     * 
     * @param urlFormat the url format
     * 
     * @return the bing search api url builder
     */
    protected abstract BingSearchApiUrlBuilder createBingSearchApiUrlBuilder(String urlFormat);

	/**
	 * Gets the task executor.
	 * 
	 * @return the task executor
	 */
	public ExecutorService getTaskExecutor() {
		return taskExecutor;
	}

	/**
	 * Sets the task executor.
	 * 
	 * @param taskExecutor the new task executor
	 */
	public void setTaskExecutor(ExecutorService taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
}
