package br.edu.ifpb.pos.service.autos.status.dto;

import java.util.List;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class OrdemServico {

    private long numero;
    private String status;
    private List<Servico> servicos;

    public OrdemServico(long numero, String status, List<Servico> servicos) {
        this.numero = numero;
        this.status = status;
        this.servicos = servicos;
    }

    public OrdemServico() {
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
    
}
