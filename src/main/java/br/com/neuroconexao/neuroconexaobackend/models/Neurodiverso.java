package br.com.neuroconexao.neuroconexaobackend.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Neurodiverso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String neurodiversodivergencia;

    @Column(name = "neurodiverso_name", length = 50, nullable = false)
    private String nome;

    private String cpf;
    private String email;
    private String senha;
    private String telefone;
    private String datanascimento;
   

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "neurodiverso_neurodiverso",
            joinColumns = @JoinColumn(name = "neurodiverso_id"),
            inverseJoinColumns = @JoinColumn(name = "neurodiverso_rel_id"))
    private Set<Neurodiverso> neurodiversos = new HashSet<>();

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNeurodiversodivergencia() {
        return neurodiversodivergencia;
    }

    public void setNeurodiversodivergencia(String neurodiversodivergencia) {
        this.neurodiversodivergencia = neurodiversodivergencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

   

    @JsonIgnore
    public Set<Neurodiverso> getNeurodiversos() {
        return neurodiversos;
    }

    public void setNeurodiversos(Set<Neurodiverso> neurodiversos) {
        this.neurodiversos = neurodiversos;
    }

	public Object getTreinamentofamiliar() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
