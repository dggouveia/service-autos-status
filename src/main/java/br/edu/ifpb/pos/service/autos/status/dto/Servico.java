package br.edu.ifpb.pos.service.autos.status.dto;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class Servico {

    private long id;
    private String status;

    public Servico(long id, String status) {
        this.id = id;
        this.status = status;
    }

    public Servico() {
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
