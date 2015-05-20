package br.edu.ifpb.praticas.aula.pratica.teste.entidades;

import br.edu.ifpb.praticas.aula.pratica.teste.conversor.LocalDateConverter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
@Entity
@SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "PESSOA_SEQ")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    private long id;
    @Basic(optional = false)
    private String cpf;
    private String nome;
    private String version;

    public enum typeSexo {

        MASCULINO, FEMININO;
    }

    @Enumerated(EnumType.STRING)
    private typeSexo sexo;

    @ElementCollection
    private Collection<String> emails;

    @Embedded
    private Endereco endereco;

    @OneToMany
    private Collection<Convidado> convidados;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate aniversario;

    public Pessoa(String cpf, String nome, String version, typeSexo sexo, Endereco endereco, LocalDate aniversario) {
        this.cpf = cpf;
        this.nome = nome;
        this.version = version;
        this.sexo = sexo;
        this.endereco = endereco;
        this.aniversario = aniversario;
        this.emails = new ArrayList<>();
        this.convidados = new ArrayList<>();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public typeSexo getSexo() {
        return sexo;
    }

    public void setSexo(typeSexo sexo) {
        this.sexo = sexo;
    }

    public void addEmail(String email) {
        this.emails.add(email);
    }

    public void addConvidado(Convidado invited) {
        this.convidados.add(invited);
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
