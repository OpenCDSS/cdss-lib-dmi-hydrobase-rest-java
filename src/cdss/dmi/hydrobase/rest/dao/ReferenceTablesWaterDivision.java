package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-waterdivision
 * @author jurentie
 *
 */

/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceTablesWaterDivision {
	
	/**
	 * Variables declared in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * Water Division 
	 */
	private int division;
	
	/** 
	 * Water Division Name 
	 */
	private String divisionName;

	/**
	 * Getters and setters of defined variables
	 */
	public int getDivision() {
		return division;
	}

	public void setDivision(int div) {
		this.division = div;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divName) {
		this.divisionName = divName;
	}
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "ReferenceTablesWaterDivision [ div: " + division + ", divName: " + divisionName + " ]"; 
	}

}
