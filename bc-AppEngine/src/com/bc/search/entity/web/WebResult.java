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

package com.bc.search.entity.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bc.search.entity.SchemaEntity;


/**
 * The Class WebResult.
 */
public class WebResult
    extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The title. */
    protected String title;
    
    /** The description. */
    protected String description;
    
    /** The url. */
    protected String url;
    
    /** The cache url. */
    protected String cacheUrl;
    
    /** The display url. */
    protected String displayUrl;
    
    /** The date time. */
    protected Date dateTime;
    
    /** The search tags. */
    protected List<WebSearchTag> searchTags;
    
    /** The deep links. */
    protected List<DeepLink> deepLinks;

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
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * 
     * @param value the new description
     */
    public void setDescription(String value) {
        this.description = value;
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
     * Gets the cache url.
     * 
     * @return the cache url
     */
    public String getCacheUrl() {
        return cacheUrl;
    }

    /**
     * Sets the cache url.
     * 
     * @param value the new cache url
     */
    public void setCacheUrl(String value) {
        this.cacheUrl = value;
    }

    /**
     * Gets the display url.
     * 
     * @return the display url
     */
    public String getDisplayUrl() {
        return displayUrl;
    }

    /**
     * Sets the display url.
     * 
     * @param value the new display url
     */
    public void setDisplayUrl(String value) {
        this.displayUrl = value;
    }

    /**
     * Gets the date time.
     * 
     * @return the date time
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * Sets the date time.
     * 
     * @param value the new date time
     */
    public void setDateTime(Date value) {
        this.dateTime = value;
    }

    /**
     * Gets the search tags.
     * 
     * @return the search tags
     */
    public List<WebSearchTag> getSearchTags() {
        if (searchTags == null) {
        	searchTags = new ArrayList<WebSearchTag>();
        }
        return this.searchTags;
        
    }

    /**
     * Gets the deep links.
     * 
     * @return the deep links
     */
    public List<DeepLink> getDeepLinks() {
        if (deepLinks == null) {
        	deepLinks = new ArrayList<DeepLink>();
        }
        return this.deepLinks;
    }
}
