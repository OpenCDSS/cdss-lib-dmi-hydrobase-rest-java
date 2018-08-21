package cdss.dmi.hydrobase.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class acts as a way to convert results from DWR web services
 * to a plain old java object, for means of processing the data 
 * returned.
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetryshiftadjustedratingtable
 * https://dnrweb.state.co.us/DWR/DwrApiService/Help/Api/GET-api-v2-telemetrystations-telemetryshiftcurve
 * @author jurentie
 *
 */

/**
 * Ignore any properties defined after defining this class.
 * If properties are added that are necessary to data processing these can be added,
 * but for now ignore anything that is new so as to not break the code.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryShift {
	
	/**
	 * Variables declared in alphabetical order.
	 * Documentation copied from web services.
	 */
	
	/**
	 * Rating Table Name
	 */
	private String ratingTableName;
	
	/**
	 * Shift Curve Name
	 */
	private String shiftCurveName;
	
	/**
	 * X Value
	 */
	private double X;
	
	/**
	 * Y Value
	 */
	private double Y;
	
	/**
	 * Getters and setters of defined variables.
	 */
	public String getRatingTableName() {
		return ratingTableName;
	}
	public String getShiftCurveName() {
		return shiftCurveName;
	}
	public double getX() {
		return X;
	}
	public double getY() {
		return Y;
	}
	public void setRatingTableName(String ratingTableName) {
		this.ratingTableName = ratingTableName;
	}
	public void setShiftCurveName(String shiftCurveName) {
		this.shiftCurveName = shiftCurveName;
	}
	public void setX(double x) {
		X = x;
	}
	public void setY(double y) {
		Y = y;
	}
	
	/**
	 * To string method for testing purposes:
	 * Variables defined in order of how they are returned in a json format from
	 * web services
	 */
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
