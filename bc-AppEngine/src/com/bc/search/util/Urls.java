package com.bc.search.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class Urls {

	public static final String URI_JSON_WEB = "https://ajax.googleapis.com/ajax/services/search/web?v=1.0&rsz=8";
	public static final String URI_JSON_IMAGE = "https://ajax.googleapis.com/ajax/services/search/images?v=1.0&rsz=8";
	public static final String URI_JSON_VIDEO = "https://ajax.googleapis.com/ajax/services/search/video?v=1.0&rsz=8&tbm=vid";

	public static final String URI_PARAM_SEP = "&";
	
	public static final String PARAM_QUERY = "q";
	public static final String PARAM_USER_IP = "userIp";
	public static final String PARAM_CONTENT_FILTER = "familyFilter";
	public static final String PARAM_LANGUAGE = "hostLanguage";
	public static final String PARAM_INDEX = "index";
	public static final String PARAM_CUSTOM_FILTER = "filter";

	public static final String HEADER_REFERER_KEY = "Referer";
	public static final String HEADER_REFERER_VALUE = "http://humptyhome.appspot.com/";

	public static final String RESPONSE_CONTENT_TYPE = "application/json";
	public static final String RESPONSE_ENCODING = "UTF-8";

	public static URL getWebUrl(Map<String, String[]> parameterMap)
			throws MalformedURLException {
		StringBuffer uriSearch = new StringBuffer(URI_JSON_WEB);

		for (String key : parameterMap.keySet()) {
			if (key != null) {
				if (key.equalsIgnoreCase(PARAM_QUERY)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_USER_IP)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_CONTENT_FILTER)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_LANGUAGE)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_INDEX)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_CUSTOM_FILTER)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				}
			}
		}

		return new URL(uriSearch.toString());
	}
	
	public static URL getImageUrl(Map<String, String[]> parameterMap)
			throws MalformedURLException {
		StringBuffer uriSearch = new StringBuffer(URI_JSON_IMAGE);

		for (String key : parameterMap.keySet()) {
			if (key != null) {
				if (key.equalsIgnoreCase(PARAM_QUERY)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_USER_IP)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_CONTENT_FILTER)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_LANGUAGE)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_INDEX)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_CUSTOM_FILTER)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				}
			}
		}

		return new URL(uriSearch.toString());
	}

	public static URL getVideoUrl (Map<String, String[]> parameterMap)
			throws MalformedURLException {
		StringBuffer uriSearch = new StringBuffer(URI_JSON_VIDEO);

		for (String key : parameterMap.keySet()) {
			if (key != null) {
				if (key.equalsIgnoreCase(PARAM_QUERY)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_USER_IP)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_CONTENT_FILTER)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_LANGUAGE)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_INDEX)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				} else if (key.equalsIgnoreCase(PARAM_CUSTOM_FILTER)) {
					uriSearch.append(URI_PARAM_SEP).append(parameterMap.get(key)[0]);
				}
			}
		}

		return new URL(uriSearch.toString());
	}

}
