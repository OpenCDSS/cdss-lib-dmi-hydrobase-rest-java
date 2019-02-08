// ColoradoHydroBaseRest_WaterRightsNetAmount_Comparator_AdminNoOrderNo - compare two WaterRightsNetAmount objects,
// as per the Comparator interface, sorting by admin number and then order number

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

package cdss.dmi.hydrobase.rest;

import java.util.Comparator;

import cdss.dmi.hydrobase.rest.dao.WaterRightsNetAmount;

public class ColoradoHydroBaseRest_WaterRightsNetAmount_Comparator_AdminNoOrderNo 
implements Comparator<WaterRightsNetAmount>{
	
	/**
	 * Compare two WaterRightsNetAmount objects, as per the Comparator interface, sorting by admin number 
	 * and then order number
	 * @param o1 first instance
	 * @param o2 second instance
	 * @return 1 if o1 is greater, -1 if o1 is less, and 0 if the same (based on admin number and order number)
	 */
	public int compare ( WaterRightsNetAmount o1, WaterRightsNetAmount o2){
		
		double adminNo1 = o1.getAdminNumber();
		double adminNo2 = o2.getAdminNumber();
		if( adminNo1 > adminNo2 ){
			return 1;
		}
		else if ( adminNo1 < adminNo2 ){
			return -1;
		}
		
		int orderNo1 = o1.getOrderNumber();
		int orderNo2 = o1.getOrderNumber();
		if( orderNo1 > orderNo2 ){
			return 1;
		}
		else if( orderNo1 < orderNo2 ){
			return -1;
		}
		
		// Fall through...
		return 0;
		
	}

}
