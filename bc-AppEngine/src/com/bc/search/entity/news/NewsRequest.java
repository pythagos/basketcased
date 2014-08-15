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

import com.bc.search.entity.SchemaEntity;

/**
 * The Class NewsRequest.
 */
public class NewsRequest 
	extends SchemaEntity
{

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6039628585958033583L;
	
	/** The offset. */
	protected Long offset;
    
    /** The count. */
    protected Long count;
    
    /** The location override. */
    protected String locationOverride;
    
    /** The category. */
    protected String category;
    
    /** The sort by. */
    protected NewsSortOption sortBy;

    /**
     * Gets the offset.
     * 
     * @return the offset
     */
    public Long getOffset() {
        return offset;
    }

    /**
     * Sets the offset.
     * 
     * @param value the new offset
     */
    public void setOffset(Long value) {
        this.offset = value;
    }

    /**
     * Gets the count.
     * 
     * @return the count
     */
    public Long getCount() {
        return count;
    }

    /**
     * Sets the count.
     * 
     * @param value the new count
     */
    public void setCount(Long value) {
        this.count = value;
    }

    /**
     * Gets the location override.
     * 
     * @return the location override
     */
    public String getLocationOverride() {
        return locationOverride;
    }

    /**
     * Sets the location override.
     * 
     * @param value the new location override
     */
    public void setLocationOverride(String value) {
        this.locationOverride = value;
    }

    /**
     * Gets the category.
     * 
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category.
     * 
     * @param value the new category
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the sort by.
     * 
     * @return the sort by
     */
    public NewsSortOption getSortBy() {
        return sortBy;
    }

    /**
     * Sets the sort by.
     * 
     * @param value the new sort by
     */
    public void setSortBy(NewsSortOption value) {
        this.sortBy = value;
    }
}