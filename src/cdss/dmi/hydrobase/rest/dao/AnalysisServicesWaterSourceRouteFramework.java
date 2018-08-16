package cdss.dmi.hydrobase.rest.dao;

public class AnalysisServicesWaterSourceRouteFramework {
	
	private int division;
	private String gnisId;
	private String gnisName;
	private double streamLength;
	private String tribGnisName;
	private String TributaryToGnisId;
	private int tributaryToLevel;
	private double tributaryToStreamMile;
	private int waterDistrict;
	
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	public String getGnisId() {
		return gnisId;
	}
	public void setGnisId(String gnisId) {
		this.gnisId = gnisId;
	}
	public String getGnisName() {
		return gnisName;
	}
	public void setGnisName(String gnisName) {
		this.gnisName = gnisName;
	}
	public double getStreamLength() {
		return streamLength;
	}
	public void setStreamLength(double streamLength) {
		this.streamLength = streamLength;
	}
	public String getTribGnisName() {
		return tribGnisName;
	}
	public void setTribGnisName(String tribGnisName) {
		this.tribGnisName = tribGnisName;
	}
	public String getTributaryToGnisId() {
		return TributaryToGnisId;
	}
	public void setTributaryToGnisId(String tributaryToGnisId) {
		TributaryToGnisId = tributaryToGnisId;
	}
	public int getTributaryToLevel() {
		return tributaryToLevel;
	}
	public void setTributaryToLevel(int tributaryToLevel) {
		this.tributaryToLevel = tributaryToLevel;
	}
	public double getTributaryToStreamMile() {
		return tributaryToStreamMile;
	}
	public void setTributaryToStreamMile(double tributaryToStreamMile) {
		this.tributaryToStreamMile = tributaryToStreamMile;
	}
	public int getWaterDistrict() {
		return waterDistrict;
	}
	public void setWaterDistrict(int waterDistrict) {
		this.waterDistrict = waterDistrict;
	}
	
	@Override
	public String toString(){
		return "AnalysisServicesWaterSourceRouteFramework: [ division: " + division + ", waterDistrict: " + waterDistrict + 
				", gnisId: " + gnisId + ", streamLength: " + streamLength + ", tributaryToLevel: " + tributaryToLevel + 
				", TributaryToGnisId: " + TributaryToGnisId + ", tribGnisName: " + tribGnisName + ", tributaryToStreamMile: " +
				tributaryToStreamMile + " ]";
	}

}
