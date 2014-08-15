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

import java.util.ArrayList;
import java.util.List;

import com.bc.search.entity.SchemaEntity;

/**
 * The Class VideoRequest.
 */
public class VideoRequest extends SchemaEntity {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -387064944800851035L;
	
	/** The offset. */
	protected Long offset;
    
    /** The count. */
    protected Long count;
    
    /** The sort by. */
    protected VideoSortOption sortBy;
	
	/** The filter list. */
	protected List<String> filterList;

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
     * Gets the sort by.
     * 
     * @return the sort by
     */
    public VideoSortOption getSortBy() {
        return sortBy;
    }

    /**
     * Sets the sort by.
     * 
     * @param value the new sort by
     */
    public void setSortBy(VideoSortOption value) {
        this.sortBy = value;
    }

	/**
	 * Gets the filter list.
	 * 
	 * @return the filter list
	 */
	public List<String> getFilterList() {
        if (filterList == null) {
        	filterList = new ArrayList<String>();
        }
        return this.filterList;
	}
}