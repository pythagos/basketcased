package com.bc.search.entity;


/**
 * The Class Error.
 */
public class Error {
    
	/** The code. */
	protected Long code;
    
    /** The message. */
    protected String message;
    
    /** The parameter. */
    protected String parameter;
    
    /** The value. */
    protected String value;
    
    /** The help url. */
    protected String helpUrl;
    
    /** The source type. */
    protected String sourceType;
    
    /** The source type error code. */
    protected Long sourceTypeErrorCode;

    /**
     * Gets the code.
     * 
     * @return the code
     */
    public Long getCode() {
        return code;
    }

    /**
     * Sets the code.
     * 
     * @param value the new code
     */
    public void setCode(Long value) {
        this.code = value;
    }

    /**
     * Gets the message.
     * 
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     * 
     * @param value the new message
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the parameter.
     * 
     * @return the parameter
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * Sets the parameter.
     * 
     * @param value the new parameter
     */
    public void setParameter(String value) {
        this.parameter = value;
    }

    /**
     * Gets the value.
     * 
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     * 
     * @param value the new value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the help url.
     * 
     * @return the help url
     */
    public String getHelpUrl() {
        return helpUrl;
    }

    /**
     * Sets the help url.
     * 
     * @param value the new help url
     */
    public void setHelpUrl(String value) {
        this.helpUrl = value;
    }

    /**
     * Gets the source type.
     * 
     * @return the source type
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * Sets the source type.
     * 
     * @param value the new source type
     */
    public void setSourceType(String value) {
        this.sourceType = value;
    }

    /**
     * Gets the source type error code.
     * 
     * @return the source type error code
     */
    public Long getSourceTypeErrorCode() {
        return sourceTypeErrorCode;
    }

    /**
     * Sets the source type error code.
     * 
     * @param value the new source type error code
     */
    public void setSourceTypeErrorCode(Long value) {
        this.sourceTypeErrorCode = value;
    }
}