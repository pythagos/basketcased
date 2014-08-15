package com.bc.search.entity;


import java.util.ArrayList;
import java.util.List;

import com.bc.search.entity.mobileweb.MobileWebRequest;
import com.bc.search.entity.multimedia.ImageRequest;
import com.bc.search.entity.multimedia.VideoRequest;
import com.bc.search.entity.news.NewsRequest;
import com.bc.search.entity.phonebook.PhonebookRequest;
import com.bc.search.entity.translation.TranslationRequest;
import com.bc.search.entity.web.WebRequest;

/**
 * The Class SearchRequest.
 */
public class SearchRequest 
	extends SchemaEntity
{

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 855215031852452888L;
	
	/** The version. */
	protected String version;
    
    /** The market. */
    protected String market;
    
    /** The ui language. */
    protected String uiLanguage;
    
    /** The query. */
    protected String query;
    
    /** The app id. */
    protected String appId;
    
    /** The adult. */
    protected AdultOption adult;
    
    /** The latitude. */
    protected Double latitude;
    
    /** The longitude. */
    protected Double longitude;
    
    /** The radius. */
    protected Double radius;
    
    /** The web. */
    protected WebRequest web;
    
    /** The image. */
    protected ImageRequest image;
    
    /** The phonebook. */
    protected PhonebookRequest phonebook;
    
    /** The video. */
    protected VideoRequest video;
    
    /** The news. */
    protected NewsRequest news;
    
    /** The mobile web. */
    protected MobileWebRequest mobileWeb;
    
    /** The translation. */
    protected TranslationRequest translation;
    
    /** The search option list. */
    protected List<SearchOption> searchOptionList;
    
    /** The source type list. */
    protected List<SourceType> sourceTypeList;

    /**
     * Gets the version.
     * 
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the version.
     * 
     * @param value the new version
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the market.
     * 
     * @return the market
     */
    public String getMarket() {
        return market;
    }

    /**
     * Sets the market.
     * 
     * @param value the new market
     */
    public void setMarket(String value) {
        this.market = value;
    }

    /**
     * Gets the uI language.
     * 
     * @return the uI language
     */
    public String getUILanguage() {
        return uiLanguage;
    }

    /**
     * Sets the uI language.
     * 
     * @param value the new uI language
     */
    public void setUILanguage(String value) {
        this.uiLanguage = value;
    }

    /**
     * Gets the query.
     * 
     * @return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * Sets the query.
     * 
     * @param value the new query
     */
    public void setQuery(String value) {
        this.query = value;
    }

    /**
     * Gets the app id.
     * 
     * @return the app id
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Sets the app id.
     * 
     * @param value the new app id
     */
    public void setAppId(String value) {
        this.appId = value;
    }

    /**
     * Gets the adult.
     * 
     * @return the adult
     */
    public AdultOption getAdult() {
        return adult;
    }

    /**
     * Sets the adult.
     * 
     * @param value the new adult
     */
    public void setAdult(AdultOption value) {
        this.adult = value;
    }

    /**
     * Gets the latitude.
     * 
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude.
     * 
     * @param value the new latitude
     */
    public void setLatitude(Double value) {
        this.latitude = value;
    }

    /**
     * Gets the longitude.
     * 
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude.
     * 
     * @param value the new longitude
     */
    public void setLongitude(Double value) {
        this.longitude = value;
    }

    /**
     * Gets the radius.
     * 
     * @return the radius
     */
    public Double getRadius() {
        return radius;
    }

    /**
     * Sets the radius.
     * 
     * @param value the new radius
     */
    public void setRadius(Double value) {
        this.radius = value;
    }

    /**
     * Gets the web request.
     * 
     * @return the web request
     */
    public WebRequest getWebRequest() {
        return web;
    }

    /**
     * Sets the web request.
     * 
     * @param value the new web request
     */
    public void setWebRequest(WebRequest value) {
        this.web = value;
    }

    /**
     * Gets the image request.
     * 
     * @return the image request
     */
    public ImageRequest getImageRequest() {
        return image;
    }

    /**
     * Sets the image request.
     * 
     * @param value the new image request
     */
    public void setImageRequest(ImageRequest value) {
        this.image = value;
    }

    /**
     * Gets the phonebook request.
     * 
     * @return the phonebook request
     */
    public PhonebookRequest getPhonebookRequest() {
        return phonebook;
    }

    /**
     * Sets the phonebook request.
     * 
     * @param value the new phonebook request
     */
    public void setPhonebookRequest(PhonebookRequest value) {
        this.phonebook = value;
    }

    /**
     * Gets the video request.
     * 
     * @return the video request
     */
    public VideoRequest getVideoRequest() {
        return video;
    }

    /**
     * Sets the video request.
     * 
     * @param value the new video request
     */
    public void setVideoRequest(VideoRequest value) {
        this.video = value;
    }

    /**
     * Gets the news request.
     * 
     * @return the news request
     */
    public NewsRequest getNewsRequest() {
        return news;
    }

    /**
     * Sets the news request.
     * 
     * @param value the new news request
     */
    public void setNewsRequest(NewsRequest value) {
        this.news = value;
    }

    /**
     * Gets the mobile web request.
     * 
     * @return the mobile web request
     */
    public MobileWebRequest getMobileWebRequest() {
        return mobileWeb;
    }

    /**
     * Sets the mobile web request.
     * 
     * @param value the new mobile web request
     */
    public void setMobileWebRequest(MobileWebRequest value) {
        this.mobileWeb = value;
    }

    /**
     * Gets the translation request.
     * 
     * @return the translation request
     */
    public TranslationRequest getTranslationRequest() {
        return translation;
    }

    /**
     * Sets the translation request.
     * 
     * @param value the new translation request
     */
    public void setTranslationRequest(TranslationRequest value) {
        this.translation = value;
    }

	/**
	 * Gets the search option list.
	 * 
	 * @return the search option list
	 */
	public List<SearchOption> getSearchOptionList() {
		if (searchOptionList == null) {
			searchOptionList = new ArrayList<SearchOption>();
		}
		return searchOptionList;
	}

	/**
	 * Gets the source type list.
	 * 
	 * @return the source type list
	 */
	public List<SourceType> getSourceTypeList() {
		if (sourceTypeList == null) {
			sourceTypeList = new ArrayList<SourceType>();
		}
		return sourceTypeList;
	}

	/**
	 * Sets the search option list.
	 * 
	 * @param searchOption the new search option list
	 */
	public void setSearchOptionList(List<SearchOption> searchOption) {
		searchOptionList = searchOption;
	}

	/**
	 * Sets the source type list.
	 * 
	 * @param value the new source type list
	 */
	public void setSourceTypeList(List<SourceType> value) {
		sourceTypeList = value;
	}
}