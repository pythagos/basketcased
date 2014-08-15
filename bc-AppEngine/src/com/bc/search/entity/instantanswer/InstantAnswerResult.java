/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */

package com.bc.search.entity.instantanswer;

import com.bc.search.entity.SchemaEntity;


/**
 * The Class InstantAnswerResult.
 */
public class InstantAnswerResult
    extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The content type. */
    protected String contentType;
    
    /** The title. */
    protected String title;
    
    /** The click through url. */
    protected String clickThroughUrl;
    
    /** The url. */
    protected String url;
    
    /** The attribution. */
    protected String attribution;
    
    /** The instant answer specific data. */
    protected InstantAnswerSpecificData instantAnswerSpecificData;

    /**
     * Gets the content type.
     * 
     * @return the content type
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the content type.
     * 
     * @param value the new content type
     */
    public void setContentType(String value) {
        this.contentType = value;
    }

    /**
     * Gets the title.
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     * 
     * @param value the new title
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the click through url.
     * 
     * @return the click through url
     */
    public String getClickThroughUrl() {
        return clickThroughUrl;
    }

    /**
     * Sets the click through url.
     * 
     * @param value the new click through url
     */
    public void setClickThroughUrl(String value) {
        this.clickThroughUrl = value;
    }

    /**
     * Gets the url.
     * 
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     * 
     * @param value the new url
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the attribution.
     * 
     * @return the attribution
     */
    public String getAttribution() {
        return attribution;
    }

    /**
     * Sets the attribution.
     * 
     * @param value the new attribution
     */
    public void setAttribution(String value) {
        this.attribution = value;
    }

    /**
     * Gets the instant answer specific data.
     * 
     * @return the instant answer specific data
     */
    public InstantAnswerSpecificData getInstantAnswerSpecificData() {
        return instantAnswerSpecificData;
    }

    /**
     * Sets the instant answer specific data.
     * 
     * @param value the new instant answer specific data
     */
    public void setInstantAnswerSpecificData(InstantAnswerSpecificData value) {
        this.instantAnswerSpecificData = value;
    }
}
