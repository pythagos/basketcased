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

package com.bc.search.entity.instantanswer;

import java.util.ArrayList;
import java.util.List;

import com.bc.search.entity.SchemaEntity;


/**
 * The Class InstantAnswerResponse.
 */
public class InstantAnswerResponse
    extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The results. */
    protected List<InstantAnswerResult> results;

    /**
     * Gets the results.
     * 
     * @return the results
     */
    public List<InstantAnswerResult> getResults() {
        if (results == null) {
        	results = new ArrayList<InstantAnswerResult>();
        }
        return this.results;
    }
}
