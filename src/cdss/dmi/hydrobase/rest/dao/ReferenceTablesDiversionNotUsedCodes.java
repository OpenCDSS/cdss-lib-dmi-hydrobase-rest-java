package cdss.dmi.hydrobase.rest.dao;

public class ReferenceTablesDiversionNotUsedCodes {
	
	private String notUsedCode;
	private String notUsedCodeDescr;
	
	public String getNotUsedCode() {
		return notUsedCode;
	}
	public void setNotUsedCode(String notUsedCode) {
		this.notUsedCode = notUsedCode;
	}
	public String getNotUsedCodeDescr() {
		return notUsedCodeDescr;
	}
	public void setNotUsedCodeDescr(String notUsedCodeDescr) {
		this.notUsedCodeDescr = notUsedCodeDescr;
	}
	
	@Override
	public String toString(){
		return "ReferenceTablesDiversionNotUsedCodes: [ notUsedCode: " + notUsedCode + ", notUsedCodeDescr: " + notUsedCodeDescr + "]";
	}

}
