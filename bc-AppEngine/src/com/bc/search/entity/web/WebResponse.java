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
 * The Class WebResponse.
 */
public class WebResponse
    extends SchemaEntity
{

    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The total. */
    protected Long total;
    
    /** The offset. */
    protected Long offset;
    
    /** The results. */
    protected List<WebResult> results;

    /**
     * Gets the total.
     * 
     * @return the total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * Sets the total.
     * 
     * @param value the new total
     */
    public void setTotal(Long value) {
        this.total = value;
    }

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
     * Gets the results.
     * 
     * @return the results
     */
    public List<WebResult> getResults() {
        if (results == null) {
        	results = new ArrayList<WebResult>();
        }
        return this.results;
    }
}
