package com.bc.search.entity;


import com.bc.search.entity.ads.AdResponse;
import com.bc.search.entity.instantanswer.InstantAnswerResponse;
import com.bc.search.entity.mobileweb.MobileWebResponse;
import com.bc.search.entity.multimedia.ImageResponse;
import com.bc.search.entity.multimedia.VideoResponse;
import com.bc.search.entity.news.NewsResponse;
import com.bc.search.entity.phonebook.PhonebookResponse;
import com.bc.search.entity.relatedsearch.RelatedSearchResponse;
import com.bc.search.entity.spell.SpellResponse;
import com.bc.search.entity.translation.TranslationResponse;
import com.bc.search.entity.web.WebResponse;


/**
 * The Class SearchResponse.
 */
public class SearchResponse
    extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The query. */
    protected Query query;
    
    /** The ad. */
    protected AdResponse ad;
    
    /** The instant answer. */
    protected InstantAnswerResponse instantAnswer;
    
    /** The mobile web. */
    protected MobileWebResponse mobileWeb;
    
    /** The image. */
    protected ImageResponse image;
    
    /** The video. */
    protected VideoResponse video;
    
    /** The phonebook. */
    protected PhonebookResponse phonebook;
    
    /** The related search. */
    protected RelatedSearchResponse relatedSearch;
    
    /** The spell. */
    protected SpellResponse spell;
    
    /** The news. */
    protected NewsResponse news;
    
    /** The translation. */
    protected TranslationResponse translation;
    
    /** The web. */
    protected WebResponse web;
    
    /** The version. */
    protected Double version;

    /**
     * Gets the query.
     * 
     * @return the query
     */
    public Query getQuery() {
        return query;
    }

    /**
     * Sets the query.
     * 
     * @param value the new query
     */
    public void setQuery(Query value) {
        this.query = value;
    }

    /**
     * Gets the ad.
     * 
     * @return the ad
     */
    public AdResponse getAd() {
        return ad;
    }

    /**
     * Sets the ad.
     * 
     * @param value the new ad
     */
    public void setAd(AdResponse value) {
        this.ad = value;
    }

    /**
     * Gets the instant answer.
     * 
     * @return the instant answer
     */
    public InstantAnswerResponse getInstantAnswer() {
        return instantAnswer;
    }

    /**
     * Sets the instant answer.
     * 
     * @param value the new instant answer
     */
    public void setInstantAnswer(InstantAnswerResponse value) {
        this.instantAnswer = value;
    }

    /**
     * Gets the mobile web.
     * 
     * @return the mobile web
     */
    public MobileWebResponse getMobileWeb() {
        return mobileWeb;
    }

    /**
     * Sets the mobile web.
     * 
     * @param value the new mobile web
     */
    public void setMobileWeb(MobileWebResponse value) {
        this.mobileWeb = value;
    }

    /**
     * Gets the image.
     * 
     * @return the image
     */
    public ImageResponse getImage() {
        return image;
    }

    /**
     * Sets the image.
     * 
     * @param value the new image
     */
    public void setImage(ImageResponse value) {
        this.image = value;
    }

    /**
     * Gets the video.
     * 
     * @return the video
     */
    public VideoResponse getVideo() {
        return video;
    }

    /**
     * Sets the video.
     * 
     * @param value the new video
     */
    public void setVideo(VideoResponse value) {
        this.video = value;
    }

    /**
     * Gets the phonebook.
     * 
     * @return the phonebook
     */
    public PhonebookResponse getPhonebook() {
        return phonebook;
    }

    /**
     * Sets the phonebook.
     * 
     * @param value the new phonebook
     */
    public void setPhonebook(PhonebookResponse value) {
        this.phonebook = value;
    }

    /**
     * Gets the related search.
     * 
     * @return the related search
     */
    public RelatedSearchResponse getRelatedSearch() {
        return relatedSearch;
    }

    /**
     * Sets the related search.
     * 
     * @param value the new related search
     */
    public void setRelatedSearch(RelatedSearchResponse value) {
        this.relatedSearch = value;
    }

    /**
     * Gets the spell.
     * 
     * @return the spell
     */
    public SpellResponse getSpell() {
        return spell;
    }

    /**
     * Sets the spell.
     * 
     * @param value the new spell
     */
    public void setSpell(SpellResponse value) {
        this.spell = value;
    }

    /**
     * Gets the news.
     * 
     * @return the news
     */
    public NewsResponse getNews() {
        return news;
    }

    /**
     * Sets the news.
     * 
     * @param value the new news
     */
    public void setNews(NewsResponse value) {
        this.news = value;
    }

    /**
     * Gets the translation.
     * 
     * @return the translation
     */
    public TranslationResponse getTranslation() {
        return translation;
    }

    /**
     * Sets the translation.
     * 
     * @param value the new translation
     */
    public void setTranslation(TranslationResponse value) {
        this.translation = value;
    }

    /**
     * Gets the web.
     * 
     * @return the web
     */
    public WebResponse getWeb() {
        return web;
    }

    /**
     * Sets the web.
     * 
     * @param value the new web
     */
    public void setWeb(WebResponse value) {
        this.web = value;
    }

    /**
     * Gets the version.
     * 
     * @return the version
     */
    public Double getVersion() {
        return version;
    }

    /**
     * Sets the version.
     * 
     * @param value the new version
     */
    public void setVersion(Double value) {
        this.version = value;
    }
}
