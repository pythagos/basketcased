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

import com.bc.search.entity.SchemaEntity;
import com.bc.search.entity.encarta.Encarta;
import com.bc.search.entity.flightstatus.FlightStatus;


/**
 * The Class InstantAnswerSpecificData.
 */
public class InstantAnswerSpecificData
    extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The flight status. */
    protected FlightStatus flightStatus;
    
    /** The encarta. */
    protected Encarta encarta;

    /**
     * Gets the flight status.
     * 
     * @return the flight status
     */
    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    /**
     * Sets the flight status.
     * 
     * @param value the new flight status
     */
    public void setFlightStatus(FlightStatus value) {
        this.flightStatus = value;
    }

    /**
     * Gets the encarta.
     * 
     * @return the encarta
     */
    public Encarta getEncarta() {
        return encarta;
    }

    /**
     * Sets the encarta.
     * 
     * @param value the new encarta
     */
    public void setEncarta(Encarta value) {
        this.encarta = value;
    }
}
