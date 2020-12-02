package br.com.lab.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_GRUPO")
@SequenceGenerator(name = "grupo_seq", sequenceName = "gru_seq", initialValue = 1, allocationSize = 2)
public class Grupo extends LabBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo_seq")
    @Column(name = "GRU_ID")
    private Long id;

    @Column(name = "GRU_NOME", length = 100)
    private String nome;

    @Column(name = "GRU_DESCRICAO", length = 100)
    private String descricao;

    @ManyToMany(targetEntity = Permissao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "tb_grupo_permissao",
            joinColumns = @JoinColumn(name = "grupo_id", foreignKey = @ForeignKey(name = "FK_GRUPO_PER")),
            inverseJoinColumns =@JoinColumn(name = "permissao_id", foreignKey = @ForeignKey(name = "FK_PERMISSAO")))
    private Set<Permissao> permissoes = new HashSet<>();

    public Grupo() {}

    public Grupo(Integer ativo, Date dataUltAlteracao, Integer versao, Long id, String nome, String descricao, Set<Permissao> permissoes) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.permissoes = permissoes;
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

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }


    public void adicionaPermissao(Permissao permissao){
        getPermissoes().add(permissao);
    }

    public void removePermissao(Permissao permissao){
        getPermissoes().remove(permissao);
    }

}
