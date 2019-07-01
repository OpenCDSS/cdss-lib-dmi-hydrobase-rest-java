// ColoradoHydroBaseRestDataStoreFactory - factory to instantiate ColoradoHydrobaseRestDataStore instances.

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

import java.net.URI;

import RTi.Util.IO.PropList;
import RTi.Util.Message.Message;
import riverside.datastore.DataStore;
import riverside.datastore.DataStoreFactory;

/**
 * Factory to instantiate ColoradoHydroBaseRestDataStore instances.
 * @author sam
 *
 */
public class ColoradoHydroBaseRestDataStoreFactory implements DataStoreFactory
{

/**
Create a ColoradoHydroBaseRestDataStore instance.
*/
public DataStore create ( PropList props )
{   String routine = getClass().getSimpleName() + ".create";
    String name = props.getValue ( "Name" );
    String description = props.getValue ( "Description" );
    if ( description == null ) {
        description = "";
    }
    String serviceRootURI = props.getValue ( "ServiceRootURI" );
    String apiKey = props.getValue("apiKey");
    try {
        DataStore ds = new ColoradoHydroBaseRestDataStore ( name, description, new URI(serviceRootURI), apiKey);
        ds.setProperties ( props );
        return ds;
    }
    catch ( Exception e ) {
        Message.printWarning(3,routine,"Exception opening the Colorado HydroBase REST web service datstore (" + e + ")");
        Message.printWarning(3,routine,e);
        throw new RuntimeException ( e );
    }
}

}