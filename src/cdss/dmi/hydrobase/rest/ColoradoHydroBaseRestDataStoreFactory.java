package cdss.dmi.hydrobase.rest;

import java.net.URI;

import RTi.Util.IO.PropList;
import riverside.datastore.DataStore;
import riverside.datastore.DataStoreFactory;

/**
 * Factory to instantiate ColoradoHydrobaseRestDataStore instances.
 * @author sam
 *
 */
public class ColoradoHydroBaseRestDataStoreFactory implements DataStoreFactory
{

/**
Create an ColoradoHydrobaseRestDataStore instance.
*/
public DataStore create ( PropList props )
{
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
        throw new RuntimeException ( e );
    }
}

}