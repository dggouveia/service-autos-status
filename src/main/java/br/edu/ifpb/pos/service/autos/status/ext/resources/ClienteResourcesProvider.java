package br.edu.ifpb.pos.service.autos.status.ext.resources;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class ClienteResourcesProvider {

    private static ClienteResources instance;        
    
    public static ClienteResources getInstance (){
        if (instance == null){
            instance = new ClienteResourcesMockup();
        }
        return instance;
    }
    
}
