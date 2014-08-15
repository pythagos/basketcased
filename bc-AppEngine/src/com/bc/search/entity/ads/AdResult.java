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

package com.bc.search.entity.ads;

import com.bc.search.entity.SchemaEntity;


/**
 * The Class AdResult.
 */
public class AdResult
    extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The rank. */
    protected Long rank;
    
    /** The position. */
    protected String position;
    
    /** The title. */
    protected String title;
    
    /** The description. */
    protected String description;
    
    /** The display url. */
    protected String displayUrl;
    
    /** The ad link url. */
    protected String adLinkUrl;

    /**
     * Gets the rank.
     * 
     * @return the rank
     */
    public Long getRank() {
        return rank;
    }

    /**
     * Sets the rank.
     * 
     * @param value the new rank
     */
    public void setRank(Long value) {
        this.rank = value;
    }

    /**
     * Gets the position.
     * 
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the position.
     * 
     * @param value the new position
     */
    public void setPosition(String value) {
        this.position = value;
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
     * Gets the ad link url.
     * 
     * @return the ad link url
     */
    public String getAdLinkUrl() {
        return adLinkUrl;
    }

    /**
     * Sets the ad link url.
     * 
     * @param value the new ad link url
     */
    public void setAdLinkUrl(String value) {
        this.adLinkUrl = value;
    }
}
