// ColoradoHydroBaseRest_ClimateStation_TableModel - table model for climate stations

/* NoticeStart

CDSS HydroBase REST Web Services Java Library
CDSS HydroBase REST Web Services Java Library is a part of Colorado's Decision Support Systems (CDSS)
Copyright (C) 2018-2022 Colorado Department of Natural Resources

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

import RTi.TS.TSIdent;
import RTi.TS.TimeSeriesIdentifierProvider;
import RTi.Util.GUI.JWorksheet;
import RTi.Util.GUI.JWorksheet_AbstractRowTableModel;
import RTi.Util.Time.DateTime;
import cdss.dmi.hydrobase.rest.dao.ClimateStationDataType;

/**
This class is a table model for time series header information for HydroBase climate station time series.
By default the table will contain row and column numbers.
*/
@SuppressWarnings("serial")
public class ColoradoHydroBaseRest_ClimateStation_TableModel extends JWorksheet_AbstractRowTableModel<ClimateStationDataType>
implements TimeSeriesIdentifierProvider
{

/**
Number of columns in the table model, including the row number.
*/
private final int __COLUMNS = 17;

public final int COL_SITE_ID = 0;
public final int COL_NAME = 1;
public final int COL_DATA_SOURCE = 2;
public final int COL_DATA_TYPE = 3;
public final int COL_TIME_STEP = 4;
public final int COL_UNITS = 5;
public final int COL_START = 6;
public final int COL_END = 7;
//public final int COL_MEAS_COUNT = 10;
public final int COL_DIV = 8;
public final int COL_DIST = 9;
public final int COL_COUNTY = 10;
public final int COL_STATE = 11;
public final int COL_LONG = 12;
public final int COL_LAT = 13;
public final int COL_UTM_X = 14;
public final int COL_UTM_Y = 15;
public final int COL_INPUT_TYPE = 16;

/**
Input type for time series identifier.
*/
private String inputType = "ColoradoHydroBaseRest";

/**
Data interval.
*/
private String interval = "";

/**
Constructor.  This builds the model for displaying the given HydroBase time series data.
@param worksheet the JWorksheet that displays the data from the table model.
@param data the list of ColoradoHydroBaseRest_ClimateStationDataType that will be displayed in the table
(null is allowed - see setData()).
@inputName input name for time series
@throws Exception if an invalid results passed in.
*/
public ColoradoHydroBaseRest_ClimateStation_TableModel ( JWorksheet worksheet, List<ClimateStationDataType> data )
throws Exception {
    this ( worksheet, data, "", null );
}

/**
Constructor.  This builds the model for displaying the given HydroBase time series data.
@param worksheet the JWorksheet that displays the data from the table model.
@param data the list of ColoradoHydroBaseRest_ClimateStationDataType
that will be displayed in the table (null is allowed - see setData()).
@param interval time series interval (e.g., "Day"), from TSTool UI
@param input type for time series.
@throws Exception if an invalid results passed in.
*/
public ColoradoHydroBaseRest_ClimateStation_TableModel ( JWorksheet worksheet, List<ClimateStationDataType> data, String interval, String inputType )
throws Exception {
	if ( data == null ) {
		this._rows = 0;
	}
	else {
	    this._rows = data.size();
	}
	this._data = data;
	this.interval = interval;
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
		//case COL_ID: return "ID";
		case COL_SITE_ID: return "Site ID";
		case COL_NAME: return "Name/Description";
		case COL_DATA_SOURCE: return "Data Source";
		case COL_DATA_TYPE: return "Data Type";
		case COL_TIME_STEP: return "Time Step";
		case COL_UNITS: return "Units";
		case COL_START: return "Start";
		case COL_END: return "End";
		//case COL_MEAS_COUNT: return "Meas. Count";
		case COL_DIV: return "Div.";
		case COL_DIST: return "Dist.";
		case COL_COUNTY: return "County";
		case COL_STATE: return "State";
        case COL_LONG: return "Longtitude";
        case COL_LAT: return "Latitude";
		case COL_UTM_X: return "UTM X";
		case COL_UTM_Y: return "UTM Y";
		case COL_INPUT_TYPE: return "Datastore/Input Type";
		default: return "";
	}
}

/**
Returns an array containing the column widths (in number of characters).
@return an integer array containing the widths for each field.
*/
public String[] getColumnToolTips() {
    String[] tips = new String[__COLUMNS];
    //tips[COL_ID] = "Station identifier from primary data provider";
    tips[COL_SITE_ID] = "Site identifier.";
    tips[COL_NAME] = "Station name";
    tips[COL_DATA_SOURCE] = "Organization/agency name";
    tips[COL_DATA_TYPE] = "Data type";
    tips[COL_TIME_STEP] = "Time step";
    tips[COL_UNITS] = "Data units are not currently available from web services for station/parameter";
    tips[COL_START] = "Starting date/time of available data";
    tips[COL_END] = "Ending date/time of available data";
    //tips[COL_MEAS_COUNT] = "Count of available measurements";
    tips[COL_DIV] = "Water division";
    tips[COL_DIST] = "Water district";
    tips[COL_COUNTY] = "County name";
    tips[COL_STATE] = "State abbreviation";
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
    widths[COL_SITE_ID] = 9;
    widths[COL_NAME] = 20;
    widths[COL_DATA_SOURCE] = 10;
    widths[COL_DATA_TYPE] = 15;
    widths[COL_TIME_STEP] = 7;
    widths[COL_UNITS] = 8;
    widths[COL_START] = 7;
    widths[COL_END] = 7;
    //widths[COL_MEAS_COUNT] = 8;
    widths[COL_DIV] = 3;
    widths[COL_DIST] = 3;
    widths[COL_COUNTY] = 8;
    widths[COL_STATE] = 3;
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
   	String siteId = (String)getValueAt( row, COL_SITE_ID );
   	tsid.setLocation(siteId);
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
    // Format a simple comment that includes the station ID.
   	tsid.setComment(siteId + " - " + (String)getValueAt ( row, COL_NAME));
    return tsid;
}

/**
From AbstractTableModel.  Returns the data that should be placed in the JTable at the given row and column.
@param row the row for which to return data.
@param col the column for which to return data.
@return the data that should be placed in the JTable at the given row and column.
*/
public Object getValueAt(int row, int col) {	
	if (_sortOrder != null) {
		row = _sortOrder[row];
	}
	
	DecimalFormat df = new DecimalFormat();
	df.setMaximumFractionDigits(6);
	df.setMinimumFractionDigits(6);

	ClimateStationDataType tsds = _data.get(row);
	
	DateTime dt;
	switch (col) {
		// case 0 handled above.
		case COL_SITE_ID: return tsds.getSiteId();
		case COL_NAME: return tsds.getStationName();
		case COL_DATA_SOURCE: return tsds.getDataSource();
		case COL_DATA_TYPE:
			// Data type is consistent with TSTool, don't use measType directly.
			//return tsds.getMeasType();
			return tsds.getDataType();
		case COL_TIME_STEP:
			return this.interval;
		case COL_UNITS: return tsds.getMeasUnit();
		case COL_START:
			dt = tsds.getPorStart();
			if ( dt == null ) {
				return null;
			}
			else if ( this.interval.equalsIgnoreCase("day") ) {
				dt.setPrecision(DateTime.PRECISION_DAY);
			}
			else if ( this.interval.equalsIgnoreCase("month") ) {
				dt.setPrecision(DateTime.PRECISION_MONTH);
			}
			else if ( this.interval.equalsIgnoreCase("year") ) {
				dt.setPrecision(DateTime.PRECISION_YEAR);
			}
			return dt.toString();
		case COL_END:
			dt = tsds.getPorEnd();
			if ( dt == null ) {
				return null;
			}
			else if ( this.interval.equalsIgnoreCase("day") ) {
				dt.setPrecision(DateTime.PRECISION_DAY);
			}
			else if ( this.interval.equalsIgnoreCase("month") ) {
				dt.setPrecision(DateTime.PRECISION_MONTH);
			}
			else if ( this.interval.equalsIgnoreCase("year") ) {
				dt.setPrecision(DateTime.PRECISION_YEAR);
			}
			return dt.toString();
		//case COL_MEAS_COUNT: return
		case COL_DIV: return tsds.getDivision();
		case COL_DIST: return tsds.getWaterDistrict();
		case COL_COUNTY: return tsds.getCounty();
		case COL_STATE: return "CO";
		case COL_LONG:
			Double longitude = tsds.getLongitude();
			if ( longitude == null ) {
				return null;
			}
			else {
				return df.format(longitude);
			}
		case COL_LAT:
			Double latitude = tsds.getLatitude();
			if ( latitude == null ) {
				return null;
			}
			else {
				return df.format(latitude);
			}
		case COL_UTM_X: return tsds.getUtmX();
		case COL_UTM_Y: return tsds.getUtmY();
		case COL_INPUT_TYPE: return inputType;
		default: return "";
	}
}

/**
Set the input type (default is "HydroBase" but need to change when the table model is used for multiple purposes.
@param inputType the input type for the time series identifier, the datastore name
*/
public void setInputType ( String inputType ) {
    this.inputType = inputType;
}

}