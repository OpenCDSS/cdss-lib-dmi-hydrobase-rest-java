package cdss.dmi.hydrobase.rest;

import java.net.URI;

import RTi.Util.IO.PropList;
import RTi.Util.Message.Message;
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
