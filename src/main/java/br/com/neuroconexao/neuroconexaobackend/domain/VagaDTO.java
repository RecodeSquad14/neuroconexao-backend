package br.com.neuroconexao.neuroconexaobackend.domain;

import br.com.neuroconexao.neuroconexaobackend.models.Empresa;
import jakarta.persistence.*;

public class VagaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String tituloVaga;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    public VagaDTO() {}

    public VagaDTO(String tituloVaga, String descricao, Empresa empresa) {
        this.tituloVaga = tituloVaga;
        this.descricao = descricao;
        this.empresa = empresa;
    }
}
