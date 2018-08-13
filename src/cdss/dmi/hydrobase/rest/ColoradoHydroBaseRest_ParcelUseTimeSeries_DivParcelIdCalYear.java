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
