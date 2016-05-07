package br.edu.ifpb.pos.service.autos.status;

import br.edu.ifpb.pos.service.autos.status.resources.AtualizarServicoResource;
import br.edu.ifpb.pos.service.autos.status.resources.SingleOsResource;
import br.edu.ifpb.pos.service.autos.status.resources.ListaOSPorStatusResource;
import br.edu.ifpb.pos.service.autos.status.resources.ListaStatusTodasOsResource;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class Loader {

    public static void main(String[] args) throws Exception {
        Component component = new Component();
        int port;
        try{
            port = Integer.parseInt(System.getenv("PORT"));
        }catch (Exception e){
            port = 8090;
        }
        component.getServers().add(Protocol.HTTP, port);
        Router router = new Router();
        router.attach("/os/status/{status}", ListaOSPorStatusResource.class);        
        router.attach("/os/status", ListaStatusTodasOsResource.class);        
        router.attach("/os/{id}/status", SingleOsResource.class);        
        router.attach("/os/servico/{id}", AtualizarServicoResource.class);        
        Application app1 = new Application();
        app1.setInboundRoot(router);
        component.getDefaultHost().attach("", app1);
        component.start();
    }
    
}
