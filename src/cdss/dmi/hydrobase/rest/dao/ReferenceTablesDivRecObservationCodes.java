package cdss.dmi.hydrobase.rest.dao;

public class ReferenceTablesDivRecObservationCodes {
	
	private int endIyr;
	private String obsCode;
	private String obsCodeLong;
	private String obsDescr;
	private int startIyr;
	
	public int getEndIyr() {
		return endIyr;
	}
	public void setEndIyr(int endIyr) {
		this.endIyr = endIyr;
	}
	public String getObsCode() {
		return obsCode;
	}
	public void setObsCode(String obsCode) {
		this.obsCode = obsCode;
	}
	public String getObsCodeLong() {
		return obsCodeLong;
	}
	public void setObsCodeLong(String obsCodeLong) {
		this.obsCodeLong = obsCodeLong;
	}
	public String getObsDescr() {
		return obsDescr;
	}
	public void setObsDescr(String obsDescr) {
		this.obsDescr = obsDescr;
	}
	public int getStartIyr() {
		return startIyr;
	}
	public void setStartIyr(int startIyr) {
		this.startIyr = startIyr;
	}
	
	@Override
	public String toString(){
		return "ReferenceTablesDivRecObservationCodes: [obsCode: " + obsCode + ", startIyr: " + startIyr + ", endIyr: " + endIyr + 
				", obsCodeLong: " + obsCodeLong + ", obsDescr: " + obsDescr + "]";
	}

}
