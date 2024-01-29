package br.com.neuroconexao.neuroconexaobackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "profissional")
public class Profissional {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "areaAtuacao")
    private String areaAtuacao;

    @Column(name = "nome")
    private String nome;
    @Column(unique = true)
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 caracteres")
    private String cpf;

    @Column(unique = true)
    @NotBlank(message = "O campo CRP nao pode estar em branco")
    private String crp;

    @Column(name = "email")
    @Pattern(regexp = ".+@.+\\..+", message = "O email deve conter o símbolo @")
    private String email;
    @Column(name = "senha")
    @Size(min = 6, max = 6, message = "A senha deve ter 6 caracteres")
    private String senha;

    @Column(name= "confirmarSenha")
    @Size(min = 6, max = 6, message = "A senha deve ter 6 caracteres")
    private String confirmarSenha;


    public Profissional() {}
    public Profissional(Long id, String areaAtuacao, String crp, String nome, String cpf, String email, String senha, String confirmarSenha) {
        this.id = id;
        this.areaAtuacao= areaAtuacao;
        this.crp = crp;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    public String getArea_de_atuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
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

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
}

