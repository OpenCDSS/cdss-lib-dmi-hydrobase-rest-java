package cdss.dmi.hydrobase.rest.dao;

public class ReferenceTablesWaterDivision {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-waterdivision
	 */
	
	/* Water Division */
	private int division;
	
	/* Water Division Name */
	private String divisionName;

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
	
	@Override
	public String toString(){
		return "ReferenceTablesWaterDivision [ div: " + division + ", divName: " + divisionName + " ]"; 
	}

}
