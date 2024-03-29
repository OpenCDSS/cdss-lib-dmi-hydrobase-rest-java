// ColoradoHydroBaseRest_TelemetryStation_InputFilter_JPanel - input filter panel for telemetry station data types for time series list

/* NoticeStart

CDSS HydroBase REST Web Services Java Library
CDSS HydroBase REST Web Services Java Library is a part of Colorado's Decision Support Systems (CDSS)
Copyright (C) 2018-2023 Colorado Department of Natural Resources

CDSS HydroBase REST Web Services Java Library is free software:  you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    CDSS HydroBase REST Web Services Java Library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with CDSS HydroBase REST Web Services Java Library.  If not, see <https://www.gnu.org/licenses/>.

NoticeEnd */

package cdss.dmi.hydrobase.rest.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import RTi.Util.GUI.InputFilter;
import RTi.Util.GUI.InputFilter_JPanel;

import RTi.Util.String.StringUtil;
import cdss.dmi.hydrobase.rest.ColoradoHydroBaseRestDataStore;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesCounty;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesWaterDistrict;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesWaterDivision;

@SuppressWarnings("serial")
public class ColoradoHydroBaseRest_TelemetryStation_InputFilter_JPanel
extends InputFilter_JPanel
implements MouseListener
{

/**
Datastore for this panel.
*/
private ColoradoHydroBaseRestDataStore datastore = null;

/**
Create an InputFilter_JPanel for ColoradoHydroBaseRest web services telemetry (real-time) station queries.
This is used by TSTool.
Default filter panel properties are used (e.g., 3 filter groups).
@return a JPanel containing InputFilter instances for telemetry station queries.
@param dataStore ColoradoHydroBaseRestDataStore instance.
@exception Exception if there is an error.
*/
public ColoradoHydroBaseRest_TelemetryStation_InputFilter_JPanel (
		ColoradoHydroBaseRestDataStore dataStore )
throws Exception {
	this ( dataStore, -1, -1 );
}

/**
Create an InputFilter_JPanel for ColoradoHydroBaseRest web services telemetry (real-time) station queries.
This is used by TSTool.
@return a JPanel containing InputFilter instances for telemetry station queries.
@param dataStore ColoradoHydroBaseRestDataStore instance.
@param numFilterGroups the number of filter groups to display
@param numWhereChoicesToDisplay the number of where choices to display in each filter
@exception Exception if there is an error.
*/
public ColoradoHydroBaseRest_TelemetryStation_InputFilter_JPanel (
		ColoradoHydroBaseRestDataStore datastore, int numFilterGroups, int numWhereChoicesToDisplay )
throws Exception {
	this.datastore = datastore;

	// Define the input filters.

	List<InputFilter> input_filters = new ArrayList<>(8);
	input_filters.add ( new InputFilter ("", "",
	    StringUtil.TYPE_STRING, null, null, true ) ); // Blank to disable filter.

	InputFilter filter;

	// County.
	List<ReferenceTablesCounty> countyDataList = datastore.getCounties();
	List<String> countyList = new ArrayList<> ( countyDataList.size() );
	for ( ReferenceTablesCounty county : countyDataList ) {
		countyList.add ( county.getCounty() ); // TODO smalers 2018-06-19 HydroBase has state + ", CO" );
	}
	filter = new InputFilter ( "County",
		"county", "county", "county",
		StringUtil.TYPE_STRING, countyList, countyList, false );
	filter.setTokenInfo(",",0);
	input_filters.add ( filter );

	// Latitude.
	input_filters.add ( new InputFilter ( "Latitude",
		"latitude", "latitude", "latitude",
		StringUtil.TYPE_DOUBLE, null, null, true ) );

	// Longitude.
	input_filters.add ( new InputFilter ( "Longitude",
		"longitude", "longitude", "longitude",
		StringUtil.TYPE_DOUBLE, null, null, true ) );

	// Radius around latitude/longitude.
	input_filters.add ( new InputFilter ( "LatLong Radius",
		"radius", "radius", "LatLongRadius",
		StringUtil.TYPE_DOUBLE, null, null, true ) );

	// Radius units, used with radius:
	// - TODO smalers 2018-06-20 should this be a reference table?
	List<String> radiusUnitsChoices = new ArrayList<>(2);
	radiusUnitsChoices.add("feet");
	radiusUnitsChoices.add("miles");
	input_filters.add ( new InputFilter ( "LatLong Radius Units",
		"units", "units", "LatLongRadiusUnits",
		StringUtil.TYPE_STRING, radiusUnitsChoices, radiusUnitsChoices, false ) );

	// Station abbreviation.
	input_filters.add ( new InputFilter ( "Station Abbreviation",
		"abbrev", "abbrev", "StationAbbreviation",
		StringUtil.TYPE_STRING, null, null, true ) );

	// Station type.
	input_filters.add ( new InputFilter ( "Station Type",
		"stationType", "stationType", "StationType",
		StringUtil.TYPE_STRING, null, null, true ) );

	// USIS identifier.
	input_filters.add ( new InputFilter ( "USGS Station ID",
		"usgsStationId", "usgsStationId", "USGSStationID",
		StringUtil.TYPE_STRING, null, null, true ) );

	// Water district.
	List<ReferenceTablesWaterDistrict> districtDataList = datastore.getWaterDistricts();
	List<String> districtList = new ArrayList<> ( districtDataList.size() );
	List<String> districtInternalList = new ArrayList<>(districtDataList.size());
	for ( ReferenceTablesWaterDistrict wd : districtDataList ) {
		districtList.add ("" + wd.getWaterDistrict() + " - " + wd.getWaterDistrictName());
		districtInternalList.add ("" + wd.getWaterDistrict() );
	}
	filter = new InputFilter ( "Water District",
		"waterDistrict", "waterDistrict", "WaterDistrict",
		StringUtil.TYPE_STRING, districtList, districtInternalList, false );
	filter.setTokenInfo("-",0,StringUtil.TYPE_INTEGER);
	input_filters.add ( filter );

	// Water district identifier.
	input_filters.add ( new InputFilter ( "WDID",
		"str_name", "str_name", "WDID",
		StringUtil.TYPE_STRING, null, null, true ) );

	// Water division.
	List<ReferenceTablesWaterDivision> divisionDataList = datastore.getWaterDivisions();
	List<String> divisionList = new ArrayList<> ( 7 );
	List<String> divisionInternalList = new ArrayList<> ( 7 );
	for ( ReferenceTablesWaterDivision div: divisionDataList ) {
		divisionList.add ("" + div.getDivision() + " - " + div.getDivisionName());
		divisionInternalList.add ("" + div.getDivision() );
	}
	filter = new InputFilter ( "Water Division",
		"waterDivision", "waterDivision", "WaterDivision",
		StringUtil.TYPE_STRING, divisionList, divisionInternalList, false );
	filter.setTokenInfo("-",0,StringUtil.TYPE_INTEGER);
	input_filters.add ( filter );

	if ( numFilterGroups < 0 ) {
		// Set number of filter groups to 5 so that latitude, longitude, radius, units, and one other can be specified.
		numFilterGroups = 5;
	}
	if ( numWhereChoicesToDisplay < 0 ) {
		// Set the number of visible rows in the choices.
		numWhereChoicesToDisplay = input_filters.size();
	}
	setToolTipText ( "<html>ColoradoHydroBaseRest telemetry station queries can be filtered based on station data.</html>" );
	setInputFilters ( input_filters, numFilterGroups, numWhereChoicesToDisplay );
}

/**
 * Check the input filter for appropriate combination of choices.
 * These checks can be performed in the ReadColoradoHydroBaseRest command and the main TSTool UI,
 * both of which use this class.
 * @param displayWarning If true, display a warning dialog if there are errors in the input.
 * If false, do not display a warning, in which case
 * the calling code should generally display a warning and optionally
 * also perform other checks by overriding this method.
 * @return null if no issues or a string that indicates issues,
 * can use \n for line breaks and put at the front of the string.
 */
@Override
public String checkInputFilters ( boolean displayWarning ) {
	// Use the parent class method to check basic input types based on data types:
	// - will return empty string if no issues
	String warning = super.checkInputFilters(displayWarning);
	// Perform specific checks.
	String warning2 = "";
	int coordCount = 0;
	String Latitude = getInputValue("Latitude", false);
	String Longitude = getInputValue("Longitude", false);
	String LatLongRadius = getInputValue("LatLongRadius", false);
	String LatLongRadiusUnits = getInputValue("LatLongRadiusUnits", false);
	if ( (Latitude != null) && !Latitude.isEmpty() ) {
		++coordCount;
	}
	if ( (Longitude != null) && !Longitude.isEmpty() ) {
		++coordCount;
	}
	if ( (LatLongRadius != null) && !LatLongRadius.isEmpty() ) {
		++coordCount;
	}
	if ( (LatLongRadiusUnits != null) && !LatLongRadiusUnits.isEmpty() ) {
		++coordCount;
	}
	if ( (coordCount > 0) && (coordCount != 4) ) {
		warning2 += "\nSpecifying latitude and longitude requires specifying latitude, longitude, radius, and units.";
	}
	if ( !warning2.isEmpty() ) {
		// Have non-empty specific warnings so append specific warnings.
		warning += warning2;
	}
	// Return the general warnings or the appended results.
	return warning;
}

public ColoradoHydroBaseRestDataStore getColoradoHydroBaseRestDataStore () {
    return this.datastore;
}

public void mouseClicked(MouseEvent event) {
}

public void mouseExited(MouseEvent event) {
}

public void mouseEntered(MouseEvent event) {
}

/**
Responds to mouse pressed events.
@param event the event that happened.
*/
public void mousePressed(MouseEvent event) {
}

public void mouseReleased(MouseEvent event) {
}

}