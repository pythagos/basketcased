package com.bc.search.impl;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.ExecutorService;

import com.bc.search.BingSearchException;
import com.bc.search.constant.ApplicationConstants;
import com.bc.search.constant.BingSearchApiUrls.BingSearchApiUrlBuilder;
import com.bc.search.entity.AdultOption;
import com.bc.search.entity.Error;
import com.bc.search.entity.Query;
import com.bc.search.entity.SearchOption;
import com.bc.search.entity.SearchRequest;
import com.bc.search.entity.SearchResponse;
import com.bc.search.entity.SourceType;
import com.bc.search.entity.instantanswer.InstantAnswerResponse;
import com.bc.search.entity.instantanswer.InstantAnswerResult;
import com.bc.search.entity.mobileweb.MobileWebRequest;
import com.bc.search.entity.mobileweb.MobileWebResponse;
import com.bc.search.entity.mobileweb.MobileWebResult;
import com.bc.search.entity.mobileweb.MobileWebSearchOption;
import com.bc.search.entity.multimedia.ImageRequest;
import com.bc.search.entity.multimedia.ImageResponse;
import com.bc.search.entity.multimedia.ImageResult;
import com.bc.search.entity.multimedia.Thumbnail;
import com.bc.search.entity.multimedia.VideoRequest;
import com.bc.search.entity.multimedia.VideoResponse;
import com.bc.search.entity.multimedia.VideoResult;
import com.bc.search.entity.multimedia.VideoSortOption;
import com.bc.search.entity.news.NewsArticle;
import com.bc.search.entity.news.NewsCollection;
import com.bc.search.entity.news.NewsRelatedSearch;
import com.bc.search.entity.news.NewsRequest;
import com.bc.search.entity.news.NewsResponse;
import com.bc.search.entity.news.NewsResult;
import com.bc.search.entity.news.NewsSortOption;
import com.bc.search.entity.phonebook.PhonebookRequest;
import com.bc.search.entity.phonebook.PhonebookResponse;
import com.bc.search.entity.phonebook.PhonebookResult;
import com.bc.search.entity.phonebook.PhonebookSortOption;
import com.bc.search.entity.relatedsearch.RelatedSearchResponse;
import com.bc.search.entity.relatedsearch.RelatedSearchResult;
import com.bc.search.entity.spell.SpellResponse;
import com.bc.search.entity.spell.SpellResult;
import com.bc.search.entity.translation.TranslationRequest;
import com.bc.search.entity.translation.TranslationResponse;
import com.bc.search.entity.translation.TranslationResult;
import com.bc.search.entity.web.DeepLink;
import com.bc.search.entity.web.WebRequest;
import com.bc.search.entity.web.WebResponse;
import com.bc.search.entity.web.WebResult;
import com.bc.search.entity.web.WebSearchOption;
import com.bc.search.entity.web.WebSearchTag;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * The Class BingSearchJsonClientImpl.
 */
public class BingSearchJsonClientImpl extends BaseBingSearchApiClient {

    /** The Constant OBJECT_FACTORY. */
    private static final JsonElementFactory OBJECT_FACTORY = new JsonElementFactory();
    
	/** The Constant UTF_8_CHAR_SET. */
	protected static final Charset UTF_8_CHAR_SET = Charset.forName(ApplicationConstants.CONTENT_ENCODING);
	
    /** The parser. */
    private final JsonParser parser = new JsonParser();
    
    /* (non-Javadoc)
     * @see com.bc.search.client.impl.BaseBingSearchApiClient#unmarshallObject(java.lang.Class, java.io.InputStream)
     */
    @SuppressWarnings("unchecked")
    protected <T> T unmarshallObject(Class<T> clazz, InputStream jsonContent) {
        try {
        	JsonElement response = parser.parse(new InputStreamReader(jsonContent, UTF_8_CHAR_SET));
        	if (response.isJsonObject()) {
        		if (response.getAsJsonObject().get("SearchResponse") != null) {
        			Gson gson = getGsonBuilder().create();
        			return (T) gson.fromJson(response.getAsJsonObject().get("SearchResponse"), clazz);
        		}
        	}
        	throw new BingSearchException("Unknown content found in response:" + response.toString());
        } catch (Exception e) {
            throw new BingSearchException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.bc.search.client.impl.BaseBingSearchApiClient#marshallObject(java.lang.Object)
     */
    protected String marshallObject(Object element) {
        try {
            StringWriter writer = new StringWriter();
            
            // TODO-NM: Implement this method.
            return writer.toString();
        } catch (Exception e) {
            throw new BingSearchException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.bc.search.client.impl.BaseBingSearchApiClient#createBingSearchApiUrlBuilder(java.lang.String)
     */
    protected BingSearchApiUrlBuilder createBingSearchApiUrlBuilder(String urlFormat) {
        return new BingSearchApiUrlBuilder(urlFormat);
    }
    
	/**
	 * The Class SearchRequestBuilderImpl.
	 */
	public static class SearchRequestBuilderImpl implements SearchRequestBuilder {
		
		/** The result. */
		protected SearchRequest result;
		
		/** The factory. */
		protected JsonElementFactory factory;
		
		/**
		 * Instantiates a new search request builder impl.
		 * 
		 * @param factory the factory
		 */
		protected SearchRequestBuilderImpl(JsonElementFactory factory) {
			this.factory = factory;
			this.result = factory.createSearchRequest();
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withAppId(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withAppId(String applicationId) {
			getParameters().setAppId(applicationId);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withAdultOption(com.bc.search.entity.AdultOption)
		 */
		@Override
		public SearchRequestBuilder withAdultOption(AdultOption adult) {
			getParameters().setAdult(adult);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withImageRequestCount(java.lang.Long)
		 */
		@Override
		public SearchRequestBuilder withImageRequestCount(Long count) {
			getImageRequest().setCount(count);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withImageRequestFilter(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withImageRequestFilter(String filter) {
			getImageRequestFilters().add(filter);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withImageRequestOffset(java.lang.Long)
		 */
		@Override
		public SearchRequestBuilder withImageRequestOffset(Long offset) {
			getImageRequest().setOffset(offset);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withLatitude(java.lang.Double)
		 */
		@Override
		public SearchRequestBuilder withLatitude(Double latitude) {
			getParameters().setLatitude(latitude);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withLongitude(java.lang.Double)
		 */
		@Override
		public SearchRequestBuilder withLongitude(Double longitude) {
			getParameters().setLongitude(longitude);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withMarket(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withMarket(String market) {
			getParameters().setMarket(market);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withMobileWebRequestCount(java.lang.Long)
		 */
		@Override
		public SearchRequestBuilder withMobileWebRequestCount(Long count) {
			getMobileWebRequest().setCount(count);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withMobileWebRequestOffset(java.lang.Long)
		 */
		@Override
		public SearchRequestBuilder withMobileWebRequestOffset(Long offset) {
			getMobileWebRequest().setOffset(offset);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withMobileWebRequestSearchOption(com.bc.search.entity.mobileweb.MobileWebSearchOption)
		 */
		@Override
		public SearchRequestBuilder withMobileWebRequestSearchOption(
				MobileWebSearchOption mobileWebSearchOption) {
			getMobileWebRequestOptions().add(mobileWebSearchOption);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withNewsRequestCategory(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withNewsRequestCategory(String category) {
			getNewsRequest().setCategory(category);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withNewsRequestCount(java.lang.Long)
		 */
		@Override
		public SearchRequestBuilder withNewsRequestCount(Long count) {
			getNewsRequest().setCount(count);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withNewsRequestLocationOverride(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withNewsRequestLocationOverride(
				String locationOverride) {
			getNewsRequest().setLocationOverride(locationOverride);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withNewsRequestOffset(java.lang.Long)
		 */
		@Override
		public SearchRequestBuilder withNewsRequestOffset(Long offset) {
			getNewsRequest().setOffset(offset);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withNewsRequestSortOption(com.bc.search.entity.news.NewsSortOption)
		 */
		@Override
		public SearchRequestBuilder withNewsRequestSortOption(
				NewsSortOption newsSortOption) {
			getNewsRequest().setSortBy(newsSortOption);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withPhonebookRequestCategory(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withPhonebookRequestCategory(String category) {
			getPhonebookRequest().setCategory(category);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withPhonebookRequestCount(java.lang.Long)
		 */
		@Override
		public SearchRequestBuilder withPhonebookRequestCount(Long count) {
			getPhonebookRequest().setCount(count);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withPhonebookRequestFileType(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withPhonebookRequestFileType(String fileType) {
			getPhonebookRequest().setFileType(fileType);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withPhonebookRequestLocId(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withPhonebookRequestLocId(String locId) {
			getPhonebookRequest().setLocId(locId);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withPhonebookRequestOffset(java.lang.Long)
		 */
		@Override
		public SearchRequestBuilder withPhonebookRequestOffset(Long offset) {
			getPhonebookRequest().setOffset(offset);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withPhonebookRequestSortOption(com.bc.search.entity.phonebook.PhonebookSortOption)
		 */
		@Override
		public SearchRequestBuilder withPhonebookRequestSortOption(
				PhonebookSortOption phonebookSortOption) {
			getPhonebookRequest().setSortBy(phonebookSortOption);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withQuery(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withQuery(String query) {
			getParameters().setQuery(query);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withRadius(java.lang.Double)
		 */
		@Override
		public SearchRequestBuilder withRadius(Double radius) {
			getParameters().setRadius(radius);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withSearchOption(com.bc.search.entity.SearchOption)
		 */
		@Override
		public SearchRequestBuilder withSearchOption(SearchOption searchOption) {
			getParameterOptions().add(searchOption);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withSourceType(com.bc.search.entity.SourceType)
		 */
		@Override
		public SearchRequestBuilder withSourceType(SourceType sourceType) {
			getParameterSources().add(sourceType);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withTranslationRequestSourceLanguage(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withTranslationRequestSourceLanguage(
				String sourceLanguage) {
			getTranslationRequest().setSourceLanguage(sourceLanguage);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withTranslationRequestTargetLanguage(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withTranslationRequestTargetLanguage(
				String targetLanguage) {
			getTranslationRequest().setTargetLanguage(targetLanguage);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withUILanguage(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withUILanguage(String uiLanguage) {
			getParameters().setUILanguage(uiLanguage);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withVersion(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withVersion(String version) {
			getParameters().setVersion(version);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withVideoRequestCount(java.lang.Long)
		 */
		@Override
		public SearchRequestBuilder withVideoRequestCount(Long count) {
			getVideoRequest().setCount(count);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withVideoRequestFilter(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withVideoRequestFilter(String filter) {
			getVideoRequestFilters().add(filter);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withVideoRequestOffset(java.lang.Long)
		 */
		@Override
		public SearchRequestBuilder withVideoRequestOffset(Long offset) {
			getVideoRequest().setOffset(offset);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withVideoRequestSortOption(com.bc.search.entity.multimedia.VideoSortOption)
		 */
		@Override
		public SearchRequestBuilder withVideoRequestSortOption(
				VideoSortOption videoSortOption) {
			getVideoRequest().setSortBy(videoSortOption);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withWebRequestCount(java.lang.Long)
		 */
		@Override
		public SearchRequestBuilder withWebRequestCount(Long count) {
			getWebRequest().setCount(count);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withWebRequestFileType(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withWebRequestFileType(String fileType) {
			getWebRequest().setFileType(fileType);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withWebRequestOffset(java.lang.Long)
		 */
		@Override
		public SearchRequestBuilder withWebRequestOffset(Long offset) {
			getWebRequest().setOffset(offset);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withWebRequestSearchOption(com.bc.search.entity.web.WebSearchOption)
		 */
		@Override
		public SearchRequestBuilder withWebRequestSearchOption(
				WebSearchOption webSearchOption) {
			getWebRequestOptions().add(webSearchOption);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#withWebRequestSearchTag(java.lang.String)
		 */
		@Override
		public SearchRequestBuilder withWebRequestSearchTag(String searchTag) {
			getWebRequestSearchTags().add(searchTag);
			return this;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#getResult()
		 */
		public SearchRequest getResult() {
			return result;
		}

		/* (non-Javadoc)
		 * @see com.bc.search.client.BingSearchClient.SearchRequestBuilder#reset()
		 */
		@Override
		public void reset() {
			result = factory.createSearchRequest();
		}
		
		/**
		 * Gets the parameters.
		 * 
		 * @return the parameters
		 */
		private SearchRequest getParameters() {
			return result;
		}
		
		/**
		 * Gets the image request.
		 * 
		 * @return the image request
		 */
		private ImageRequest getImageRequest() {
			if (getParameters().getImageRequest() == null) {
				getParameters().setImageRequest(factory.createImageRequest());
			}
			return getParameters().getImageRequest();
		}

		/**
		 * Gets the mobile web request.
		 * 
		 * @return the mobile web request
		 */
		private MobileWebRequest getMobileWebRequest() {
			if (getParameters().getMobileWebRequest() == null) {
				getParameters().setMobileWebRequest(factory.createMobileWebRequest());
			}
			return getParameters().getMobileWebRequest();
		}

		/**
		 * Gets the news request.
		 * 
		 * @return the news request
		 */
		private NewsRequest getNewsRequest() {
			if (getParameters().getNewsRequest() == null) {
				getParameters().setNewsRequest(factory.createNewsRequest());
			}
			return getParameters().getNewsRequest();
		}

		/**
		 * Gets the phonebook request.
		 * 
		 * @return the phonebook request
		 */
		private PhonebookRequest getPhonebookRequest() {
			if (getParameters().getPhonebookRequest() == null) {
				getParameters().setPhonebookRequest(factory.createPhonebookRequest());
			}
			return getParameters().getPhonebookRequest();
		}

		/**
		 * Gets the translation request.
		 * 
		 * @return the translation request
		 */
		private TranslationRequest getTranslationRequest() {
			if (getParameters().getTranslationRequest() == null) {
				getParameters().setTranslationRequest(factory.createTranslationRequest());
			}
			return getParameters().getTranslationRequest();
		}
		
		/**
		 * Gets the video request.
		 * 
		 * @return the video request
		 */
		private VideoRequest getVideoRequest() {
			if (getParameters().getVideoRequest() == null) {
				getParameters().setVideoRequest(factory.createVideoRequest());
			}
			return getParameters().getVideoRequest();
		}
		
		/**
		 * Gets the web request.
		 * 
		 * @return the web request
		 */
		private WebRequest getWebRequest() {
			if (getParameters().getWebRequest() == null) {
				getParameters().setWebRequest(factory.createWebRequest());
			}
			return getParameters().getWebRequest();
		}
		
		/**
		 * Gets the image request filters.
		 * 
		 * @return the image request filters
		 */
		private  List<String> getImageRequestFilters() {
			return getImageRequest().getFilterList();
		}

		/**
		 * Gets the mobile web request options.
		 * 
		 * @return the mobile web request options
		 */
		private  List<MobileWebSearchOption> getMobileWebRequestOptions() {
			return getMobileWebRequest().getMobileWebSearchOptionList();
		}
		
		/**
		 * Gets the parameter options.
		 * 
		 * @return the parameter options
		 */
		private  List<SearchOption> getParameterOptions() {
			return getParameters().getSearchOptionList();
		}

		/**
		 * Gets the parameter sources.
		 * 
		 * @return the parameter sources
		 */
		private  List<SourceType> getParameterSources() {
			return getParameters().getSourceTypeList();
		}

		/**
		 * Gets the video request filters.
		 * 
		 * @return the video request filters
		 */
		private  List<String> getVideoRequestFilters() {
			return getVideoRequest().getFilterList();
		}
		
		/**
		 * Gets the web request options.
		 * 
		 * @return the web request options
		 */
		private  List<WebSearchOption> getWebRequestOptions() {
			return getWebRequest().getWebSearchOptionList();
		}
		
		/**
		 * Gets the web request search tags.
		 * 
		 * @return the web request search tags
		 */
		private  List<String> getWebRequestSearchTags() {
			return getWebRequest().getSearchTagList();
		}
	}

	/* (non-Javadoc)
	 * @see com.bc.search.client.BingSearchClient#newSearchRequestBuilder()
	 */
	@Override
	public SearchRequestBuilder newSearchRequestBuilder() {
		return new SearchRequestBuilderImpl(OBJECT_FACTORY);
	}

	/* (non-Javadoc)
	 * @see com.bc.search.client.impl.BaseBingSearchApiClient#getTaskExecutor()
	 */
	public ExecutorService getTaskExecutor() {
		return taskExecutor;
	}

	/* (non-Javadoc)
	 * @see com.bc.search.client.impl.BaseBingSearchApiClient#setTaskExecutor(java.util.concurrent.ExecutorService)
	 */
	public void setTaskExecutor(ExecutorService taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	
	/**
	 * Gets the gson builder.
	 * 
	 * @return the gson builder
	 */
	protected GsonBuilder getGsonBuilder() {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat(ApplicationConstants.DATE_FORMAT);
		builder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);
//		builder.registerTypeAdapter(Issue.State.class, new JsonDeserializer<Issue.State>() {
//			@Override
//			public Issue.State deserialize(JsonElement arg0, Type arg1,
//					JsonDeserializationContext arg2) throws JsonParseException {
//				return Issue.State.fromValue(arg0.getAsString());
//			}
//		});
		return builder;
	}
    
	/**
	 * Unmarshall.
	 * 
	 * @param jsonContent the json content
	 * 
	 * @return the json object
	 */
	protected JsonObject unmarshall(InputStream jsonContent) {
        try {
        	JsonElement element = parser.parse(new InputStreamReader(jsonContent, UTF_8_CHAR_SET));
        	if (element.isJsonObject()) {
        		return element.getAsJsonObject();
        	} else {
        		throw new BingSearchException("Unknown content found in response." + element);
        	}
        } catch (Exception e) {
            throw new BingSearchException(e);
        } finally {
	        closeStream(jsonContent);
	    }
	}
	
	/**
	 * A factory for creating JsonElement objects.
	 */
	private static class JsonElementFactory {
		
		/**
		 * Instantiates a new json element factory.
		 */
		public JsonElementFactory() {
			super();
		}

		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the deep link
		 */
		public DeepLink createDeepLink() {
			return new DeepLink();
		}

		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the error
		 */
		public Error createError() {
			return new Error();
		}

		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the image request
		 */
		public ImageRequest createImageRequest() {
			return new ImageRequest();
		}

		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the image response
		 */
		public ImageResponse createImageResponse() {
			return new ImageResponse();
		}

		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the image result
		 */
		public ImageResult createImageResult() {
			return new ImageResult();
		}

		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the instant answer response
		 */
		public InstantAnswerResponse createInstantAnswerResponse() {
			return new InstantAnswerResponse();
		}

		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the instant answer result
		 */
		public InstantAnswerResult createInstantAnswerResult() {
			return new InstantAnswerResult();
		}

		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the mobile web request
		 */
		public MobileWebRequest createMobileWebRequest() {
			return new MobileWebRequest();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the mobile web response
		 */
		public MobileWebResponse createMobileWebResponse() {
			return new MobileWebResponse();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the mobile web result
		 */
		public MobileWebResult createMobileWebResult() {
			return new MobileWebResult();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the news article
		 */
		public NewsArticle createNewsArticle() {
			return new NewsArticle();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the news collection
		 */
		public NewsCollection createNewsCollection() {
			return new NewsCollection();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the news related search
		 */
		public NewsRelatedSearch createNewsRelatedSearch() {
			return new NewsRelatedSearch();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the news request
		 */
		public NewsRequest createNewsRequest() {
			return new NewsRequest();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the news response
		 */
		public NewsResponse createNewsResponse() {
			return new NewsResponse();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the news result
		 */
		public NewsResult createNewsResult() {
			return new NewsResult();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the phonebook request
		 */
		public PhonebookRequest createPhonebookRequest() {
			return new PhonebookRequest();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the phonebook response
		 */
		public PhonebookResponse createPhonebookResponse() {
			return new PhonebookResponse();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the phonebook result
		 */
		public PhonebookResult createPhonebookResult() {
			return new PhonebookResult();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the query
		 */
		public Query createQuery() {
			return new Query();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the related search response
		 */
		public RelatedSearchResponse createRelatedSearchResponse() {
			return new RelatedSearchResponse();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the related search result
		 */
		public RelatedSearchResult createRelatedSearchResult() {
			return new RelatedSearchResult();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the search request
		 */
		public SearchRequest createSearchRequest() {
			return new SearchRequest();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the search response
		 */
		public SearchResponse createSearchResponse() {
			return new SearchResponse();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the spell response
		 */
		public SpellResponse createSpellResponse() {
			return new SpellResponse();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the spell result
		 */
		public SpellResult createSpellResult() {
			return new SpellResult();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the thumbnail
		 */
		public Thumbnail createThumbnail() {
			return new Thumbnail();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the translation request
		 */
		public TranslationRequest createTranslationRequest() {
			return new TranslationRequest();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the translation response
		 */
		public TranslationResponse createTranslationResponse() {
			return new TranslationResponse();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the translation result
		 */
		public TranslationResult createTranslationResult() {
			return new TranslationResult();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the video request
		 */
		public VideoRequest createVideoRequest() {
			return new VideoRequest();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the video response
		 */
		public VideoResponse createVideoResponse() {
			return new VideoResponse();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the video result
		 */
		public VideoResult createVideoResult() {
			return new VideoResult();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the web request
		 */
		public WebRequest createWebRequest() {
			return new WebRequest();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the web response
		 */
		public WebResponse createWebResponse() {
			return new WebResponse();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the web result
		 */
		public WebResult createWebResult() {
			return new WebResult();
		}

		
		/**
		 * Creates a new JsonElement object.
		 * 
		 * @return the web search tag
		 */
		public WebSearchTag createWebSearchTag() {
			return new WebSearchTag();
		}
	}
}
