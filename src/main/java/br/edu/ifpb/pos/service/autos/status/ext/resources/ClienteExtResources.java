package br.edu.ifpb.pos.service.autos.status.ext.resources;

import br.edu.ifpb.pos.service.autos.status.dto.OrdemServico;
import br.edu.ifpb.pos.service.autos.status.dto.Servico;
import br.edu.ifpb.pos.service.autos.status.utils.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class ClienteExtResources implements ClienteResources{

    private final String HOST = "http://host";
    private final String CONTROLE_OS = HOST+"/os";
    private final String CONTROLE_SERVICO = HOST+"/os/servico";
    
    @Override
    public List<OrdemServico> listarTodasOs (){
        ClientResource client = new ClientResource(CONTROLE_OS);
        List<OrdemServico> result = new ArrayList<>();
        try {
            return JsonUtils.converterJsonEmLista(client.get().getText(), result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public OrdemServico atualizarOrdemServico(OrdemServico os) {
        ClientResource client = new ClientResource(CONTROLE_OS+"/"+os.getNumero());
        try {
            return JsonUtils.converterJsonEmObjeto(client.put(os).getText(), OrdemServico.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public OrdemServico verOrdemServico(long numero) {
        ClientResource client = new ClientResource(CONTROLE_OS + "/" + numero);
        try {
            return JsonUtils.converterJsonEmObjeto(client.get().getText(), OrdemServico.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Servico atualizarServico(Servico servico) {
        ClientResource client = new ClientResource(CONTROLE_SERVICO + "/" + servico.getId());
        Representation response = client.put(
                new StringRepresentation(
                        JsonUtils.converterObjectEmJson(servico, Servico.class)
                )
        );
        try {
            return JsonUtils.converterJsonEmObjeto(response.getText(), Servico.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
