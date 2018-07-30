package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceTablesCounty {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-county
	 */
	
	/* County */
	private String county;
	
	public void setCounty(String county){
		this.county = county;
	}
	
	public String getCounty(){
		return county;
	}
	
	@Override
	public String toString(){
		return "ReferenceTablesCounty: [ county: " + county + " ]";
	}

}
