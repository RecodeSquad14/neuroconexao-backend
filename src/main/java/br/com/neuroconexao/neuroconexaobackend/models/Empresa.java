package br.com.neuroconexao.neuroconexaobackend.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;



@Entity
public class Empresa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id_empresa;
	
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
	
	
	
	public Empresa() {
		
	}
	
	public Empresa(Long id, String nome, String cnpj, String endereco,String email_corporatico, String senha) {
		this.setNome(nome);
		this.setCnpj(cnpj);
		this.setEndereco(endereco);
		this.setEmail_corporativo(email_corporatico);
		this.setSenha(senha);
	}
	
	
	public Long getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
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
