package br.edu.ifpb.pos.service.autos.status.ext.resources;

import br.edu.ifpb.pos.service.autos.status.dto.OrdemServico;
import br.edu.ifpb.pos.service.autos.status.dto.Servico;
import java.util.List;

/**
 *
 * @author douglasgabriel
 */
public interface ClienteResources {
    
    public List<OrdemServico> listarTodasOs ();
    
    public OrdemServico atualizarOrdemServico (OrdemServico os);
    
    public Servico atualizarServico (Servico servico);
    
    public OrdemServico verOrdemServico (long numero);
}
