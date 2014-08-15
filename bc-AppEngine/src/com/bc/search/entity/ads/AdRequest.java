package com.bc.search.entity.ads;


/**
 * The Interface AdRequest.
 */
public interface AdRequest 
//	extends SchemaEntity
{

    /**
     * Gets the page number.
     * 
     * @return the page number
     */
    Long getPageNumber();

    /**
     * Sets the page number.
     * 
     * @param value the new page number
     */
    void setPageNumber(Long value);

	/**
	 * Gets the ad unit id.
	 * 
	 * @return the ad unit id
	 */
	public String getAdUnitId();

	/**
	 * Sets the ad unit id.
	 * 
	 * @param value the new ad unit id
	 */
	public void setAdUnitId(String value);

	/**
	 * Gets the property id.
	 * 
	 * @return the property id
	 */
	public String getPropertyId();

	/**
	 * Sets the property id.
	 * 
	 * @param value the new property id
	 */
	public void setPropertyId(String value);
	
	/**
	 * Gets the channel id.
	 * 
	 * @return the channel id
	 */
	public String getChannelId();

	/**
	 * Sets the channel id.
	 * 
	 * @param value the new channel id
	 */
	public void setChannelId(String value);
	
	/**
	 * Gets the ml ad count.
	 * 
	 * @return the ml ad count
	 */
	public String getMlAdCount();

	/**
	 * Sets the ml ad count.
	 * 
	 * @param value the new ml ad count
	 */
	public void setMlAdCount(String value);
	
	/**
	 * Gets the sb ad count.
	 * 
	 * @return the sb ad count
	 */
	public String getSbAdCount();

	/**
	 * Sets the sb ad count.
	 * 
	 * @param value the new sb ad count
	 */
	public void setSbAdCount(String value);
}