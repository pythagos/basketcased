package com.bc.search.entity;

/**
 * The Enum SearchOption.
 */
public enum SearchOption {

    DISABLE_LOCATION_DETECTION("DisableLocationDetection"),
    ENABLE_HIGHLIGHTING("EnableHighlighting");
    
    private final String value;

    /**
     * Instantiates a new search option.
     * 
     * @param v the v
     */
    SearchOption(String v) {
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
     * @return the search option
     */
    public static SearchOption fromValue(String v) {
        for (SearchOption c: SearchOption.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
