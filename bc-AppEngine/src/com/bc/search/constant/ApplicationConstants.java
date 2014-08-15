package com.bc.search.constant;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class ApplicationConstants.
 */
public final class ApplicationConstants {

    /** The Constant APP_CONSTANTS_FILE. */
    public static final String APP_CONSTANTS_FILE = "ApplicationConstants.properties";

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(ApplicationConstants.class.getCanonicalName());
    
    /** The Constant applicationConstants. */
    private static final Properties applicationConstants = new Properties();

//    static {
//        try {
//            applicationConstants.load(
//                ApplicationConstants.class.getResourceAsStream(APP_CONSTANTS_FILE));
//        } catch (IOException e) {
//            LOG.log(Level.SEVERE, "An error occurred while loading properties.", e);
//        }
//    }
//    
//    /** The Constant CONTENT_TYPE_XML. */
//    public static final String CONTENT_TYPE_XML = getProperty("com.bc.search.client.contentTypeXml");
//
//    /** The Constant CONTENT_ENCODING. */
//    public static final String CONTENT_ENCODING = getProperty("com.bc.search.client.encoding");
//    
//    /** The Constant DATE_FORMAT. */
//    public static final String DATE_FORMAT = getProperty("com.bc.search.client.dateFormat");
    
  /** The Constant CONTENT_TYPE_XML. */
  public static final String CONTENT_TYPE_XML = "application/xml";

  /** The Constant CONTENT_ENCODING. */
  public static final String CONTENT_ENCODING = "UTF-8";
  
  /** The Constant DATE_FORMAT. */
  public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    /**
     * Instantiates a new application constants.
     */
    private ApplicationConstants() {}

    /**
     * Gets the property.
     * 
     * @param key the key
     * 
     * @return the property
     */
    public static String getProperty(String key) {
        return applicationConstants.getProperty(key);
    }

    /**
     * Gets the int property.
     * 
     * @param key the key
     * 
     * @return the int property
     */
    public static int getIntProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return 0;
        } else {
            return Integer.parseInt(property);
        }
    }

    /**
     * Gets the boolean property.
     * 
     * @param key the key
     * 
     * @return the boolean property
     */
    public static boolean getBooleanProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return false;
        } else {
            return Boolean.parseBoolean(property);
        }
    }

    /**
     * Gets the double property.
     * 
     * @param key the key
     * 
     * @return the double property
     */
    public static double getDoubleProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return 0;
        } else {
            return Double.parseDouble(property);
        }
    }

    /**
     * Gets the long property.
     * 
     * @param key the key
     * 
     * @return the long property
     */
    public static long getLongProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return 0;
        } else {
            return Long.parseLong(property);
        }
    }

    /**
     * Checks if is null or empty.
     * 
     * @param s the s
     * 
     * @return true, if is null or empty
     */
    private static boolean isNullOrEmpty(String s) {
        return ((s == null) || s.length() == 0);
    }
}
