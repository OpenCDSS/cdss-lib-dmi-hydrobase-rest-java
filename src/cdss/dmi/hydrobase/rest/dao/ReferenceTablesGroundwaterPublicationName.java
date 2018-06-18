package cdss.dmi.hydrobase.rest.dao;

public class ReferenceTablesGroundwaterPublicationName {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-groundwaterpublication
	 */
	
	/* Groundwater Publication Name */
	private String publicationName;
	
	public void setPublicationName(String publicationName){
		this.publicationName = publicationName;
	}
	
	public String getPublicationName(){
		return publicationName;
	}
	
	@Override
	public String toString(){
		return "ReferenceTablesGroundwaterPublicationName [ publicationName: " + publicationName + " ]";
	}

}
