package com.bc.search.endpoints;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.bc.search.util.Urls;

public class SearchVideoServlet extends SearchServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6225227795924627735L;

	@Override
	protected URL get(Map<String, String[]> parameterMap) throws MalformedURLException {
		return Urls.getVideoUrl(parameterMap);
	}
}
