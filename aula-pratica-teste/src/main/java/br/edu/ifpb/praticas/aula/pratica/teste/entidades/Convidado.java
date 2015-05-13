package br.edu.ifpb.praticas.aula.pratica.teste.entidades;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
@Entity
public class Convidado {
    
    private String nome;
    private String presente;
    @EmbeddedId
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPresente() {
        return presente;
    }

    public void setPresente(String presente) {
        this.presente = presente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
