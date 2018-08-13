package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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
		return "ReferenceTablesTelemetryParams [ parameter: " + parameter + " ]";
	}

}
