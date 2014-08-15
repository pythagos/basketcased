package com.bc.search.endpoints;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class SearchImageServlet extends SearchServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6225227791234627735L;
	private static final String URI_JSON = "https://ajax.googleapis.com/ajax/services/search/images?v=1.0&rsz=8";

	@Override
	protected URL get(Map<String, String[]> parameterMap)
			throws MalformedURLException {
		StringBuffer uriSearch = new StringBuffer(URI_JSON);

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
