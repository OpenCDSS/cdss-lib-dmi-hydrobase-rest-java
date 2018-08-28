package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-waterdistrict
 * @author jurentie
 *
 */

/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceTablesWaterDistrict {
	
	/**
	 * Variables declared in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/** 
	 * Water Division 
	 */
	private int division;
	
	/** 
	 * Water District 
	 */
	private int waterDistrict;
	
	/** 
	 * Water District Name 
	 */
	private String waterDistrictName;

	/**
	 * Getters and setters of defined variables
	 */
	public int getDivision() {
		return division;
	}

	public int getWaterDistrict() {
		return waterDistrict;
	}

	public String getWaterDistrictName() {
		return waterDistrictName;
	}

	public void setDivision(int div) {
		this.division = div;
	}

	public void setWaterDistrict(int wd) {
		this.waterDistrict = wd;
	}

	public void setWaterDistrictName(String wdName) {
		this.waterDistrictName = wdName;
	}
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
	@Override
	public String toString(){
		return "ReferenceTablesWaterDistrict [ div: " + division + ", wd: " + waterDistrict + ", wdName: " + waterDistrictName + " ]\n";
	}

}
