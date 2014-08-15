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
 * The Class ImageRequest.
 */
public class ImageRequest 
	extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1726990456300068785L;
	
	/** The offset. */
	protected Long offset;
    
    /** The count. */
    protected Long count;
	
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
	 * Gets the filter list.
	 * 
	 * @return the filter list
	 */
	public List<String> getFilterList() {
		if (filterList == null) {
			filterList = new ArrayList<String>();
		}
		return filterList;
	}

	/**
	 * Sets the filter list.
	 * 
	 * @param value the new filter list
	 */
	public void setFilterList(List<String> value) {
		filterList = value;
	}
}