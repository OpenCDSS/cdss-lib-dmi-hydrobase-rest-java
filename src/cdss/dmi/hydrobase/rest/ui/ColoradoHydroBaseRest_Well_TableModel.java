// ColoradoHydroBaseRest_Well_TableModel - table model for well

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

import java.text.DecimalFormat;
import java.util.List;

// FIXME @jurentie imports/irrelevant code
//import DWR.DMI.HydroBaseDMI.HydroBase_WaterDistrict;
///import DWR.DMI.HydroBaseDMI.HydroBase_GroundWaterWellsView;

import RTi.TS.TSIdent;
import RTi.TS.TimeSeriesIdentifierProvider;
import RTi.Util.GUI.JWorksheet;
import RTi.Util.GUI.JWorksheet_AbstractRowTableModel;
import cdss.dmi.hydrobase.rest.dao.WaterLevelsWell;

/**
This class is a table model for time series header information for HydroBase well time series that are not stored
with structures.
By default the sheet will contain row and column numbers.
*/
@SuppressWarnings("serial")
public class ColoradoHydroBaseRest_Well_TableModel
extends JWorksheet_AbstractRowTableModel<WaterLevelsWell> implements TimeSeriesIdentifierProvider
{

/**
Number of columns in the table model, including the row number.
*/
private final int __COLUMNS = 23;

public final int COL_ID = 0;
public final int COL_RECEIPT = 1;
public final int COL_NAME = 2;
public final int COL_DATA_SOURCE = 3;
public final int COL_DATA_TYPE = 4;
public final int COL_TIME_STEP = 5;
public final int COL_UNITS = 6;
public final int COL_START = 7;
public final int COL_END = 8;
public final int COL_MEAS_COUNT = 9;
public final int COL_DIV = 10;
public final int COL_DIST = 11;
public final int COL_COUNTY = 12;
public final int COL_STATE = 13;
public final int COL_DESIG_BASIN = 14;
public final int COL_AQUIFERS = 15;
public final int COL_DEPTH = 16;
public final int COL_ELEV = 17;
public final int COL_LONG = 18;
public final int COL_LAT = 19;
public final int COL_UTM_X = 20;
public final int COL_UTM_Y = 21;
public final int COL_INPUT_TYPE = 22;

//private int __wdid_length = 7; // The length to use when formatting WDIDs in IDs.

/**
Input type for time series identifier (default to "HydroBase" but can be set to allow class to be used
with other State-related data, such as ColoradoWaterSMS).
*/
private String inputType = "ColoradoHydroBaseRest";

/**
Constructor.  This builds the model for displaying the given HydroBase time series data.
The input type defaults to "HydroBase".
@param worksheet the JWorksheet that displays the data from the table model.
@param data the list of HydroBase_StationGeolocMeasType or HydroBase_StructureGeolocStructMeasType
that will be displayed in the table (null is allowed - see setData()).
@inputName input name for time series (default if not specified is "ColoradoHydroBaseRest").
@throws Exception if an invalid results passed in.
*/
public ColoradoHydroBaseRest_Well_TableModel ( JWorksheet worksheet, List<WaterLevelsWell> data )
throws Exception {
    this ( worksheet, -1, data, null );
}

/**
Constructor.  This builds the model for displaying the given HydroBase time series data.
The input type defaults to "HydroBase".
@param worksheet the JWorksheet that displays the data from the table model.
@param data the list of HydroBase_StationGeolocMeasType or HydroBase_StructureGeolocStructMeasType
that will be displayed in the table (null is allowed - see setData()).
@inputName input name for time series (default if not specified is "ColoradoHydroBaseRest").
@throws Exception if an invalid results passed in.
*/
public ColoradoHydroBaseRest_Well_TableModel ( JWorksheet worksheet, List<WaterLevelsWell> data, String inputType )
throws Exception {
    this ( worksheet, -1, data, inputType );
}

/**
Constructor.  This builds the model for displaying the given HydroBase time series data.
@param worksheet the JWorksheet that displays the data from the table model.
@param wdid_length Total length to use when formatting WDIDs.
@param data the list of HydroBase_StationGeolocMeasType or HydroBase_StructureGeolocStructMeasType
that will be displayed in the table (null is allowed - see setData()).
@inputType input type for time series (default if null or blank is "ColoradoHydroBaseRest").
@throws Exception if an invalid results passed in.
*/
public ColoradoHydroBaseRest_Well_TableModel ( JWorksheet worksheet, int wdid_length, List<WaterLevelsWell> data, String inputType )
throws Exception
{	if ( wdid_length <= 0 ) {
		wdid_length = 7;
	}
	//__wdid_length = wdid_length;
	if ( data == null ) {
		_rows = 0;
	}
	else {
	    _rows = data.size();
	}
	_data = data;
	if ( (inputType != null) && !inputType.equals("") ) {
	    this.inputType = inputType;
	}
}

/**
From AbstractTableModel.  Returns the class of the data stored in a given column.
@param columnIndex the column for which to return the data class.
*/
public Class<?> getColumnClass (int columnIndex) {
	switch (columnIndex) {
		// FIXME - can't seem to handle missing...
		//case COL_START:		return Integer.class;
		//case COL_END:			return Integer.class;
		//case COL_DIV:			return Integer.class;
		//case COL_DIST:		return Integer.class;
		default: return String.class;
	}
}

/**
From AbstractTableMode.  Returns the number of columns of data.
@return the number of columns of data.
*/
public int getColumnCount() {
	return __COLUMNS;
}

/**
From AbstractTableMode.  Returns the name of the column at the given position.
@return the name of the column at the given position.
*/
public String getColumnName(int columnIndex) {
	switch (columnIndex) {
		case COL_ID: return "ID";
		case COL_RECEIPT: return "Receipt";
		case COL_NAME: return "Name/Description";
		case COL_DATA_SOURCE: return "Data Source";
		case COL_DATA_TYPE: return "Data Type";
		case COL_TIME_STEP: return "Time Step";
		case COL_UNITS: return "Units";
		case COL_START: return "Start";
		case COL_END: return "End";
		case COL_MEAS_COUNT: return "Meas. Count";
		case COL_DIV: return "Div.";
		case COL_DIST: return "Dist.";
		case COL_COUNTY: return "County";
		case COL_STATE: return "State";
		case COL_DESIG_BASIN: return "Designated Basin";
		case COL_AQUIFERS: return "Aquifers";
		case COL_DEPTH: return "Well Depth";
		case COL_ELEV: return "Elevation";
        case COL_LONG: return "Longtitude";
        case COL_LAT: return "Latitude";
		case COL_UTM_X: return "UTM X";
		case COL_UTM_Y: return "UTM Y";
		case COL_INPUT_TYPE: return "Data Store/Input Type";
		default: return "";
	}
}

/**
Returns an array containing the column widths (in number of characters).
@return an integer array containing the widths for each field.
*/
public String[] getColumnToolTips() {
    String[] tips = new String[__COLUMNS];
    tips[COL_ID] = "Well identifier from primary data provider";
    tips[COL_RECEIPT] = "Well permit receipt (unique identifier for well permits)";
    tips[COL_NAME] = "Well name";
    tips[COL_DATA_SOURCE] = "Organization/agency abbreviation";
    tips[COL_DATA_TYPE] = "Data type";
    tips[COL_TIME_STEP] = "Time step";
    tips[COL_UNITS] = "Data units";
    tips[COL_START] = "Starting date/time of available data";
    tips[COL_END] = "Ending date/time of available data";
    tips[COL_MEAS_COUNT] = "Count of available measurements";
    tips[COL_DIV] = "Water division";
    tips[COL_DIST] = "Water district";
    tips[COL_COUNTY] = "County name";
    tips[COL_STATE] = "State abbreviation";
    tips[COL_DESIG_BASIN] = "Designated basin";
    tips[COL_AQUIFERS] = "Aquifers";
    tips[COL_DEPTH] = "Well depth";
    tips[COL_ELEV] = "Well head elevation";
    //tips[COL_HUC] = "Hydrologic Unit Code";
    tips[COL_LONG] = "Longitude decimal degrees";
    tips[COL_LAT] = "Latitude decimal degrees";
    tips[COL_UTM_X] = "UTM X, meters";
    tips[COL_UTM_Y] = "UTM Y, meters";
    tips[COL_INPUT_TYPE] = "Input type or data store name";
    return tips;
}

/**
Returns an array containing the column widths (in number of characters).
@return an integer array containing the widths for each field.
*/
public int[] getColumnWidths() {
    int[] widths = new int[__COLUMNS];
    widths[COL_ID] = 12;
    widths[COL_RECEIPT] = 8;
    widths[COL_NAME] = 20;
    widths[COL_DATA_SOURCE] = 10;
    widths[COL_DATA_TYPE] = 15;
    widths[COL_TIME_STEP] = 8;
    widths[COL_UNITS] = 8;
    widths[COL_START] = 10;
    widths[COL_END] = 10;
    widths[COL_MEAS_COUNT] = 8;
    widths[COL_DIV] = 5;
    widths[COL_DIST] = 5;
    widths[COL_COUNTY] = 8;
    widths[COL_STATE] = 3;
    widths[COL_DESIG_BASIN] = 15;
    widths[COL_AQUIFERS] = 12;
    widths[COL_DEPTH] = 8;
    widths[COL_ELEV] = 6;
    //widths[COL_HUC] = 8;
    widths[COL_LONG] = 8;
    widths[COL_LAT] = 8;
    widths[COL_UTM_X] = 8;
    widths[COL_UTM_Y] = 8;
    widths[COL_INPUT_TYPE] = 15;
    return widths;
}

/**
Returns the format to display the specified column.
@param column column for which to return the format.
@return the format (as used by StringUtil.formatString()).
*/
public String getFormat ( int column ) {
	switch (column) {
		default: return "%s"; // All are strings.
	}
}

/**
From AbstractTableMode.  Returns the number of rows of data in the table.
*/
public int getRowCount() {
	return _rows;
}

/**
Return a TSIdent object for the specified row, used to transfer the table to valid time series identifier.
@return the TSIdent object for the specified row.
@exception Exception if there is an error setting the interval in the TSIdent.
*/
public TSIdent getTimeSeriesIdentifier(int row) {
    TSIdent tsid = new TSIdent();
	String locType = "wellid:";
    String id = "" + getValueAt( row, COL_ID );
    tsid.setLocation(locType + id );
    tsid.setSource((String)getValueAt( row, COL_DATA_SOURCE));
    tsid.setType((String)getValueAt( row, COL_DATA_TYPE));
    try {
    	tsid.setInterval((String)getValueAt ( row, COL_TIME_STEP));
    }
    catch ( Exception e ) {
    	// Recast exception so it does not require declaring in method signature
    	throw new RuntimeException(e);
    }
    // Scenario is blank
    // Sequence number is blank
    tsid.setInputType((String)getValueAt( row, COL_INPUT_TYPE));
    // No input name
    // Format a simple comment that includes the telemetry station name
   	tsid.setComment(id + " - " + (String)getValueAt ( row, COL_NAME));
    return tsid;
}

// FIXME @jurentie 06/20/2018 imports/irrelevant code
/**
From AbstractTableModel.  Returns the data that should be placed in the JTable at the given row and column.
@param row the row for which to return data.
@param col the column for which to return data.
@return the data that should be placed in the JTable at the given row and column.
*/
public Object getValueAt(int row, int col)
{	
	// If sorted, get the position in the data from the displayed row.
	if (_sortOrder != null) {
		row = _sortOrder[row];
	}

	WaterLevelsWell well = _data.get(row);
	
	DecimalFormat df = new DecimalFormat();
	df.setMaximumFractionDigits(6);
	df.setMinimumFractionDigits(6);

	switch(col){
		// case 0 handled above.
		case COL_ID: return well.getWellId();
		case COL_RECEIPT: return well.getReceipt();
		case COL_NAME: return well.getWellName();
		case COL_DATA_SOURCE: return well.getDataSource();
		case COL_DATA_TYPE: return well.getDataType();
		case COL_TIME_STEP: return well.getTimeStep();
		case COL_UNITS: return "FT";
		case COL_START: return well.getPorStart().getYear();
		case COL_END: return well.getPorEnd().getYear();
		case COL_MEAS_COUNT: return well.getPorCount();
		case COL_DIV: return well.getDivision();
		case COL_DIST: return well.getWaterDistrict();
		case COL_COUNTY: return well.getCounty();
		case COL_STATE: return "CO";
		case COL_DESIG_BASIN: return well.getDesignatedBasin();
		case COL_AQUIFERS: return well.getAquifers();
		case COL_DEPTH: return well.getWellDepth();
		case COL_ELEV: return well.getElevation();
		//case COL_HUC: return
		case COL_LONG:
			Double longitude = well.getLongitude();
			if ( longitude == null ) {
				return null;
			}
			else {
				return df.format(longitude);
			}
		case COL_LAT:
			Double latitude = well.getLatitude();
			if ( latitude == null ) {
				return null;
			}
			else {
				return df.format(latitude);
			}
		case COL_UTM_X: return well.getUtmX();
    	case COL_UTM_Y: return well.getUtmY();
		//case COL_STR_TYPE: return
		//case COL_STRTYPE: return
		case COL_INPUT_TYPE:
			return this.inputType;
		default: return "";
	}
}

/**
Set the input type (default is "HydroBase" but need to change when the table model is used for multiple purposes.
*/
public void setInputType ( String inputType ) {
    this.inputType = inputType;
}

/**
Set the width of WDIDs, which controls formatting of the ID column for structures.
@param wdid_length WDID length for formatting the ID.
*/
public void setWDIDLength ( int wdid_length )
{	//__wdid_length = wdid_length;
}

}