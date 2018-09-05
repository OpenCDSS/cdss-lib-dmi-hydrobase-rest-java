package cdss.dmi.hydrobase.rest.dto;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import RTi.Util.Message.Message;

public class JacksonToolkit {
	
	private ObjectMapper mapper;
	private static JacksonToolkit instance;
	
	private JacksonToolkit(){
		mapper = new ObjectMapper();
	}
	
	//Lazy initialization of a singleton class instance
	public static JacksonToolkit getInstance(){
		if(instance == null){
			instance = new JacksonToolkit();
		}
		return instance;
	}
	
	public JsonNode getJsonNodeFromWebServices(String url){
		String routine = "JacksonToolkit.getJsonNodeFromWebServices";
		JsonNode results = null;
		
		try{
			URL request = new URL(url);
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
			Message.printWarning(3, routine, "Error querying results from (" + e + ")");
			return null;
		}
		catch (JsonMappingException e ) { 
			Message.printWarning(3, routine, "Error querying results from (" + e + ")");
			return null;
		}
		catch (IOException e) { 
			Message.printWarning(3, routine, e);
			return null;
		}
		
		
		return results;
	}
	
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
			Message.printWarning(3, routine, "Error querying results from (" + e + ")");
			return null;
		}
		catch (JsonMappingException e ) { 
			Message.printWarning(3, routine, "Error querying results from (" + e + ")");
			return null;
		}
		catch (IOException e) { 
			Message.printWarning(3, routine, e);
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
			Message.printWarning(3, routine, "Error querying results from (" + e + ")");
			return null;
		}
		catch (JsonMappingException e ) { 
			Message.printWarning(3, routine, "Error querying results from (" + e + ")");
			return null;
		}
		catch (IOException e) { 
			Message.printWarning(3, routine, e);
			return null;
		}
		return (JsonNode)results;
	}
	
	public Object treeToValue(JsonNode node, Class objClass){
		String routine = "JacksonToolkit.treeToValue";
		try {
			return mapper.treeToValue(node, objClass);
		} catch (JsonProcessingException e) {
			Message.printWarning(3, routine, e);
			e.printStackTrace();
		}
		return null;
	}

}
