package cdss.dmi.hydrobase.rest.dao;

public class ReferenceTablesPermitActionName {
	
	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-referencetables-permitactionname
	 */
	
	/* Action Name */
	private String actionName;
	
	/* Action Description */
	private String actionDescr;
	
	public void setActionName(String actionName){
		this.actionName = actionName;
	}
	
	public String getActionName(){
		return actionName;
	}
	
	public void setActionDescr(String actionDescr){
		this.actionDescr = actionDescr;
	}
	
	public String getActionDescr(){
		return actionDescr;
	}
	
	@Override
	public String toString(){
		return "ReferenceTablesPermitActionName [ actionName: " + actionName + ", actionDescr: " + actionDescr + " ]";
	}

}
