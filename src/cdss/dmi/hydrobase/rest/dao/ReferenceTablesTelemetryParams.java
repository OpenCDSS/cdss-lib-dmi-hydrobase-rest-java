package cdss.dmi.hydrobase.rest.dao;

public class ReferenceTablesTelemetryParams {
	
	private String parameter;

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
	@Override
	public String toString(){
		return "Parameter [ parameter: " + parameter + " ]";
	}

}
