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

import java.util.Date;

import com.bc.search.entity.SchemaEntity;



/**
 * The Class FlightStatus.
 */
public class FlightStatus
extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The airline code. */
    protected String airlineCode;
    
    /** The airline name. */
    protected String airlineName;
    
    /** The flight number. */
    protected String flightNumber;
    
    /** The flight name. */
    protected String flightName;
    
    /** The flight history id. */
    protected Long flightHistoryId;
    
    /** The status string. */
    protected String statusString;
    
    /** The status code. */
    protected Long statusCode;
    
    /** The on time string. */
    protected String onTimeString;
    
    /** The scheduled departure. */
    protected Date scheduledDeparture;
    
    /** The updated departure. */
    protected Date updatedDeparture;
    
    /** The scheduled arrival. */
    protected Date scheduledArrival;
    
    /** The updated arrival. */
    protected Date updatedArrival;
    
    /** The origin airport. */
    protected OriginAirport originAirport;
    
    /** The destination airport. */
    protected DestinationAirport destinationAirport;
    
    /** The departure gate. */
    protected String departureGate;
    
    /** The departure terminal. */
    protected String departureTerminal;
    
    /** The arrival gate. */
    protected String arrivalGate;
    
    /** The arrival terminal. */
    protected String arrivalTerminal;
    
    /** The previous segment. */
    protected PreviousSegment previousSegment;
    
    /** The next segment. */
    protected NextSegment nextSegment;
    
    /** The data freshness. */
    protected Long dataFreshness;

    /**
     * Gets the airline code.
     * 
     * @return the airline code
     */
    public String getAirlineCode() {
        return airlineCode;
    }

    /**
     * Sets the airline code.
     * 
     * @param value the new airline code
     */
    public void setAirlineCode(String value) {
        this.airlineCode = value;
    }

    /**
     * Gets the airline name.
     * 
     * @return the airline name
     */
    public String getAirlineName() {
        return airlineName;
    }

    /**
     * Sets the airline name.
     * 
     * @param value the new airline name
     */
    public void setAirlineName(String value) {
        this.airlineName = value;
    }

    /**
     * Gets the flight number.
     * 
     * @return the flight number
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets the flight number.
     * 
     * @param value the new flight number
     */
    public void setFlightNumber(String value) {
        this.flightNumber = value;
    }

    /**
     * Gets the flight name.
     * 
     * @return the flight name
     */
    public String getFlightName() {
        return flightName;
    }

    /**
     * Sets the flight name.
     * 
     * @param value the new flight name
     */
    public void setFlightName(String value) {
        this.flightName = value;
    }

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
     * Gets the status string.
     * 
     * @return the status string
     */
    public String getStatusString() {
        return statusString;
    }

    /**
     * Sets the status string.
     * 
     * @param value the new status string
     */
    public void setStatusString(String value) {
        this.statusString = value;
    }

    /**
     * Gets the status code.
     * 
     * @return the status code
     */
    public Long getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the status code.
     * 
     * @param value the new status code
     */
    public void setStatusCode(Long value) {
        this.statusCode = value;
    }

    /**
     * Gets the on time string.
     * 
     * @return the on time string
     */
    public String getOnTimeString() {
        return onTimeString;
    }

    /**
     * Sets the on time string.
     * 
     * @param value the new on time string
     */
    public void setOnTimeString(String value) {
        this.onTimeString = value;
    }

    /**
     * Gets the scheduled departure.
     * 
     * @return the scheduled departure
     */
    public Date getScheduledDeparture() {
        return scheduledDeparture;
    }

    /**
     * Sets the scheduled departure.
     * 
     * @param value the new scheduled departure
     */
    public void setScheduledDeparture(Date value) {
        this.scheduledDeparture = value;
    }

    /**
     * Gets the updated departure.
     * 
     * @return the updated departure
     */
    public Date getUpdatedDeparture() {
        return updatedDeparture;
    }

    /**
     * Sets the updated departure.
     * 
     * @param value the new updated departure
     */
    public void setUpdatedDeparture(Date value) {
        this.updatedDeparture = value;
    }

    /**
     * Gets the scheduled arrival.
     * 
     * @return the scheduled arrival
     */
    public Date getScheduledArrival() {
        return scheduledArrival;
    }

    /**
     * Sets the scheduled arrival.
     * 
     * @param value the new scheduled arrival
     */
    public void setScheduledArrival(Date value) {
        this.scheduledArrival = value;
    }

    /**
     * Gets the updated arrival.
     * 
     * @return the updated arrival
     */
    public Date getUpdatedArrival() {
        return updatedArrival;
    }

    /**
     * Sets the updated arrival.
     * 
     * @param value the new updated arrival
     */
    public void setUpdatedArrival(Date value) {
        this.updatedArrival = value;
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

    /**
     * Gets the departure gate.
     * 
     * @return the departure gate
     */
    public String getDepartureGate() {
        return departureGate;
    }

    /**
     * Sets the departure gate.
     * 
     * @param value the new departure gate
     */
    public void setDepartureGate(String value) {
        this.departureGate = value;
    }

    /**
     * Gets the departure terminal.
     * 
     * @return the departure terminal
     */
    public String getDepartureTerminal() {
        return departureTerminal;
    }

    /**
     * Sets the departure terminal.
     * 
     * @param value the new departure terminal
     */
    public void setDepartureTerminal(String value) {
        this.departureTerminal = value;
    }

    /**
     * Gets the arrival gate.
     * 
     * @return the arrival gate
     */
    public String getArrivalGate() {
        return arrivalGate;
    }

    /**
     * Sets the arrival gate.
     * 
     * @param value the new arrival gate
     */
    public void setArrivalGate(String value) {
        this.arrivalGate = value;
    }

    /**
     * Gets the arrival terminal.
     * 
     * @return the arrival terminal
     */
    public String getArrivalTerminal() {
        return arrivalTerminal;
    }

    /**
     * Sets the arrival terminal.
     * 
     * @param value the new arrival terminal
     */
    public void setArrivalTerminal(String value) {
        this.arrivalTerminal = value;
    }

    /**
     * Gets the previous segment.
     * 
     * @return the previous segment
     */
    public PreviousSegment getPreviousSegment() {
        return previousSegment;
    }

    /**
     * Sets the previous segment.
     * 
     * @param value the new previous segment
     */
    public void setPreviousSegment(PreviousSegment value) {
        this.previousSegment = value;
    }

    /**
     * Gets the next segment.
     * 
     * @return the next segment
     */
    public NextSegment getNextSegment() {
        return nextSegment;
    }

    /**
     * Sets the next segment.
     * 
     * @param value the new next segment
     */
    public void setNextSegment(NextSegment value) {
        this.nextSegment = value;
    }

    /**
     * Gets the data freshness.
     * 
     * @return the data freshness
     */
    public Long getDataFreshness() {
        return dataFreshness;
    }

    /**
     * Sets the data freshness.
     * 
     * @param value the new data freshness
     */
    public void setDataFreshness(Long value) {
        this.dataFreshness = value;
    }
}
