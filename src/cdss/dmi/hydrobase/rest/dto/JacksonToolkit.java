package cdss.dmi.hydrobase.rest.dto;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import RTi.Util.Message.Message;

/**
 * This class is used to simplify the common uses of Jackson in 
 * {@link cdss.dmi.hydrobase.rest.ColoradoHydroBaseRestDataStore}. Jackson is used
 * to retrieve JSON data from Web Services and then convert that data to a POJO.
 * @author jurentie
 *
 */
public class JacksonToolkit {
	
	/**
	 * Global ObjectMapper as part of the Jackson library used 
	 * for serializing and deserializing JSON data to a POJO.
	 */
	private ObjectMapper mapper;
	
	/**
	 * Jackson Toolkit used for lazy initialization of a singleton class
	 */
	private static JacksonToolkit instance;
	
	private JacksonToolkit(){
		mapper = new ObjectMapper();
	}
	
	/**
	 * Lazy initialization of a singleton class instance
	 * @return instance of JacksonToolkit class
	 */
	public static JacksonToolkit getInstance(){
		if(instance == null){
			instance = new JacksonToolkit();
		}
		return instance;
	}
	
	/**
	 * Given a url to Web Services this method retrieves the JSON response from 
	 * DWR web services and converts that to a JsonNode from the Jackson Library.
	 * @param url - String representing the URL to web services
	 * @return JsonNode of returned value from web services request.
	 */
	public JsonNode getJsonNodeFromWebServices(String url){
		String routine = "JacksonToolkit.getJsonNodeFromWebServices";
		JsonNode results = null;
		URL request = null;
		
		if(!httpResponse200(url)){
			Message.printWarning(2, routine, "Error: " + url + " returned a 404 error");
			return null;
		}
		
		//System.out.println(url);
		
		try{
			request = new URL(url);
			JsonNode divrecRootNode = mapper.readTree(request);
			int pageCount = divrecRootNode.get("PageCount").asInt();
			if(pageCount > 1){
				results = getJsonNodeResultsFromURLStringMultiplePages(url, pageCount);
				//System.out.println("[ColoradoHydroBaseRestDataStore.getJsonNodeResultsFromURLString] Unable to process multiple pages at this time. Needs updated.");
			}else{
				results = divrecRootNode.path("ResultList");
			}
		}
		catch (JsonParseException e ) { 
			Message.printWarning(2, routine, "Error reading response from " + request + ". " + e);
			return null;
		}
		catch (JsonMappingException e ) { 
			Message.printWarning(2, routine, "Error reading response from " + request + ". " + e);
			return null;
		}
		catch (MalformedURLException e) {
			Message.printWarning(2, routine, "Malformed URL has occured. URL= " + url);
		}
		catch (IOException e) { 
			Message.printWarning(2, routine, "IOExpection: " + e);
			return null;
		}
		
		
		return results;
	}
	
	/**
	 * If web services returns multiple pages this method will retrieve all results from
	 * across the separate pages and combine it into a single JsonNode from the Jackson library. 
	 * @param url - String representing the URL for the request from web services.
	 * @param pageCount - Number of pages returned from web services.
	 * @return a single JsonNode with the results from all pages of results.
	 */
	private JsonNode getJsonNodeResultsFromURLStringMultiplePages(String url, int pageCount){
		String routine = "ColoradoHydroBaseRestDataStore.getJsonNodeResultsFromURLStringsMultiplePages";
		//Add page index 1 to url
		String request = url += "&pageIndex=1";
		JsonNode tempNode = null;
		
		//Set tempNode to be the returned results from the first page 
		try {
			tempNode = mapper.readTree(new URL(request));
		} 
		catch (JsonParseException e ) { 
			Message.printWarning(2, routine, "Error reading response from " + request + ". " + e);
			return null;
		}
		catch (JsonMappingException e ) { 
			Message.printWarning(2, routine, "Error reading response from " + request + ". " + e);
			return null;
		}
		catch (MalformedURLException e) {
			Message.printWarning(2, routine, "Malformed URL has occured. URL= " + url);
		}
		catch (IOException e) { 
			Message.printWarning(2, routine, "IOExpection: " + e);
			return null;
		}
		
		//Create an array node that will contain the results from the various pages
		ArrayNode results = (ArrayNode) tempNode.path("ResultList");
		
		try{
			//Set i=2 since the first page is added previous to stepping through the loop
			for(int i = 2; i < (pageCount + 1) ; i++){
				request += "&pageIndex=" + (i); 
				tempNode = mapper.readTree(new URL(request));
				JsonNode values = tempNode.path("ResultList");
				for(int j = 0; j < values.size(); j++){
					results.add(values.get(j));
				}
			}
		}
		catch (JsonParseException e ) { 
			Message.printWarning(2, routine, "Error reading response from " + request + ". " + e);
			return null;
		}
		catch (JsonMappingException e ) { 
			Message.printWarning(2, routine, "Error reading response from " + request + ". " + e);
			return null;
		}
		catch (MalformedURLException e) {
			Message.printWarning(2, routine, "Malformed URL has occured. URL= " + url);
		}
		catch (IOException e) { 
			Message.printWarning(2, routine, "IOExpection: " + e);
			return null;
		}
		return (JsonNode)results;
	}
	
	/**
	 * Checks to see if the request string returns a response 200 or an error 404.
	 * @param urlString - String representing the URL request from web services.
	 * @return True if request came back okay, with a response 200. False if response 404.
	 */
	public boolean httpResponse200(String urlString){
		HttpURLConnection connection;
		try {
			URL url = new URL(urlString);
			connection = (HttpURLConnection)url.openConnection();
			if(connection.getResponseCode() == 404) return false;
		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Deserializes a JsonNode to a POJO class.
	 * @param node - JsonNode to deserialize to POJO.
	 * @param objClass - The class that the JsonNOde is to be deserialized to.
	 * @return the POJO that has been initialized via Jackson deserialization 
	 * from the JsonNode data.
	 */
	public Object treeToValue(JsonNode node, Class objClass){
		String routine = "JacksonToolkit.treeToValue";
		try {
			return mapper.treeToValue(node, objClass);
		}
		catch (JsonParseException e ) { 
			Message.printWarning(2, routine, "Error converting response to value from. " + e);
			return null;
		}
		catch (JsonMappingException e ) { 
			Message.printWarning(2, routine, "Error converting response to value from. " + e);
			return null;
		}
		catch (IOException e) { 
			Message.printWarning(2, routine, "IOExpection: " + e);
			return null;
		}
	}

}
