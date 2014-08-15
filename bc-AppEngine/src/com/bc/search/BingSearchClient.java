package com.bc.search;

import java.util.concurrent.Future;

import com.bc.search.entity.AdultOption;
import com.bc.search.entity.SearchOption;
import com.bc.search.entity.SearchRequest;
import com.bc.search.entity.SearchResponse;
import com.bc.search.entity.SourceType;
import com.bc.search.entity.mobileweb.MobileWebSearchOption;
import com.bc.search.entity.multimedia.VideoSortOption;
import com.bc.search.entity.news.NewsSortOption;
import com.bc.search.entity.phonebook.PhonebookSortOption;
import com.bc.search.entity.web.WebSearchOption;

/**
 * The Interface BingSearchClient.
 */
public interface BingSearchClient {
	
	/**
	 * New search request builder.
	 * 
	 * @return the search request builder
	 */
	public SearchRequestBuilder newSearchRequestBuilder();
	
	/**
	 * Search.
	 * 
	 * @param request the request
	 * 
	 * @return the search response
	 */
	public SearchResponse search(SearchRequest request);
	
//	public ImageResponse search(ImageRequest request);
//	public AdResponse search(AdRequest request);
//	public InstantAnswerResponse search(InstantAnswerRequest request);
//	public MobileWebResponse search(MobileWebRequest request);
//	public VideoResponse search(VideoRequest request);
//	public PhonebookResponse search(PhonebookRequest request);
//	public RelatedSearchResponse search(RelatedSearchRequest request);
//	public SpellResponse search(SpellRequest request);
//	public NewsResponse search(NewsRequest request);
//	public TranslationResponse search(TranslationRequest request);
//	public WebResponse search(WebRequest request);
	
	/**
 * Search async.
 * 
 * @param request the request
 * 
 * @return the future< search response>
 */
public Future<SearchResponse> searchAsync(SearchRequest request);
	
//	public Future<ImageResponse> searchAsync(ImageRequest request);
//	public Future<AdResponse> searchAsync(AdRequest request);
//	public Future<InstantAnswerResponse> searchAsync(InstantAnswerRequest request);
//	public Future<MobileWebResponse> searchAsync(MobileWebRequest request);
//	public Future<VideoResponse> searchAsync(VideoRequest request);
//	public Future<PhonebookResponse> searchAsync(PhonebookRequest request);
//	public Future<RelatedSearchResponse> searchAsync(RelatedSearchRequest request);
//	public Future<SpellResponse> searchAsync(SpellRequest request);
//	public Future<NewsResponse> searchAsync(NewsRequest request);
//	public Future<TranslationResponse> searchAsync(TranslationRequest request);
//	public Future<WebResponse> searchAsync(WebRequest request);
	
	/**
 * The Interface SearchRequestBuilder.
 */
public interface SearchRequestBuilder {
		
		/**
		 * With app id.
		 * 
		 * @param applicationId the application id
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withAppId(String applicationId);
		
		/**
		 * With version.
		 * 
		 * @param version the version
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withVersion(String version);
		
		/**
		 * With market.
		 * 
		 * @param market the market
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withMarket(String market);
		
		/**
		 * With ui language.
		 * 
		 * @param uiLanguage the ui language
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withUILanguage(String uiLanguage);
		
		/**
		 * With query.
		 * 
		 * @param query the query
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withQuery(String query);
		
		/**
		 * With adult option.
		 * 
		 * @param adult the adult
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withAdultOption(AdultOption adult);
		
		/**
		 * With latitude.
		 * 
		 * @param latitude the latitude
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withLatitude(Double latitude);
		
		/**
		 * With longitude.
		 * 
		 * @param longitude the longitude
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withLongitude(Double longitude);
		
		/**
		 * With radius.
		 * 
		 * @param radius the radius
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withRadius(Double radius);
		
		/**
		 * With search option.
		 * 
		 * @param searchOption the search option
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withSearchOption(SearchOption searchOption);
		
		/**
		 * With source type.
		 * 
		 * @param sourceType the source type
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withSourceType(SourceType sourceType);
		
		/**
		 * With web request offset.
		 * 
		 * @param offset the offset
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withWebRequestOffset(Long offset);
		
		/**
		 * With web request count.
		 * 
		 * @param count the count
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withWebRequestCount(Long count);
		
		/**
		 * With web request file type.
		 * 
		 * @param fileType the file type
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withWebRequestFileType(String fileType);
		
		/**
		 * With web request search option.
		 * 
		 * @param webSearchOption the web search option
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withWebRequestSearchOption(WebSearchOption webSearchOption);
		
		/**
		 * With web request search tag.
		 * 
		 * @param searchTag the search tag
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withWebRequestSearchTag(String searchTag);
		
		/**
		 * With image request offset.
		 * 
		 * @param offset the offset
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withImageRequestOffset(Long offset);
		
		/**
		 * With image request count.
		 * 
		 * @param count the count
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withImageRequestCount(Long count);
		
		/**
		 * With image request filter.
		 * 
		 * @param filter the filter
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withImageRequestFilter(String filter);
		
		/**
		 * With phonebook request offset.
		 * 
		 * @param offset the offset
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withPhonebookRequestOffset(Long offset);
		
		/**
		 * With phonebook request count.
		 * 
		 * @param count the count
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withPhonebookRequestCount(Long count);
		
		/**
		 * With phonebook request file type.
		 * 
		 * @param fileType the file type
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withPhonebookRequestFileType(String fileType);
		
		/**
		 * With phonebook request sort option.
		 * 
		 * @param phonebookSortOption the phonebook sort option
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withPhonebookRequestSortOption(PhonebookSortOption phonebookSortOption);
		
		/**
		 * With phonebook request loc id.
		 * 
		 * @param locId the loc id
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withPhonebookRequestLocId(String locId);
		
		/**
		 * With phonebook request category.
		 * 
		 * @param category the category
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withPhonebookRequestCategory(String category);
		
		/**
		 * With video request offset.
		 * 
		 * @param offset the offset
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withVideoRequestOffset(Long offset);
		
		/**
		 * With video request count.
		 * 
		 * @param count the count
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withVideoRequestCount(Long count);
		
		/**
		 * With video request filter.
		 * 
		 * @param filter the filter
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withVideoRequestFilter(String filter);
		
		/**
		 * With video request sort option.
		 * 
		 * @param videoSortOption the video sort option
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withVideoRequestSortOption(VideoSortOption videoSortOption);
		
		/**
		 * With news request offset.
		 * 
		 * @param offset the offset
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withNewsRequestOffset(Long offset);
		
		/**
		 * With news request count.
		 * 
		 * @param count the count
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withNewsRequestCount(Long count);
		
		/**
		 * With news request location override.
		 * 
		 * @param locationOverride the location override
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withNewsRequestLocationOverride(String locationOverride);
		
		/**
		 * With news request category.
		 * 
		 * @param category the category
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withNewsRequestCategory(String category);
		
		/**
		 * With news request sort option.
		 * 
		 * @param newsSortOption the news sort option
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withNewsRequestSortOption(NewsSortOption newsSortOption);
		
		/**
		 * With mobile web request offset.
		 * 
		 * @param offset the offset
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withMobileWebRequestOffset(Long offset);
		
		/**
		 * With mobile web request count.
		 * 
		 * @param count the count
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withMobileWebRequestCount(Long count);
		
		/**
		 * With mobile web request search option.
		 * 
		 * @param mobileWebSearchOption the mobile web search option
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withMobileWebRequestSearchOption(MobileWebSearchOption mobileWebSearchOption);
		
		/**
		 * With translation request source language.
		 * 
		 * @param sourceLanguage the source language
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withTranslationRequestSourceLanguage(String sourceLanguage);
		
		/**
		 * With translation request target language.
		 * 
		 * @param targetLanguage the target language
		 * 
		 * @return the search request builder
		 */
		public SearchRequestBuilder withTranslationRequestTargetLanguage(String targetLanguage);
		
		/**
		 * Gets the result.
		 * 
		 * @return the result
		 */
		public SearchRequest getResult();
		
		/**
		 * Reset.
		 */
		public void reset();
	}
}
