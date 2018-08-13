package cdss.dmi.hydrobase.rest.dao;

public class ReferenceTablesCurrentInUseCodes {
	
	private String ciuCode;
	private String ciuCodeLong;
	
	public String getCiuCode() {
		return ciuCode;
	}
	public void setCiuCode(String ciuCode) {
		this.ciuCode = ciuCode;
	}
	public String getCiuCodeLong() {
		return ciuCodeLong;
	}
	public void setCiuCodeLong(String ciuCodeLong) {
		this.ciuCodeLong = ciuCodeLong;
	}
	
	@Override
	public String toString(){
		return "ReferenceTablesCurrentInUse: [ciuCode: " + ciuCode + ", ciuCodeLong: " + ciuCodeLong + "]";
	}

}
