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

import java.util.ArrayList;
import java.util.List;

import com.bc.search.entity.SchemaEntity;


/**
 * The Class AdResponse.
 */
public class AdResponse
    extends SchemaEntity
{

    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The total. */
    protected Long total;
    
    /** The page number. */
    protected Long pageNumber;
    
    /** The ad api version. */
    protected Double adApiVersion;
    
    /** The results. */
    protected List<AdResult> results;

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
     * Gets the page number.
     * 
     * @return the page number
     */
    public Long getPageNumber() {
        return pageNumber;
    }

    /**
     * Sets the page number.
     * 
     * @param value the new page number
     */
    public void setPageNumber(Long value) {
        this.pageNumber = value;
    }

    /**
     * Gets the ad api version.
     * 
     * @return the ad api version
     */
    public Double getAdApiVersion() {
        return adApiVersion;
    }

    /**
     * Sets the ad api version.
     * 
     * @param value the new ad api version
     */
    public void setAdApiVersion(Double value) {
        this.adApiVersion = value;
    }

    /**
     * Gets the results.
     * 
     * @return the results
     */
    public List<AdResult> getResults() {
        if (results == null) {
        	results = new ArrayList<AdResult>();
        }
        return this.results;
    }
}
