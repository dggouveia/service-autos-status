package br.edu.ifpb.pos.service.autos.status.ext.resources;

import br.edu.ifpb.pos.service.autos.status.dto.OrdemServico;
import br.edu.ifpb.pos.service.autos.status.dto.Servico;
import br.edu.ifpb.pos.service.autos.status.dto.StatusOrdemServico;
import com.google.common.collect.Lists;
import java.util.List;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class ClienteResourcesMockup implements ClienteResources {

    private List<OrdemServico> ordens;

    public ClienteResourcesMockup() {
        fillList();
    }
    
    @Override
    public List<OrdemServico> listarTodasOs() {
        return ordens;
    }
    
    @Override
    public OrdemServico atualizarOrdemServico (OrdemServico newer){
        for (OrdemServico older : ordens){
            if (older.getNumero() == newer.getNumero()){
                older.setStatus(newer.getStatus());
                return older;
            }
        }
        return null;
    }
    
    @Override
    public OrdemServico verOrdemServico(long numero) {
        for (OrdemServico os : ordens){
            if (os.getNumero() == numero)
                return os;
        }
        return null;
    }
    
    @Override
    public Servico atualizarServico(Servico newer) {
        for (OrdemServico os : ordens){
            if (os.getServicos() != null)
                for (Servico older : os.getServicos()){
                    if (older.getId() == newer.getId()){
                        older.setStatus(newer.getStatus());
                        return older;
                    }
                }
        }
        return null;
    }
    
    private void fillList (){
        OrdemServico os1 = new OrdemServico(
                1, StatusOrdemServico.ESPERA.name(), null
        );
        OrdemServico os2 = new OrdemServico(
                2, StatusOrdemServico.EM_ANDAMENTO.name(), null
        );
        
        Servico servico1 = new Servico(1, StatusOrdemServico.ESPERA.name());
        Servico servico2 = new Servico(2, StatusOrdemServico.CONCLUIDO.name());
        Servico servico3 = new Servico(3, StatusOrdemServico.ESPERA.name());
        
        OrdemServico os3 = new OrdemServico(
                3, StatusOrdemServico.FATURAMENTO.name()
                ,Lists.newArrayList(servico1, servico2, servico3)
        );
        OrdemServico os4 = new OrdemServico(
                4, StatusOrdemServico.ESPERA.name(), null
        );
        OrdemServico os5 = new OrdemServico(
                5, StatusOrdemServico.LIBERADO.name(), null
        );
        ordens = Lists.newArrayList(os1, os2, os3, os4, os5);
    }    

}
