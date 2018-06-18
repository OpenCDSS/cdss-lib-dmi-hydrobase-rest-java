package cdss.dmi.hydrobase.rest.dao;

public class ReferenceTablesWaterDistrict {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-waterdistrict
	 */
	
	/* Water Division */
	private int div;
	
	/* Water District */
	private int wd;
	
	/* Water District Name */
	private String wdName;

	public int getDiv() {
		return div;
	}

	public void setDiv(int div) {
		this.div = div;
	}

	public int getWd() {
		return wd;
	}

	public void setWd(int wd) {
		this.wd = wd;
	}

	public String getWdName() {
		return wdName;
	}

	public void setWdName(String wdName) {
		this.wdName = wdName;
	}
	
	@Override
	public String toString(){
		return "ReferenceTablesWaterDistrict [ div: " + div + ", wd: " + wd + ", wdName: " + wdName + " ]";
	}

}
