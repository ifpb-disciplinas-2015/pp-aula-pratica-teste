package br.edu.ifpb.praticas.aula.pratica.teste.entidades;

import com.oracle.webservices.internal.api.EnvelopeStyle;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import br.edu.ifpb.praticas.aula.pratica.teste.conversor.LocalDateConverter;
import br.edu.ifpb.praticas.aula.pratica.teste.conversor.LocalDateTimeConverter;
import java.time.LocalDateTime;
import javax.persistence.Convert;

/**
 *
 * @author DouglasGabriel
 */

@Entity
public class Compromisso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;    
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime data;
    private String descricao;
    @ManyToMany
    private List<Pessoa> pessoas;

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    public void addPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }
    
    public void removePessoa (Pessoa pessoa){
        pessoas.remove(pessoa);
    }

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
