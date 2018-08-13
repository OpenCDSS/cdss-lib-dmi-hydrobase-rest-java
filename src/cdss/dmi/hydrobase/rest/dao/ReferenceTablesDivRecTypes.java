package cdss.dmi.hydrobase.rest.dao;

public class ReferenceTablesDivRecTypes {
	
	private String divRecType;
	private String divRecTypeLong;
	
	public String getDivRecType() {
		return divRecType;
	}
	public void setDivRecType(String divRecType) {
		this.divRecType = divRecType;
	}
	public String getDivRecTypeLong() {
		return divRecTypeLong;
	}
	public void setDivRecTypeLong(String divRecTypeLong) {
		this.divRecTypeLong = divRecTypeLong;
	}
	
	@Override
	public String toString(){
		return "ReferenceTablesDivRecTypes: [ divRecType: " + divRecType + ", divRecTypeLong: " + divRecTypeLong + " ]";
	}

}
