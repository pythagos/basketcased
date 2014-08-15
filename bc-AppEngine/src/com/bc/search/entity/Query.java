package com.bc.search.entity;

/**
 * The Class Query.
 */
public class Query
    extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 3465487169443089969L;
    
    /** The search terms. */
    protected String searchTerms;
    
    /** The altered query. */
    protected String alteredQuery;
    
    /** The alteration override query. */
    protected String alterationOverrideQuery;

    /**
     * Gets the search terms.
     * 
     * @return the search terms
     */
    public String getSearchTerms() {
        return searchTerms;
    }

    /**
     * Sets the search terms.
     * 
     * @param value the new search terms
     */
    public void setSearchTerms(String value) {
        this.searchTerms = value;
    }

    /**
     * Gets the altered query.
     * 
     * @return the altered query
     */
    public String getAlteredQuery() {
        return alteredQuery;
    }

    /**
     * Sets the altered query.
     * 
     * @param value the new altered query
     */
    public void setAlteredQuery(String value) {
        this.alteredQuery = value;
    }

    /**
     * Gets the alteration override query.
     * 
     * @return the alteration override query
     */
    public String getAlterationOverrideQuery() {
        return alterationOverrideQuery;
    }

    /**
     * Sets the alteration override query.
     * 
     * @param value the new alteration override query
     */
    public void setAlterationOverrideQuery(String value) {
        this.alterationOverrideQuery = value;
    }
}
