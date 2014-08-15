/**
 * 
 */
package com.bc.search.endpoints;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.bc.search.util.Urls;

public class SearchWebServlet extends SearchServlet {
	private static final long serialVersionUID = 3804804504107566891L;

	protected URL get(Map<String, String[]> parameterMap)
			throws MalformedURLException {
		return Urls.getWebUrl(parameterMap);
	}
}
