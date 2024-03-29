package br.com.neuroconexao.neuroconexaobackend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "vagas")
public class Vaga {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String tituloVaga;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    public Vaga() {
    }

    public Vaga(Long id, String tituloVaga, String descricao) {
        this.id = id;
        this.tituloVaga = tituloVaga;
        this.descricao = descricao;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloVaga() {
        return tituloVaga;
    }

    public void setTituloVaga(String tituloVaga) {
        this.tituloVaga = tituloVaga;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
