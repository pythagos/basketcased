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

package com.bc.search.entity.multimedia;

import com.bc.search.entity.SchemaEntity;


/**
 * The Class VideoResult.
 */
public class VideoResult
    extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The title. */
    protected String title;
    
    /** The play url. */
    protected String playUrl;
    
    /** The source title. */
    protected String sourceTitle;
    
    /** The run time. */
    protected Long runTime;
    
    /** The click through page url. */
    protected String clickThroughPageUrl;
    
    /** The static thumbnail. */
    protected StaticThumbnail staticThumbnail;

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
     * Gets the play url.
     * 
     * @return the play url
     */
    public String getPlayUrl() {
        return playUrl;
    }

    /**
     * Sets the play url.
     * 
     * @param value the new play url
     */
    public void setPlayUrl(String value) {
        this.playUrl = value;
    }

    /**
     * Gets the source title.
     * 
     * @return the source title
     */
    public String getSourceTitle() {
        return sourceTitle;
    }

    /**
     * Sets the source title.
     * 
     * @param value the new source title
     */
    public void setSourceTitle(String value) {
        this.sourceTitle = value;
    }

    /**
     * Gets the run time.
     * 
     * @return the run time
     */
    public Long getRunTime() {
        return runTime;
    }

    /**
     * Sets the run time.
     * 
     * @param value the new run time
     */
    public void setRunTime(Long value) {
        this.runTime = value;
    }

    /**
     * Gets the click through page url.
     * 
     * @return the click through page url
     */
    public String getClickThroughPageUrl() {
        return clickThroughPageUrl;
    }

    /**
     * Sets the click through page url.
     * 
     * @param value the new click through page url
     */
    public void setClickThroughPageUrl(String value) {
        this.clickThroughPageUrl = value;
    }

    /**
     * Gets the static thumbnail.
     * 
     * @return the static thumbnail
     */
    public StaticThumbnail getStaticThumbnail() {
        return staticThumbnail;
    }

    /**
     * Sets the static thumbnail.
     * 
     * @param value the new static thumbnail
     */
    public void setStaticThumbnail(StaticThumbnail value) {
        this.staticThumbnail = value;
    }
}
