package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceTablesWaterDistrict {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-waterdistrict
	 */
	
	/* Water Division */
	private int division;
	
	/* Water District */
	private int waterDistrict;
	
	/* Water District Name */
	private String waterDistrictName;

	public int getDivision() {
		return division;
	}

	public void setDivision(int div) {
		this.division = div;
	}

	public int getWaterDistrict() {
		return waterDistrict;
	}

	public void setWaterDistrict(int wd) {
		this.waterDistrict = wd;
	}

	public String getWaterDistrictName() {
		return waterDistrictName;
	}

	public void setWaterDistrictName(String wdName) {
		this.waterDistrictName = wdName;
	}
	
	@Override
	public String toString(){
		return "ReferenceTablesWaterDistrict [ div: " + division + ", wd: " + waterDistrict + ", wdName: " + waterDistrictName + " ]";
	}

}
