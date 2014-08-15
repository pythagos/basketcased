package com.bc.search;

import com.bc.search.BingSearchClient.SearchRequestBuilder;
import com.bc.search.entity.AdultOption;
import com.bc.search.entity.SearchOption;
import com.bc.search.entity.SearchResponse;
import com.bc.search.entity.SourceType;
import com.bc.search.entity.web.WebResult;
import com.bc.search.entity.web.WebSearchOption;
import com.google.appengine.api.urlfetch.*;
import com.google.gson.JsonObject;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class AzureClient {

	public static String getBing() throws Exception {
		
	    StringBuffer buf = new StringBuffer();
		try {
		    URL url = new URL("http://www.example.com/atom.xml");
		    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		    String line;

		    while ((line = reader.readLine()) != null) {
		        // ...
		    	buf.append(line);
		    }
		    reader.close();
		} catch (MalformedURLException e) {} catch (IOException e) {}
		
//		test2();
		return buf.toString();
	}
	
	public static String getGoogl(String ipAddress, String query, String aspect, String size, String service) throws Exception {

		URL url = new URL(
				"https://ajax.googleapis.com/ajax/services/search/images?"
						+ "v=1.0&q=barack%20obama&userip=" + ipAddress);
		
		URL url2 = new URL("https://www.googleapis.com/customsearch/v1element?key=AIzaSyCVAXiUzRYsML1Pv6RwSG1gunmMikTzQqY&rsz=filtered_cse&num=20&start=0&hl=en&prettyPrint=false&searchtype=image&cx=017250877485034233106:s8modbikwvo&q=blowjob&nocache=1390850294372");
		URLConnection connection = url.openConnection();
		connection.addRequestProperty("Referer",
				"http://1-dot-neural-map-460.appspot.com/");

		String line;
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}

		return builder.toString();
	}

	// Replace the following string with the AppId you received from the
    // Bing Developer Center.
    private static final String AppId = "zJW72YpEbyDEe/TcZEmyaIFiqgrSskquTEsV8NQ+zoU";

    static void Main()
    {
    	
        HttpURLConnection request = (HttpURLConnection) BuildRequest();

//        try
//        {
            // Send the request; display the response.
            try {
				DisplayResponse(new BufferedReader(new InputStreamReader(request.getInputStream())));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//        }
        
//        catch (WebException ex)
//        {
//            // An exception occurred while accessing the network.
//            Console.WriteLine(ex.Message);
//        }
    }

    static URLConnection BuildRequest()
    {
        String requestString = "http://api.bing.net/xml.aspx?"

            // Common request fields (required)
            + "AppId=" + AppId
            + "&Query=xbox"
//            + "&Query=xbox site:microsoft.com"
            + "&Sources=Image"

            // Common request fields (optional)
            + "&Version=2.0"
            + "&Market=en-us"
            + "&Adult=Moderate"

            // Image-specific request fields (optional)
            + "&Image.Count=10"
            + "&Image.Offset=0";

        String encoded;
		try {
			encoded = URLEncoder.encode(requestString, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        // Create and initialize the request.
        URLConnection connection = null;
        URL url;
		try {
			url = new URL(requestString);
			connection = url.openConnection();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return connection;
    }

    static void DisplayResponse(BufferedReader reader)
    {
    	StringBuffer stringResponse = new StringBuffer();
    	
    	String line;

        try {
			while ((line = reader.readLine()) != null) {
				stringResponse.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    	
    	
    	
//        // Load the response into an XmlDocument.
//        XmlDocument document = new XmlDocument();
//        document.Load(response.GetResponseStream());
//        
//        // Add the default namespace to the namespace manager.
//        XmlNamespaceManager nsmgr = new XmlNamespaceManager(
//            document.NameTable);
//        nsmgr.AddNamespace(
//            "api",
//            "http://schemas.microsoft.com/LiveSearch/2008/04/XML/element");
//
//        XmlNodeList errors = document.DocumentElement.SelectNodes(
//            "./api:Errors/api:Error",
//            nsmgr);
//
//        if (errors.Count > 0)
//        {
//            // There are errors in the response. Display error details.
//            DisplayErrors(errors);
//        }
//        else
//        {
//            // There were no errors in the response. Display the
//            // Image results.
//            DisplayResults(document.DocumentElement, nsmgr);
//        }
//    }
//
//    static void DisplayResults(XmlNode root, XmlNamespaceManager nsmgr)
//    {
//        // Add the Image SourceType namespace to the namespace manager.
//        string imageNamespaceUri =
//            "http://schemas.microsoft.com/LiveSearch/2008/04/XML/multimedia";
//        nsmgr.AddNamespace("mms", imageNamespaceUri);
//
//        XmlNode image = root.SelectSingleNode("./mms:Image", nsmgr);
//        XmlNodeList results = image.SelectNodes(
//            "./mms:Results/mms:ImageResult",
//            nsmgr);
//
//        string version = root.SelectSingleNode("./@Version", nsmgr).InnerText;
//        string searchTerms = root.SelectSingleNode(
//            "./api:Query/api:SearchTerms",
//            nsmgr).InnerText;
//        int offset;
//        int.TryParse(
//            image.SelectSingleNode("./mms:Offset", nsmgr).InnerText,
//            out offset);
//        int total;
//        int.TryParse(
//            image.SelectSingleNode("./mms:Total", nsmgr).InnerText,
//            out total);
//
//        // Display the results header.
//        Console.WriteLine("Bing API Version " + version);
//        Console.WriteLine("Image results for " + searchTerms);
//        Console.WriteLine(
//            "Displaying {0} to {1} of {2} results",
//            offset + 1,
//            offset + results.Count,
//            total);
//        Console.WriteLine();
//
//        // Display the Image results.
//        foreach (XmlNode result in results)
//        {
//            Console.WriteLine(
//                result.SelectSingleNode("./mms:MediaUrl", nsmgr).InnerText);
//            Console.WriteLine(
//                "Page Title: "
//                + result.SelectSingleNode("./mms:Title", nsmgr).InnerText);
//            Console.WriteLine(
//                "Page URL: "
//                + result.SelectSingleNode("./mms:Url", nsmgr).InnerText);
//            Console.WriteLine(
//                "Dimensions: "
//                + result.SelectSingleNode("./mms:Width", nsmgr).InnerText
//                + "x"
//                + result.SelectSingleNode("./mms:Height", nsmgr).InnerText);
//
//            string thumbnailUrl = result.SelectSingleNode(
//                "./mms:Thumbnail/mms:Url",
//                nsmgr).InnerText;
//            Console.WriteLine("Thumbnail URL: " + thumbnailUrl);
//
//            Console.WriteLine();
//        }
//    }
//
//    static void DisplayErrors(XmlNodeList errors)
//    {
//        // Iterate over the list of errors and display error details.
//        Console.WriteLine("Errors:");
//        Console.WriteLine();
//        foreach (XmlNode error in errors)
//        {
//            foreach (XmlNode detail in error.ChildNodes)
//            {
//                Console.WriteLine(detail.Name + ": " + detail.InnerText);
//            }
//
//            Console.WriteLine();
//        }
//    }
    
	
	
	private static final String ACCOUNT_KEY = "";
	private static final String ROOT_URI = "";
//
//	private static String test2()
//	{
//		
//		String accountKey = "wtevertheaccountkeyis";
//        byte[] accountKeyBytes = Base6.encodeBase64(accountKey.getBytes());
//        String accountKeyEnc = new String(accountKeyBytes);
//
//       String query="eagle";
//
//        String bingURL = "https://api.datamarket.azure.com/Bing/SearchWeb/Web?Query=obama"+URLEncoder.encode(query, "UTF-8")+"%27&$format=json";
//
//       JSONObject result = null;
//
//  try {
//            URL url = new URL(bingURL);
//            //url.append(URLEncoder.encode(query, "UTF-8"));
//            URLConnection urlConnection = url.openConnection();
//            urlConnection.setRequestProperty("Authorization", "Basic " + accountKeyEnc);
//            InputStream is = urlConnection.getInputStream();
//            InputStreamReader isr = new InputStreamReader(is);
//
//            int numCharsRead;
//            char[] charArray = new char[1024];
//            StringBuilder sb = new StringBuilder();
//            while ((numCharsRead = isr.read(charArray)) > 0) {
//                sb.append(charArray, 0, numCharsRead);
//            }
//            result = new JSONObject(sb.toString());            
//            System.out.println(result);
//            
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//  
//  
//  
//  
//        String requestString = "http://api.bing.net/xml.aspx?"
//
//                // Common request fields (required)
//                + "AppId=" + AppId
//                + "&Query=xbox"
////                + "&Query=xbox site:microsoft.com"
//                + "&Sources=Image"
//
//                // Common request fields (optional)
//                + "&Version=2.0"
//                + "&Market=en-us"
//                + "&Adult=Moderate"
//
//                // Image-specific request fields (optional)
//                + "&Image.Count=10"
//                + "&Image.Offset=0";
//
//            String encoded = URLEncoder.encode(requestString, "UTF-8");
//            
//            // Create and initialize the request.
//            URLConnection connection = null;
//            URL url;
//    		try {
//    			url = new URL(encoded);
//    			connection = url.openConnection();
//    		} catch (MalformedURLException e) {
//    			// TODO Auto-generated catch block
//    			e.printStackTrace();
//    		} catch (IOException e) {
//    			// TODO Auto-generated catch block
//    			e.printStackTrace();
//    		}
//
//    		
//        HttpURLConnection request = (HttpURLConnection) BuildRequest();
//        StringBuffer response = new StringBuffer();
//
////      try
////      {
//          // Send the request; display the response.
//          try {
//				DisplayResponse(new BufferedReader(new InputStreamReader(request.getInputStream())));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
////      }
//
//          return response.toString();
//	}
//
	private static String test1()
	{
		String json = null;
		BingSearchServiceClientFactory factory = BingSearchServiceClientFactory.newInstance();
		BingSearchClient client = factory.createBingSearchClient();

		SearchRequestBuilder builder = client.newSearchRequestBuilder();
		try {
			builder.withAppId(URLEncoder.encode("zJW72YpEbyDEe/TcZEmyaIFiqgrSskquTEsV8NQ+zoU", "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		builder.withQuery("obama");
		builder.withSourceType(SourceType.IMAGE);
		builder.withVersion("2.0");
		builder.withMarket("en-us");
		builder.withAdultOption(AdultOption.OFF);
		builder.withSearchOption(SearchOption.ENABLE_HIGHLIGHTING);

		builder.withWebRequestCount(10L);
		builder.withWebRequestOffset(0L);
		builder.withWebRequestSearchOption(WebSearchOption.DISABLE_HOST_COLLAPSING);
		builder.withWebRequestSearchOption(WebSearchOption.DISABLE_QUERY_ALTERATIONS);

		SearchResponse response = client.search(builder.getResult());

		for (WebResult result : response.getWeb().getResults()) {
		        System.out.println(result.getTitle());
		        System.out.println(result.getDescription());
		        System.out.println(result.getUrl());
		        System.out.println(result.getDateTime());
		}
		
		return json;
	}

	private void getBaseUri()
	{
		String query = null;
		String searchOperation = null;  // Web Image Video
		String market = null;
		String safeSearch = null;
		String filter = null;
		String pageSize = null;
		String index = null;
		
//		// collect params
//		$acctKey = 'zJW72YpEbyDEe/TcZEmyaIFiqgrSskquTEsV8NQ+zoU';
//		$rootUri = 'https://api.datamarket.azure.com/Bing/Search';
//		// Get the query. Default to 'sushi'.
//		$query = ($_GET['q']) ? $_GET['q'] : 'sushi';
//		// Get the service operation. Default to Web.
//		$serviceOp = ($_GET['sop']) ? $_GET['sop'] : 'Web';
//		// Get the market. Default to en-us.
//		$market = ($_GET['market']) ? $_GET['market'] : 'en-us';
//		// Get the safesearch setting
//		$safeSearch = ($_GET['ss']) ? $_GET['ss'] : 'Off';
//		// Get the image filters
//		$filter = ($_GET['fil']) ? $_GET['fil'] : '';
//		// Get the image filters
//		$pageSize = ($_GET['pageSize']) ? $_GET['pageSize'] : '50';
//		// Get the image filters
//		$offset = ($_GET['offset']) ? $_GET['offset'] : '0';
//
//		// Encode the query along with the single quotation marks that must surround it.
//		$query = urlencode("'$query'");
//		// Encode the market along with the single quotation marks that must surround it.
//		$market = urlencode("'$market'");
//		$safeSearch = urlencode("'$safeSearch'");
//		$filter = urlencode("'$filter'");
//
//	    if (strcmp($serviceOp, "Web") == 0) {
//	        // Construct the full URL for the query.
//	        $requestUri = "$rootUri/$serviceOp?\$format=json&\$top=$pageSize&\$skip=$offset&Query=$query&Market=$market&Adult=$safeSearch";
//	    } else if (strcmp($serviceOp, "Image") == 0) {
//	        // Construct the full URL for the query.
//	        $requestUri = "$rootUri/$serviceOp?\$format=json&\$top=$pageSize&\$skip=$offset&Query=$query&Market=$market&Adult=$safeSearch&ImageFilters=$filter";
//	    } else if (strcmp($serviceOp, "Video") == 0) {
//	        // Construct the full URL for the query.
//	        $requestUri = "$rootUri/$serviceOp?\$format=json&\$top=$pageSize&\$skip=$offset&Query=$query&Market=$market&Adult=$safeSearch&VideoFilters=$filter";
//	    }
//
//		// Encode the credentials and create the stream context.
//		$auth = base64_encode("$acctKey:$acctKey");
//		$data = array(
//			'http' => array(
//			'request_fulluri' => true,
//
//			// ignore_errors can help debug – remove for production. This option added in PHP 5.2.10
//			'ignore_errors' => true,
//			'header' => "Authorization: Basic $auth")
//		);
//		$context = stream_context_create($data);
//
//		// Get the response from Bing.
//		$response = file_get_contents($requestUri, 0, $context);
//
//		// Send the response back to the browser.
//		echo $response;		
	}
	
	
	
	
	
	
}