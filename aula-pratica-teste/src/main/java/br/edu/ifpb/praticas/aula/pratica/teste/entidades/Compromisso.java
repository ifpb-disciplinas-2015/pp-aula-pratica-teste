package br.edu.ifpb.praticas.aula.pratica.teste.entidades;

import java.time.LocalDateTime;

/**
 *
 * @author DouglasGabriel
 */

public class Compromisso {

    private long id;
    private LocalDateTime data;
    private String descricao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
