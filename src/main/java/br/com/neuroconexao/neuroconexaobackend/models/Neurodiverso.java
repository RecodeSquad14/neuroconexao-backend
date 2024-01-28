package br.com.neuroconexao.neuroconexaobackend.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Neurodiverso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String neurodiversodivergencia;

    @NotNull
    private String nome;

    @CPF
    private String cpf;
    @Email
    private String email;

    @Min(6)
    private String senha;

    @NotNull
    private String telefone;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate datanascimento;

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

    public LocalDate getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(LocalDate datanascimento) {
        this.datanascimento = datanascimento;
    }

}
