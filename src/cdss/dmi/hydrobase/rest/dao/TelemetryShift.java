package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryShift {

	/**
	 *  Variables declared in order as returned
	 *  by DWR API. For more detail see: 
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetryshiftadjustedratingtable
	 *  https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetryshiftcurve
	 */
	
	private String ratingTableName;
	private String shiftCurveName;
	private double X;
	private double Y;
	
	public String getRatingTableName() {
		return ratingTableName;
	}
	public void setRatingTableName(String ratingTableName) {
		this.ratingTableName = ratingTableName;
	}
	public String getShiftCurveName() {
		return shiftCurveName;
	}
	public void setShiftCurveName(String shiftCurveName) {
		this.shiftCurveName = shiftCurveName;
	}
	public double getX() {
		return X;
	}
	public void setX(double x) {
		X = x;
	}
	public double getY() {
		return Y;
	}
	public void setY(double y) {
		Y = y;
	}
	
	@Override 
	public String toString(){
		if(!ratingTableName.isEmpty()){
			return "TelemetryShiftAdjustedRatingTable: [ ratingTableName: " + ratingTableName + ", X: " + 
					X + ", Y: " + Y;
		}else{
			return "TelemetryShiftCurve: [ shiftCurveName: " + shiftCurveName + ", X: " + X + ", Y: " + Y;
		}
	}
	
}
