// ColoradoHydroBaseRest_WaterClass_CellRenderer - cell renderer for water class

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

import RTi.Util.GUI.JWorksheet_DefaultTableCellRenderer;

/**
This class is used to render cells for TSTool_HydroBase_WaterClassGeolocStructMeasType_TableModel data.
*/
@SuppressWarnings("serial")
public class ColoradoHydroBaseRest_WaterClass_CellRenderer
extends JWorksheet_DefaultTableCellRenderer {

ColoradoHydroBaseRest_WaterClass_TableModel __table_model = null;	// Table model to render

/**
Constructor.
@param table_model The TSTool_HydroBase_TableModel to render.
*/
public ColoradoHydroBaseRest_WaterClass_CellRenderer ( ColoradoHydroBaseRest_WaterClass_TableModel table_model )
{	__table_model = table_model;
}

/**
Returns the format for a given column.
@param column the column for which to return the format.
@return the column format as used by StringUtil.formatString().
*/
public String getFormat(int column) {
	return __table_model.getFormat(column);	
}

/**
Returns the widths of the columns in the table.
@return an integer array of the widths of the columns in the table.
*/
public int[] getColumnWidths() {
	return __table_model.getColumnWidths();
}

}
