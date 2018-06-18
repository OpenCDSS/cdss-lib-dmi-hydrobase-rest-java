package cdss.dmi.hydrobase.rest.dao;

public class ReferenceTablesDesigntatedBasin {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-designatedbasin
	 */
	
	/* Designated Basin Name */
	private String designatedBasinName;
	
	public void setDesignatedBasinName(String designatedBasinName){
		this.designatedBasinName = designatedBasinName;
	}
	
	public String getDesignatedBasinName(){
		return designatedBasinName;
	}
	
	@Override
	public String toString(){
		return "ReferenceTablesDesignatedBasin [ designatedBasinName: " + designatedBasinName + " ]";
	}

}
