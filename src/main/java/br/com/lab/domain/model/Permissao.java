package br.com.lab.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_PERMISSAO")
@SequenceGenerator(name = "permissao_seq", sequenceName = "per_seq", initialValue = 1, allocationSize = 2)
public class Permissao extends LabBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissao_seq")
    @Column(name = "PER_ID")
    private Long id;

    @Column(name = "PER_NOME", length = 100)
    private String nome;

    @Column(name = "PER_DESCRICAO", length = 100)
    private String descricao;

    public Permissao(){}

    public Permissao(Integer ativo, Date dataUltAlteracao, Integer versao, Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
