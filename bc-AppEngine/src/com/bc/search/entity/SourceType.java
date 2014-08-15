package com.bc.search.entity;

/**
 * The Enum SourceType.
 */
public enum SourceType {

    /** The SPELL. */
    SPELL("Spell"),
    
    /** The WEB. */
    WEB("Web"),
    
    /** The IMAGE. */
    IMAGE("Image"),
    
    /** The RELATE d_ search. */
    RELATED_SEARCH("RelatedSearch"),
    
    /** The PHONEBOOK. */
    PHONEBOOK("Phonebook"),
    
    /** The SHOWTIMES. */
    SHOWTIMES("Showtimes"),
    
    /** The WEATHER. */
    WEATHER("Weather"),
    
    /** The VIDEO. */
    VIDEO("Video"),
    
    /** The AD. */
    AD("Ad"),
    
    /** The X_ rank. */
    X_RANK("XRank"),
    
    /** The INSTAN t_ answer. */
    INSTANT_ANSWER("InstantAnswer"),
    
    /** The NEWS. */
    NEWS("News"),
    
    /** The QUER y_ location. */
    QUERY_LOCATION("QueryLocation"),
    
    /** The MOBIL e_ web. */
    MOBILE_WEB("MobileWeb"),
    
    /** The TRANSLATION. */
    TRANSLATION("Translation");
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new source type.
     * 
     * @param v the v
     */
    SourceType(String v) {
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
     * @return the source type
     */
    public static SourceType fromValue(String v) {
        for (SourceType c: SourceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
