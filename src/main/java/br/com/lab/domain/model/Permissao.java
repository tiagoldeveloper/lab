package br.com.lab.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_PERMISSAO")
@SequenceGenerator(name = "PERMISSAO_SEQ", sequenceName = "PER_SEQ", allocationSize = 2)
public class Permissao extends LabBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissao_seq")
    @Column(name = "PER_ID")
    private Long id;

    @Column(name = "PER_URL", length = 100)
    private String url;

    @Column(name = "PER_NOME", length = 100)
    private String nome;

    @OneToMany(targetEntity = MenuItem.class, fetch = FetchType.LAZY, mappedBy = "permissao")
    private List<MenuItem> menuItems;

    public Permissao(){}

    public Permissao(Long id, String url, String nome) {
        super();
        this.id = id;
        this.url = url;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}