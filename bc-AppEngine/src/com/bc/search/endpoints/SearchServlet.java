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

import com.bc.search.util.Urls;

/**
 * @author Jeremiah.Bopko
 * 
 */
public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 2800779875458456034L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		@SuppressWarnings("unchecked")
		URL url = get(request.getParameterMap());

		if (url != null) {
			URLConnection connection = url.openConnection();
			connection.addRequestProperty(Urls.HEADER_REFERER_KEY,Urls.HEADER_REFERER_VALUE);

			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}

			response.setContentType(Urls.RESPONSE_CONTENT_TYPE);
			response.setCharacterEncoding(Urls.RESPONSE_ENCODING);
			response.getWriter().write(builder.toString());
		}
	}

	protected URL get(Map<String, String[]> parameterMap) throws MalformedURLException {
		return Urls.getWebUrl(parameterMap);
	}
}
