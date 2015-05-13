package br.edu.ifpb.praticas.aula.pratica.teste.entidades;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
@Entity
public class Pessoa {    
    @Id
    private String cpf;
    private String nome;
    private Endereco endereco;
    private LocalDate aniversario;

    public Pessoa(String cpf, String nome, Endereco endereco, LocalDate aniversario) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.aniversario = aniversario;
    }

    public Pessoa() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }
    
    
    
    
}
