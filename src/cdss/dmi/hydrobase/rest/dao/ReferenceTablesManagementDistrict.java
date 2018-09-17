package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-managementdistrict
 * @author jurentie
 *
 */
/*
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceTablesManagementDistrict {

	/**
	 * Variables declared in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * Management District Name 
	 */
	private String managementDistrictName;
	
	public String getManagementDistrictName(){
		return managementDistrictName;
	}
	
	/**
	 * Getters and setters for defined variables
	 */
	public void setManagementDistrictName(String managementDistrictName){
		this.managementDistrictName = managementDistrictName;
	}
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "ReferenceTablesManagementDistrict [ managementDistrictName: " + managementDistrictName + " ]\n";
	}
	
}
