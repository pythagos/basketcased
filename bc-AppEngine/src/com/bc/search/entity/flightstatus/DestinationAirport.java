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

package com.bc.search.entity.flightstatus;

import com.bc.search.entity.SchemaEntity;



/**
 * The Class DestinationAirport.
 */
public class DestinationAirport
	extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The code. */
    protected String code;
    
    /** The name. */
    protected String name;
    
    /** The time zone offset. */
    protected Long timeZoneOffset;

    /**
     * Gets the code.
     * 
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code.
     * 
     * @param value the new code
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * 
     * @param value the new name
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the time zone offset.
     * 
     * @return the time zone offset
     */
    public Long getTimeZoneOffset() {
        return timeZoneOffset;
    }

    /**
     * Sets the time zone offset.
     * 
     * @param value the new time zone offset
     */
    public void setTimeZoneOffset(Long value) {
        this.timeZoneOffset = value;
    }
}
