package cdss.dmi.hydrobase.rest.dao;

public class ReferenceTablesWaterDivision {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-waterdivision
	 */
	
	/* Water Division */
	private int div;
	
	/* Water Division Name */
	private String divName;

	public int getDiv() {
		return div;
	}

	public void setDiv(int div) {
		this.div = div;
	}

	public String getDivName() {
		return divName;
	}

	public void setDivName(String divName) {
		this.divName = divName;
	}
	
	@Override
	public String toString(){
		return "ReferenceTablesWaterDivision [ div: " + div + ", divName: " + divName + " ]"; 
	}

}
