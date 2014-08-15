/**
 * 
 */
package com.bc.search.endpoints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jeremiah.Bopko
 * 
 */
public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 2800779875458456034L;
	
	private static final String URI_JSON = "https://ajax.googleapis.com/ajax/services/search/web?v=1.0&rsz=8";
	protected static final String URI_PARAM_SEP = "&";
	
	protected static final String PARAM_QUERY = "q";
	protected static final String PARAM_USER_IP = "userIp";
	protected static final String PARAM_CONTENT_FILTER = "familyFilter";
	protected static final String PARAM_LANGUAGE = "hostLanguage";
	protected static final String PARAM_INDEX = "index";
	protected static final String PARAM_CUSTOM_FILTER = "filter";

	protected static final String HEADER_REFERER_KEY = "Referer";
	protected static final String HEADER_REFERER_VALUE = "http://1-dot-neural-map-460.appspot.com/";

	protected static final String RESPONSE_CONTENT_TYPE = "application/json";
	protected static final String RESPONSE_ENCODING = "UTF-8";
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		@SuppressWarnings("unchecked")
		URL url = get(request.getParameterMap());

		if (url != null) {
			URLConnection connection = url.openConnection();
			connection.addRequestProperty(HEADER_REFERER_KEY,HEADER_REFERER_VALUE);

			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}

			response.setContentType(RESPONSE_CONTENT_TYPE);
			response.setCharacterEncoding(RESPONSE_ENCODING);
			response.getWriter().write(builder.toString());
		}
	}

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
