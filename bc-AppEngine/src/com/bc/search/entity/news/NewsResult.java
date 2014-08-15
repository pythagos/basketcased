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

package com.bc.search.entity.news;

import java.util.ArrayList;
import java.util.List;

import com.bc.search.entity.SchemaEntity;


/**
 * The Class NewsResult.
 */
public class NewsResult
    extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The title. */
    protected String title;
    
    /** The url. */
    protected String url;
    
    /** The source. */
    protected String source;
    
    /** The snippet. */
    protected String snippet;
    
    /** The date. */
    protected String date;
    
    /** The breaking news. */
    protected Long breakingNews;
    
    /** The news collections. */
    protected List<NewsCollection> newsCollections;

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
     * Gets the source.
     * 
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the source.
     * 
     * @param value the new source
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the snippet.
     * 
     * @return the snippet
     */
    public String getSnippet() {
        return snippet;
    }

    /**
     * Sets the snippet.
     * 
     * @param value the new snippet
     */
    public void setSnippet(String value) {
        this.snippet = value;
    }

    /**
     * Gets the date.
     * 
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date.
     * 
     * @param value the new date
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the breaking news.
     * 
     * @return the breaking news
     */
    public Long getBreakingNews() {
        return breakingNews;
    }

    /**
     * Sets the breaking news.
     * 
     * @param value the new breaking news
     */
    public void setBreakingNews(Long value) {
        this.breakingNews = value;
    }

    /**
     * Gets the news collections.
     * 
     * @return the news collections
     */
    public List<NewsCollection> getNewsCollections() {
        if (newsCollections == null) {
        	newsCollections = new ArrayList<NewsCollection>();
        }
        return this.newsCollections;
    }
}
