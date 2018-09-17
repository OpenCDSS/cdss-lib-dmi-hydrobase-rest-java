package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.<br>
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-divrectypes
 * @author jurentie
 *
 */
/*
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceTablesDivRecTypes {
	
	/**
	 * Variables declared in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * Type of record: diversion; stage/volume; or comment
	 */
	private String divRecType;
	
	/**
	 * Long version of the Diversion Record Type
	 */
	private String divRecTypeLong;
	
	/**
	 * Getters and setters of defined variables
	 */
	public String getDivRecType() {
		return divRecType;
	}
	public String getDivRecTypeLong() {
		return divRecTypeLong;
	}
	public void setDivRecType(String divRecType) {
		this.divRecType = divRecType;
	}
	public void setDivRecTypeLong(String divRecTypeLong) {
		this.divRecTypeLong = divRecTypeLong;
	}
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "ReferenceTablesDivRecTypes: [ divRecType: " + divRecType + ", divRecTypeLong: " + divRecTypeLong + " ]\n";
	}

}
