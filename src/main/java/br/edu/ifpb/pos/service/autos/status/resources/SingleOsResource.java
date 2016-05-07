package br.edu.ifpb.pos.service.autos.status.resources;

import br.edu.ifpb.pos.service.autos.status.dto.OrdemServico;
import br.edu.ifpb.pos.service.autos.status.dto.StatusOrdemServico;
import br.edu.ifpb.pos.service.autos.status.ext.resources.ClienteResources;
import br.edu.ifpb.pos.service.autos.status.ext.resources.ClienteResourcesProvider;
import br.edu.ifpb.pos.service.autos.status.utils.JsonUtils;
import com.google.gson.JsonParser;
import java.io.IOException;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class SingleOsResource extends ServerResource{

    private ClienteResources clienteResource = ClienteResourcesProvider.getInstance();
    
    @Get
    public Representation verStatusOrdem (){
        return new StringRepresentation(
                JsonUtils.converterObjectEmJson(
                        clienteResource.verOrdemServico(Long.parseLong(getAttribute("id")))
                        , OrdemServico.class
                )
        );
    }
    
    @Put
    public Representation modificarStatusOrdem (Representation representation) throws IOException{
        String status = new JsonParser().parse(representation.getText())
                .getAsJsonObject().get("status").getAsString();
        if (StatusOrdemServico.valueOf(status) != null){
            OrdemServico os = new OrdemServico(
                    Long.parseLong(getAttribute("id")),
                    status,
                    null
            );
            return new StringRepresentation(
                    JsonUtils.converterObjectEmJson(clienteResource.atualizarOrdemServico(os), OrdemServico.class)
            );
        }
        return new StringRepresentation("{"
                + "message: status inválido"
                + "}");
    }
    
}
