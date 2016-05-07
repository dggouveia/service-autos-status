package br.edu.ifpb.pos.service.autos.status.resources;

import br.edu.ifpb.pos.service.autos.status.dto.OrdemServico;
import br.edu.ifpb.pos.service.autos.status.dto.StatusOrdemServico;
import br.edu.ifpb.pos.service.autos.status.ext.resources.ClienteResources;
import br.edu.ifpb.pos.service.autos.status.ext.resources.ClienteResourcesProvider;
import br.edu.ifpb.pos.service.autos.status.utils.JsonUtils;
import java.util.ArrayList;
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
public class ListaOSPorStatusResource extends ServerResource{

    private ClienteResources clienteResource = ClienteResourcesProvider.getInstance();
    
    @Get
    public Representation recuperarPorStatus (){
        String status = getAttribute("status");
        List<OrdemServico> todasOs = clienteResource.listarTodasOs();
        List<OrdemServico> result = new ArrayList<>();
        for (OrdemServico os : todasOs){
            if (os.getStatus().equals(status))
                result.add(os);
        }
        return new StringRepresentation(JsonUtils.converterObjectEmJson(result, List.class));
    }
    
}
