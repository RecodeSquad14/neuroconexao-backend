package br.com.neuroconexao.neuroconexaobackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Entity
public class Empresa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;
	
	@Column(name ="nome")
	private String nome;
	
	
	@Column(name ="cnpj", unique = true)
	@Size(min = 14, max = 14, message = "O CNPJ deve ter 14 caracteres")
	private String cnpj;
	
	@Column(name ="endereco")
	private String endereco;
	
	@Column(name ="emailCorporativo")
	@Pattern(regexp = ".+@.+\\..+", message = "O email deve conter o símbolo @")
	private String email_corporativo;
	
	@Column(name ="")
	private String senha;

	@OneToMany(mappedBy = "empresa")
	private Set<Vaga> vagas;

	public Empresa() {

	}

	public Empresa(Long id, String nome, String cnpj, String endereco, String email_corporativo, String senha) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.email_corporativo = email_corporativo;
		this.senha = senha;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail_corporativo() {
		return email_corporativo;
	}

	public void setEmail_corporativo(String email_corporativo) {
		this.email_corporativo = email_corporativo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
