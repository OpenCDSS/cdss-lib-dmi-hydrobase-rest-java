// ColoradoHydroBaseRest_Structure_InputFilter_JPanel - input filter panel for structure

/* NoticeStart

CDSS HydroBase REST Web Services Java Library
CDSS HydroBase REST Web Services Java Library is a part of Colorado's Decision Support Systems (CDSS)
Copyright (C) 2018-2019 Colorado Department of Natural Resources

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
import java.util.Vector;

import RTi.Util.GUI.InputFilter;
import RTi.Util.GUI.InputFilter_JPanel;

import RTi.Util.String.StringUtil;
import cdss.dmi.hydrobase.rest.ColoradoHydroBaseRestDataStore;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesCounty;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesWaterDistrict;
import cdss.dmi.hydrobase.rest.dao.ReferenceTablesWaterDivision;

@SuppressWarnings("serial")
public class ColoradoHydroBaseRest_Structure_InputFilter_JPanel
extends InputFilter_JPanel
implements MouseListener
{
    
/**
Datastore for this panel
*/
private ColoradoHydroBaseRestDataStore datastore = null;

/**
Create an InputFilter_JPanel for ColoradoHydroBaseRest web services structure queries.
This is used by TSTool.
Default filter panel properties are used (e.g., 3 filter groups).
@return a JPanel containing InputFilter instances for ?? queries.
@param dataStore ColoradoHydroBaseRestDataStore instance.
@param include_SFUT If true, include a filter for the SFUT.
@exception Exception if there is an error.
*/
public ColoradoHydroBaseRest_Structure_InputFilter_JPanel (
		ColoradoHydroBaseRestDataStore dataStore, boolean include_SFUT )
throws Exception
{	this ( dataStore, include_SFUT, -1, -1 );
}

/**
Create an InputFilter_JPanel for ColoradoHydroBaseRest web services structure queries.
This is used by TSTool.
@return a JPanel containing InputFilter instances for ?? queries.
@param datastore ColoradoHydroBaseRestDataStore instance.
@param include_SFUT If true, include a filter for the SFUT.
@param numFilterGroups the number of filter groups to display
@param numWhereChoicesToDisplay the number of where choices to display in each filter
@exception Exception if there is an error.
*/
public ColoradoHydroBaseRest_Structure_InputFilter_JPanel (
    ColoradoHydroBaseRestDataStore datastore, boolean include_SFUT,
    int numFilterGroups, int numWhereChoicesToDisplay )
throws Exception
{	this.datastore = datastore;

	// Now define the input filters

	List<InputFilter> input_filters = new Vector<InputFilter>(8);
	input_filters.add ( new InputFilter ("", "",
	    StringUtil.TYPE_STRING, null, null, true ) ); // Blank to disable filter

	InputFilter filter;
    // County
	List<ReferenceTablesCounty> countyDataList = datastore.getCounties();
	List<String> countyList = new ArrayList<String> ( countyDataList.size() );
	for ( ReferenceTablesCounty county : countyDataList ) {
		countyList.add ( county.getCounty() ); // TODO smalers 2018-06-19 HydroBase has state + ", CO" );
	}
	filter = new InputFilter ( "County", "county", "county", "County",
		StringUtil.TYPE_STRING, countyList, countyList, false );
	filter.setTokenInfo(",",0);
	input_filters.add ( filter );
	
	// Latitude
	input_filters.add ( new InputFilter ( "Latitude", "latitude", "latitude", "Latitude",
		StringUtil.TYPE_DOUBLE, null, null, true ) );

	// Longitude
	input_filters.add ( new InputFilter ( "Longitude", "longitude", "longitude", "Longitude",
		StringUtil.TYPE_DOUBLE, null, null, true ) );

	// Radius around latitude/longitude
	input_filters.add ( new InputFilter ( "LatLong Radius", "radius", "radius", "LatLongRadius",
		StringUtil.TYPE_DOUBLE, null, null, true ) );

	// Radius units, used with radius
	// TODO smalers 2018-06-20 should this be a reference table?
	List<String> radiusUnitsChoices = new ArrayList<String>(2);
	radiusUnitsChoices.add("feet");
	radiusUnitsChoices.add("miles");
	input_filters.add ( new InputFilter ( "LatLong Radius Units", "units", "units", "LatLongRadiusUnits",
		StringUtil.TYPE_STRING, radiusUnitsChoices, radiusUnitsChoices, false ) );

	// Water district
	List<ReferenceTablesWaterDistrict> districtDataList = datastore.getWaterDistricts();
	List<String> districtList = new ArrayList<String> ( districtDataList.size() );
	List<String> districtInternalList = new ArrayList<String>(districtDataList.size());
	for ( ReferenceTablesWaterDistrict wd : districtDataList ) {
		districtList.add ("" + wd.getWaterDistrict() + " - " + wd.getWaterDistrictName());
		districtInternalList.add ("" + wd.getWaterDistrict() );
	}
	filter = new InputFilter ( "Water District", "waterDistrict", "waterDistrict", "WaterDistrict",
		StringUtil.TYPE_STRING, districtList, districtInternalList, false );
	filter.setTokenInfo("-",0,StringUtil.TYPE_INTEGER);
	input_filters.add ( filter );

	// Water division
	List<ReferenceTablesWaterDivision> divisionDataList = datastore.getWaterDivisions();
	List<String> divisionList = new ArrayList<String> ( 7 );
	List<String> divisionInternalList = new ArrayList<String> ( 7 );
	for ( ReferenceTablesWaterDivision div: divisionDataList ) {
		divisionList.add ("" + div.getDivision() + " - " + div.getDivisionName());
		divisionInternalList.add ("" + div.getDivision() );
	}
	filter = new InputFilter ( "Water Division", "waterDivision", "waterDivision", "WaterDivision",
		StringUtil.TYPE_STRING, divisionList, divisionInternalList, false );
	filter.setTokenInfo("-",0,StringUtil.TYPE_INTEGER);
	input_filters.add ( filter );
	
    input_filters.add ( new InputFilter ( "Structure WDID", "wdid", "wdid", "StructureWDID",
        StringUtil.TYPE_STRING, null, null, true ) );

	if ( numFilterGroups < 0 ) {
		// Set number of filter groups to 5 so that latitude, longitude, radius, and units can be specified, plus one other
		numFilterGroups = 5;
	}
	if ( numWhereChoicesToDisplay < 0 ) {
		// Set the number of visible rows in the choices
		numWhereChoicesToDisplay = input_filters.size();
	}
	setToolTipText ( "<html>ColoradoHydroBaseRest structure queries can be filtered based on structure data.</html>" );
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
	// Use the parent class method to check basic input types based on data types
	// - will return empty string if no issues
	String warning = super.checkInputFilters(displayWarning);
	// Perform specific checks
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
	// Check that wdid, division, waterDistrict, county, or wcIdentifier specified
	String Wdid = getInputValue("StructureWDID", false);
	String Division = getInputValue("WaterDivision", false);
	String District = getInputValue("WaterDistrict", false);
	String County = getInputValue("County", false);
	int necInputFilters = 0;
	if( (Wdid != null) && !Wdid.isEmpty()){
		++necInputFilters;
	}
	if( (Division != null) && !Division.isEmpty()){
		++necInputFilters;
	}
	if( (District != null) && !District.isEmpty()){
		++necInputFilters;
	}
	if( (County != null) && !County.isEmpty()){
		++necInputFilters;
	}
	if( !(necInputFilters > 0)){
		warning2 += "\nStructure WDID, Water District, or Water Division is required.";
	}
	if ( !warning2.isEmpty() ) {
		// Have non-empty specific warnings so append specific warnings
		warning += warning2;
	}
	// Return the general warnings or the appended results
	return warning;
}

/**
 * Return the datastore that is used with the input filter panel.
 * @return ColoradoHydroBaseRestDataStore instance used with the filter panel.
 */
public ColoradoHydroBaseRestDataStore getColoradoHydroBaseRestDataStore ()
{
    return datastore;
}

public void mouseClicked(MouseEvent event) {}

public void mouseExited(MouseEvent event) {}

public void mouseEntered(MouseEvent event) {}

/**
Responds to mouse pressed events.
@param event the event that happened.
*/
public void mousePressed(MouseEvent event) {
}

public void mouseReleased(MouseEvent event) {}

}
