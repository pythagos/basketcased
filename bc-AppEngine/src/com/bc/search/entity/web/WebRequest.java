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
import java.util.List;

import com.bc.search.entity.SchemaEntity;

/**
 * The Class WebRequest.
 */
public class WebRequest 
	extends SchemaEntity
{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2076030033305153442L;
	
	/** The offset. */
	protected Long offset;
    
    /** The count. */
    protected Long count;
    
    /** The file type. */
    protected String fileType;
    
    /** The search tag list. */
    protected List<String> searchTagList;
    
    /** The web search option list. */
    protected List<WebSearchOption> webSearchOptionList;

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
	 * Gets the search tag list.
	 * 
	 * @return the search tag list
	 */
	public List<String> getSearchTagList() {
		if (searchTagList == null) {
			searchTagList = new ArrayList<String>();
		}
		return searchTagList;
	}

	/**
	 * Gets the web search option list.
	 * 
	 * @return the web search option list
	 */
	public List<WebSearchOption> getWebSearchOptionList() {
		if (webSearchOptionList == null) {
			webSearchOptionList = new ArrayList<WebSearchOption>();
		}
		return webSearchOptionList;
	}

	/**
	 * Sets the search tag list.
	 * 
	 * @param value the new search tag list
	 */
	public void setSearchTagList(List<String> value) {
		searchTagList = value;
	}

	/**
	 * Sets the web search option list.
	 * 
	 * @param value the new web search option list
	 */
	public void setWebSearchOptionList(List<WebSearchOption> value) {
		webSearchOptionList = value;
	}
}