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
 * The Class PreviousSegment.
 */
public class PreviousSegment
extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The flight history id. */
    protected Long flightHistoryId;
    
    /** The origin airport. */
    protected OriginAirport originAirport;
    
    /** The destination airport. */
    protected DestinationAirport destinationAirport;

    /**
     * Gets the flight history id.
     * 
     * @return the flight history id
     */
    public Long getFlightHistoryId() {
        return flightHistoryId;
    }

    /**
     * Sets the flight history id.
     * 
     * @param value the new flight history id
     */
    public void setFlightHistoryId(Long value) {
        this.flightHistoryId = value;
    }

    /**
     * Gets the origin airport.
     * 
     * @return the origin airport
     */
    public OriginAirport getOriginAirport() {
        return originAirport;
    }

    /**
     * Sets the origin airport.
     * 
     * @param value the new origin airport
     */
    public void setOriginAirport(OriginAirport value) {
        this.originAirport = value;
    }

    /**
     * Gets the destination airport.
     * 
     * @return the destination airport
     */
    public DestinationAirport getDestinationAirport() {
        return destinationAirport;
    }

    /**
     * Sets the destination airport.
     * 
     * @param value the new destination airport
     */
    public void setDestinationAirport(DestinationAirport value) {
        this.destinationAirport = value;
    }
}
