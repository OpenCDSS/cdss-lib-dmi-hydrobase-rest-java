// ColoradoHydroBaseRest_ParcelUseTimeSeries_DivParcelIdCalYear - compare two ParcelUseTimeSeries objects,
// as per the Comparator interface, sorting by div, parcel id, and then year

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

import cdss.dmi.hydrobase.rest.dao.ParcelUseTimeSeries;

public class ColoradoHydroBaseRest_ParcelUseTimeSeries_DivParcelIdCalYear 
implements Comparator<ParcelUseTimeSeries> {

	/**
	 * Compare two ParcelUseTimeSeries objects, as per the Comparator interface, sorting by div, 
	 * parcel id, and then year
	 * @param o1 first instance
	 * @param o2 second instance
	 * @return 1 if o1 is greater, -1 if o1 is less, and 0 if the same (based on div, parcel id, and year)
	 */

	@Override
	public int compare(ParcelUseTimeSeries o1, ParcelUseTimeSeries o2) {
		
		int div1 = o1.getDiv();
		int div2 = o2.getDiv();
		if ( div1 > div2 ) {
			return 1;
		}
		else if ( div1 < div2 ){
			return -1;
		}
		
		int parcelId1 = o1.getParcelId();
		int parcelId2 = o2.getParcelId();
		if ( parcelId1 > parcelId2 ){
			return 1;
		}
		else if ( parcelId1 < parcelId2 ){
			return -1;
		}
		
		int calYear1 = o1.getCalYear();
		int calYear2 = o2.getCalYear();
		if ( calYear1 > calYear2 ){
			return 1;
		}
		else if ( calYear1 < calYear2 ){
			return -1;
		}
		
		return 0;
	}
}
