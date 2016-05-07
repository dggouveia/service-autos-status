package br.edu.ifpb.pos.service.autos.status.resources;

import br.edu.ifpb.pos.service.autos.status.ext.resources.ClienteResources;
import br.edu.ifpb.pos.service.autos.status.ext.resources.ClienteResourcesProvider;
import br.edu.ifpb.pos.service.autos.status.utils.JsonUtils;
import java.util.List;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class ListaStatusTodasOsResource extends ServerResource {

    private ClienteResources clienteResource = ClienteResourcesProvider.getInstance();

    @Get
    public Representation recuperarPorStatus() {
        return new StringRepresentation(JsonUtils.converterObjectEmJson
            (clienteResource.listarTodasOs(), List.class
        ));
    }

}
