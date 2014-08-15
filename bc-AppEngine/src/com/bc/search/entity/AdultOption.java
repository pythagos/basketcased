package com.bc.search.entity;

/**
 * The Enum AdultOption.
 */
public enum AdultOption {

    /** The OFF. */
    OFF("Off"),
    
    /** The MODERATE. */
    MODERATE("Moderate"),
    
    /** The STRICT. */
    STRICT("Strict");
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new adult option.
     * 
     * @param v the v
     */
    AdultOption(String v) {
        value = v;
    }

    /**
     * Value.
     * 
     * @return the string
     */
    public String value() {
        return value;
    }

    /**
     * From value.
     * 
     * @param v the v
     * 
     * @return the adult option
     */
    public static AdultOption fromValue(String v) {
        for (AdultOption c: AdultOption.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
