package com.bc.search.entity.mobileweb;

import java.util.ArrayList;
import java.util.List;

import com.bc.search.entity.SchemaEntity;

/**
 * The Class MobileWebRequest.
 */
public class MobileWebRequest 
	extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2093282382303822168L;
	
	/** The offset. */
	protected Long offset;
    
    /** The count. */
    protected Long count;
	
	/** The mobile web search option list. */
	protected List<MobileWebSearchOption> mobileWebSearchOptionList;

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
	 * Gets the mobile web search option list.
	 * 
	 * @return the mobile web search option list
	 */
	public List<MobileWebSearchOption> getMobileWebSearchOptionList() {
		if (mobileWebSearchOptionList == null) {
			mobileWebSearchOptionList = new ArrayList<MobileWebSearchOption>();
		}
		return mobileWebSearchOptionList;
	}

	/**
	 * Sets the options.
	 * 
	 * @param value the new options
	 */
	public void setOptions(List<MobileWebSearchOption> value) {
		mobileWebSearchOptionList = value;
	}
}