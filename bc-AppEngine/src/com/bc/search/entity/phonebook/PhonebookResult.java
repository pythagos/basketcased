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
 * The Class PhonebookResult.
 */
public class PhonebookResult
    extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The title. */
    protected String title;
    
    /** The url. */
    protected String url;
    
    /** The business. */
    protected String business;
    
    /** The phone number. */
    protected String phoneNumber;
    
    /** The address. */
    protected String address;
    
    /** The city. */
    protected String city;
    
    /** The state or province. */
    protected String stateOrProvince;
    
    /** The country or region. */
    protected String countryOrRegion;
    
    /** The postal code. */
    protected String postalCode;
    
    /** The latitude. */
    protected Double latitude;
    
    /** The longitude. */
    protected Double longitude;
    
    /** The unique id. */
    protected String uniqueId;
    
    /** The business url. */
    protected String businessUrl;
    
    /** The user rating. */
    protected Double userRating;
    
    /** The review count. */
    protected Long reviewCount;
    
    /** The display url. */
    protected String displayUrl;

    /**
     * Gets the title.
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     * 
     * @param value the new title
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the url.
     * 
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     * 
     * @param value the new url
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the business.
     * 
     * @return the business
     */
    public String getBusiness() {
        return business;
    }

    /**
     * Sets the business.
     * 
     * @param value the new business
     */
    public void setBusiness(String value) {
        this.business = value;
    }

    /**
     * Gets the phone number.
     * 
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     * 
     * @param value the new phone number
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the address.
     * 
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     * 
     * @param value the new address
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the city.
     * 
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     * 
     * @param value the new city
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the state or province.
     * 
     * @return the state or province
     */
    public String getStateOrProvince() {
        return stateOrProvince;
    }

    /**
     * Sets the state or province.
     * 
     * @param value the new state or province
     */
    public void setStateOrProvince(String value) {
        this.stateOrProvince = value;
    }

    /**
     * Gets the country or region.
     * 
     * @return the country or region
     */
    public String getCountryOrRegion() {
        return countryOrRegion;
    }

    /**
     * Sets the country or region.
     * 
     * @param value the new country or region
     */
    public void setCountryOrRegion(String value) {
        this.countryOrRegion = value;
    }

    /**
     * Gets the postal code.
     * 
     * @return the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code.
     * 
     * @param value the new postal code
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the latitude.
     * 
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude.
     * 
     * @param value the new latitude
     */
    public void setLatitude(Double value) {
        this.latitude = value;
    }

    /**
     * Gets the longitude.
     * 
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude.
     * 
     * @param value the new longitude
     */
    public void setLongitude(Double value) {
        this.longitude = value;
    }

    /**
     * Gets the unique id.
     * 
     * @return the unique id
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * Sets the unique id.
     * 
     * @param value the new unique id
     */
    public void setUniqueId(String value) {
        this.uniqueId = value;
    }

    /**
     * Gets the business url.
     * 
     * @return the business url
     */
    public String getBusinessUrl() {
        return businessUrl;
    }

    /**
     * Sets the business url.
     * 
     * @param value the new business url
     */
    public void setBusinessUrl(String value) {
        this.businessUrl = value;
    }

    /**
     * Gets the user rating.
     * 
     * @return the user rating
     */
    public Double getUserRating() {
        return userRating;
    }

    /**
     * Sets the user rating.
     * 
     * @param value the new user rating
     */
    public void setUserRating(Double value) {
        this.userRating = value;
    }

    /**
     * Gets the review count.
     * 
     * @return the review count
     */
    public Long getReviewCount() {
        return reviewCount;
    }

    /**
     * Sets the review count.
     * 
     * @param value the new review count
     */
    public void setReviewCount(Long value) {
        this.reviewCount = value;
    }

    /**
     * Gets the display url.
     * 
     * @return the display url
     */
    public String getDisplayUrl() {
        return displayUrl;
    }

    /**
     * Sets the display url.
     * 
     * @param value the new display url
     */
    public void setDisplayUrl(String value) {
        this.displayUrl = value;
    }
}
