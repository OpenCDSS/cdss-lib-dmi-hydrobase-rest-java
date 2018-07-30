package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceTablesManagementDistrict {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-managementdistrict
	 */

	/* Management District Name */
	private String managementDistrictName;
	
	public void setManagementDistrictName(String managementDistrictName){
		this.managementDistrictName = managementDistrictName;
	}
	
	public String getManagementDistrictName(){
		return managementDistrictName;
	}
	
	@Override
	public String toString(){
		return "ReferenceTablesManagementDistrict [ managementDistrictName: " + managementDistrictName + " ]";
	}
	
}
