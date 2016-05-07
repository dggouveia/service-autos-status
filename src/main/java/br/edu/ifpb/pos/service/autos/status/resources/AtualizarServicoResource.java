package br.edu.ifpb.pos.service.autos.status.resources;

import br.edu.ifpb.pos.service.autos.status.dto.Servico;
import br.edu.ifpb.pos.service.autos.status.dto.StatusOrdemServico;
import br.edu.ifpb.pos.service.autos.status.ext.resources.ClienteResources;
import br.edu.ifpb.pos.service.autos.status.ext.resources.ClienteResourcesProvider;
import br.edu.ifpb.pos.service.autos.status.utils.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import java.io.IOException;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class AtualizarServicoResource extends ServerResource {

    private ClienteResources clienteResource = ClienteResourcesProvider.getInstance();

    @Put
    public Representation atualizarStatusServico(Representation representation) throws IOException {
        String status = new JsonParser().parse(representation.getText())
                .getAsJsonObject().get("status").getAsString();
        try {
            if (StatusOrdemServico.valueOf(status) != null) {
                long id = Long.parseLong(getAttribute("id"));
                Servico servico = clienteResource.atualizarServico(new Servico(id, status));
                return new StringRepresentation(
                        JsonUtils.converterObjectEmJson(servico, Servico.class)
                );
            }
        } catch (Exception e) {
        }
        return new StringRepresentation("{"
                + "message: status inválido"
                + "}");
    }

}
