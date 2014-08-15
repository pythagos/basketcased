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
package com.bc.search.entity.phonebook;

import com.bc.search.entity.SchemaEntity;

/**
 * The Class PhonebookRequest.
 */
public class PhonebookRequest 
	extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7837729787903858018L;
	
	/** The offset. */
	protected Long offset;
    
    /** The count. */
    protected Long count;
    
    /** The file type. */
    protected String fileType;
    
    /** The sort by. */
    protected PhonebookSortOption sortBy;
    
    /** The loc id. */
    protected String locId;
    
    /** The category. */
    protected String category;

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
     * Gets the file type.
     * 
     * @return the file type
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * Sets the file type.
     * 
     * @param value the new file type
     */
    public void setFileType(String value) {
        this.fileType = value;
    }

    /**
     * Gets the sort by.
     * 
     * @return the sort by
     */
    public PhonebookSortOption getSortBy() {
        return sortBy;
    }

    /**
     * Sets the sort by.
     * 
     * @param value the new sort by
     */
    public void setSortBy(PhonebookSortOption value) {
        this.sortBy = value;
    }

    /**
     * Gets the loc id.
     * 
     * @return the loc id
     */
    public String getLocId() {
        return locId;
    }

    /**
     * Sets the loc id.
     * 
     * @param value the new loc id
     */
    public void setLocId(String value) {
        this.locId = value;
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
}