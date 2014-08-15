package com.bc.search.constant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bc.search.entity.SearchOption;
import com.bc.search.entity.SearchRequest;
import com.bc.search.entity.SourceType;
import com.bc.search.entity.mobileweb.MobileWebRequest;
import com.bc.search.entity.mobileweb.MobileWebSearchOption;
import com.bc.search.entity.multimedia.ImageRequest;
import com.bc.search.entity.multimedia.VideoRequest;
import com.bc.search.entity.news.NewsRequest;
import com.bc.search.entity.phonebook.PhonebookRequest;
import com.bc.search.entity.translation.TranslationRequest;
import com.bc.search.entity.web.WebRequest;
import com.bc.search.entity.web.WebSearchOption;

/**
 * The Class BingSearchApiUrls.
 */
public final class BingSearchApiUrls {

    /** The Constant API_URLS_FILE. */
    public static final String API_URLS_FILE = "BingSearchApiUrls.properties";

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(BingSearchApiUrls.class.getCanonicalName());
    
    /** The Constant bingSearchApiUrls. */
    private static final Properties bingSearchApiUrls = new Properties();

    static {
        try {
            bingSearchApiUrls.load(BingSearchApiUrls.class.getResourceAsStream(API_URLS_FILE));
        } catch (IOException e) {
        	LOG.log(Level.SEVERE, "An error occurred while loading urls.", e);
        }
    }

    /** The Constant BASE_URL. */
    public static final String BASE_URL = "http://api.bing.net/{protocol}.aspx?{queryParameters}";
//        bingSearchApiUrls.getProperty("com.bc.search.client.url");

    /**
     * Instantiates a new bing search api urls.
     */
    private BingSearchApiUrls() {}

    /**
     * The Class BingSearchApiUrlBuilder.
     */
    public static class BingSearchApiUrlBuilder {
        
        /** The Constant API_PROTOCOL. */
        private static final String API_PROTOCOL = "json";

		/** The Constant API_URLS_PLACEHOLDER_START. */
        private static final char API_URLS_PLACEHOLDER_START = '{';

        /** The Constant API_URLS_PLACEHOLDER_END. */
        private static final char API_URLS_PLACEHOLDER_END = '}';
        
        /** The Constant PROTOCOL_PLACEHOLDER. */
        private static final String PROTOCOL_PLACEHOLDER = "protocol";
    	
        /** The Constant QUERY_PARAMETERS_PLACEHOLDER. */
        private static final String QUERY_PARAMETERS_PLACEHOLDER = "queryParameters";
        
    	/** The url format. */
	    private String urlFormat;
    	
    	/** The parameters map. */
	    private Map<String, String> parametersMap = new HashMap<String, String>();
    	
    	/**
	     * Instantiates a new bing search api url builder.
	     * 
	     * @param urlFormat the url format
	     */
	    public BingSearchApiUrlBuilder(String urlFormat) {
    		this.urlFormat = urlFormat;
    	}
    	
    	/**
	     * With parameter.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the bing search api url builder
	     */
	    public BingSearchApiUrlBuilder withParameter(String name, String value) {
	    	if (value != null && value.length() > 0) {
	    		parametersMap.put(name, encodeUrl(value));
	    	}
    		
    		return this;
    	}
    	
    	/**
	     * With parameter.
	     * 
	     * @param name the name
	     * @param values the values
	     * 
	     * @return the bing search api url builder
	     */
	    private BingSearchApiUrlBuilder withParameter(String name, List<String> values) {
	    	if (values != null && values.size() > 0) {
	    		StringBuilder builder = new StringBuilder();
	    		Iterator<String> iter = values.iterator();
	    		while (iter.hasNext()) {
	    			builder.append(encodeUrl(iter.next()));
	    			if (iter.hasNext()) {
	    				builder.append("+");
	    			}
	    		}
	    		parametersMap.put(name, builder.toString());
	    	}
    		
    		return this;
    	}
	    
    	/**
	     * With parameter.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the bing search api url builder
	     */
	    private BingSearchApiUrlBuilder withParameter(String name, Object value) {
	    	if (value != null) {
	    		parametersMap.put(name, encodeUrl(value.toString()));
	    	}
    		
    		return this;
    	}
	    
	    /**
    	 * With search request.
    	 * 
    	 * @param parameters the parameters
    	 * 
    	 * @return the bing search api url builder
    	 */
    	public BingSearchApiUrlBuilder withSearchRequest(SearchRequest parameters) {
    		withParameter("Version", parameters.getVersion());
    		withParameter("Market", parameters.getMarket());
    		withParameter("UILanguage", parameters.getUILanguage());
    		withParameter("Query", parameters.getQuery());
    		if (parameters.getAdult() != null) {
	    		withParameter("Adult", parameters.getAdult().value());
    		}
    		withParameter("AppId", parameters.getAppId());
    		withParameter("Latitude", parameters.getLatitude());
    		withParameter("Longitude", parameters.getLongitude());
    		withParameter("Radius", parameters.getRadius());
    		if (!parameters.getSearchOptionList().isEmpty()) {
    			List<String> values = new ArrayList<String>(); 
    			for (SearchOption option : parameters.getSearchOptionList()) {
    				values.add(option.value());
    			}
	    		withParameter("Options", values);
    		}
    		if (!parameters.getSourceTypeList().isEmpty()) {
    			List<String> values = new ArrayList<String>(); 
    			for (SourceType sourceType : parameters.getSourceTypeList()) {
    				values.add(sourceType.value());
    			}
    			withParameter("Sources", values);
    		}
    		if (parameters.getWebRequest() != null) {
    			withWebRequest("Web", parameters.getWebRequest());
    		}
    		if (parameters.getImageRequest() != null) {
    			withImageRequest("Image", parameters.getImageRequest());
    		}
    		if (parameters.getPhonebookRequest() != null) {
    			withPhonebookRequest("Phonebook", parameters.getPhonebookRequest());
    		}
    		if (parameters.getVideoRequest() != null) {
    			withVideoRequest("Video", parameters.getVideoRequest());
    		}
    		if (parameters.getNewsRequest() != null) {
    			withNewsRequest("News", parameters.getNewsRequest());
    		}
    		if (parameters.getMobileWebRequest() != null) {
    			withMobileWebRequest("MobileWeb", parameters.getMobileWebRequest());
    		}
    		if (parameters.getTranslationRequest() != null) {
    			withTranslationRequest("Translation", parameters.getTranslationRequest());
    		}
    		return this;
    	}
	    
	    /**
    	 * With web request.
    	 * 
    	 * @param name the name
    	 * @param request the request
    	 * 
    	 * @return the bing search api url builder
    	 */
    	public BingSearchApiUrlBuilder withWebRequest(String name, WebRequest request) {
	    	withParameter(name + ".Offset", request.getOffset());
	    	withParameter(name + ".Count", request.getCount());
	    	withParameter(name + ".FileType", request.getFileType());
	    	
    		if (!request.getWebSearchOptionList().isEmpty()) {
    			List<String> values = new ArrayList<String>(); 
    			for (WebSearchOption option : request.getWebSearchOptionList()) {
    				values.add(option.value());
    			}
    			withParameter(name + ".Options", values);
    		}
    		if (!request.getSearchTagList().isEmpty()) {
    			List<String> values = new ArrayList<String>(); 
    			for (String tag : request.getSearchTagList()) {
    				values.add(tag);
    			}
    			withParameter(name + ".SearchTags", values);
    		}
	    	
	    	return this;
	    }
	    
	    /**
    	 * With image request.
    	 * 
    	 * @param name the name
    	 * @param request the request
    	 * 
    	 * @return the bing search api url builder
    	 */
    	public BingSearchApiUrlBuilder withImageRequest(String name, ImageRequest request) {
	    	withParameter(name + ".Offset", request.getOffset());
	    	withParameter(name + ".Count", request.getCount());
    		if (!request.getFilterList().isEmpty()) {
    			List<String> values = new ArrayList<String>(); 
    			for (String filter : request.getFilterList()) {
    				values.add(filter);
    			}
    			withParameter(name + ".Filters", values);
    		}
	    	return this;
	    }
	    
	    /**
    	 * With phonebook request.
    	 * 
    	 * @param name the name
    	 * @param request the request
    	 * 
    	 * @return the bing search api url builder
    	 */
    	public BingSearchApiUrlBuilder withPhonebookRequest(String name, PhonebookRequest request) {
	    	withParameter(name + ".Offset", request.getOffset());
	    	withParameter(name + ".Count", request.getCount());
	    	withParameter(name + ".FileType", request.getFileType());
	    	if (request.getSortBy() != null) {
		    	withParameter(name + ".SortBy", request.getSortBy().value());
	    	}
	    	withParameter(name + ".LocId", request.getLocId());
	    	withParameter(name + ".Category", request.getCategory());
	    	
	    	return this;
	    }
	    
	    /**
    	 * With video request.
    	 * 
    	 * @param name the name
    	 * @param request the request
    	 * 
    	 * @return the bing search api url builder
    	 */
    	public BingSearchApiUrlBuilder withVideoRequest(String name, VideoRequest request) {
	    	withParameter(name + ".Offset", request.getOffset());
	    	withParameter(name + ".Count", request.getCount());
    		if (!request.getFilterList().isEmpty()) {
    			List<String> values = new ArrayList<String>(); 
    			for (String filter : request.getFilterList()) {
    				values.add(filter);
    			}
    			withParameter(name + ".Filters", values);
    		}
	    	if (request.getSortBy() != null) {
		    	withParameter(name + ".SortBy", request.getSortBy().value());
	    	}
	    	return this;
	    }
	    
	    /**
    	 * With news request.
    	 * 
    	 * @param name the name
    	 * @param request the request
    	 * 
    	 * @return the bing search api url builder
    	 */
    	public BingSearchApiUrlBuilder withNewsRequest(String name, NewsRequest request) {
	    	withParameter(name + ".Offset", request.getOffset());
	    	withParameter(name + ".Count", request.getCount());
	    	withParameter(name + ".LocationOverride", request.getLocationOverride());
	    	withParameter(name + ".Category", request.getCategory());
	    	if (request.getSortBy() != null) {
		    	withParameter(name + ".SortBy", request.getSortBy().value());
	    	}
	    	return this;
	    }
	    
	    /**
    	 * With mobile web request.
    	 * 
    	 * @param name the name
    	 * @param request the request
    	 * 
    	 * @return the bing search api url builder
    	 */
    	public BingSearchApiUrlBuilder withMobileWebRequest(String name, MobileWebRequest request) {
	    	withParameter(name + ".Offset", request.getOffset());
	    	withParameter(name + ".Count", request.getCount());
    		if (!request.getMobileWebSearchOptionList().isEmpty()) {
    			List<String> values = new ArrayList<String>(); 
    			for (MobileWebSearchOption option : request.getMobileWebSearchOptionList()) {
    				values.add(option.value());
    			}
    			withParameter(name + ".Options", values);
    		}
	    	return this;
	    }
	    
	    /**
    	 * With translation request.
    	 * 
    	 * @param name the name
    	 * @param request the request
    	 * 
    	 * @return the bing search api url builder
    	 */
    	public BingSearchApiUrlBuilder withTranslationRequest(String name, TranslationRequest request) {
	    	withParameter(name + ".SourceLanguage", request.getSourceLanguage());
	    	withParameter(name + ".TargetLanguage", request.getTargetLanguage());
	    	return this;
	    }
	    
    	/**
	     * Builds the url.
	     * 
	     * @return the string
	     */
		public String buildUrl() {
        	StringBuilder urlBuilder = new StringBuilder();
        	StringBuilder placeHolderBuilder = new StringBuilder();
        	boolean placeHolderFlag = false;
        	for (int i = 0; i < urlFormat.length(); i++) {
        		if (urlFormat.charAt(i) == API_URLS_PLACEHOLDER_START) {
        			placeHolderBuilder = new StringBuilder();
        			placeHolderFlag = true;
        		} else if (placeHolderFlag && urlFormat.charAt(i) == API_URLS_PLACEHOLDER_END) {
        			String placeHolder = placeHolderBuilder.toString();
        			if (PROTOCOL_PLACEHOLDER.equals(placeHolder)) {
        				urlBuilder.append(API_PROTOCOL);
        			} else if (QUERY_PARAMETERS_PLACEHOLDER.equals(placeHolder)) {
    			    	StringBuilder builder = new StringBuilder();
    			    	if (!parametersMap.isEmpty()) {
    			    		Iterator<String> iter = parametersMap.keySet().iterator();
    			    		while (iter.hasNext()) {
    			    			String name = iter.next();
			    				String value = parametersMap.get(name);
			    				builder.append(name);
			    				builder.append("=");
			    				builder.append(value);
    			    			if (iter.hasNext()) {
    			    				builder.append("&");
    			    			}
    			    		}
    			    	}
    			    	urlBuilder.append(builder.toString());
        			} else {
        				// we did not find a binding for the placeholder.
        				// append it as it is.
        				urlBuilder.append(API_URLS_PLACEHOLDER_START);
        				urlBuilder.append(placeHolder);
        				urlBuilder.append(API_URLS_PLACEHOLDER_END);
        			}
        			placeHolderFlag = false;
        		} else if (placeHolderFlag) {
        			placeHolderBuilder.append(urlFormat.charAt(i));
        		} else {
        			urlBuilder.append(urlFormat.charAt(i));
        		}
        	}

        	return urlBuilder.toString();
    	}
    	
        /**
         * Encode url.
         * 
         * @param original the original
         * 
         * @return the string
         */
        private static String encodeUrl(String original) {
        	try {
    			return URLEncoder.encode(original, ApplicationConstants.CONTENT_ENCODING);
    		} catch (UnsupportedEncodingException e) {
    			// should never be here..
    			return original;
    		}
        }
    }
}
