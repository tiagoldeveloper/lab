package br.com.lab.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "USU_SEQ", allocationSize = 2)
public class Usuario extends LabBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
    @Column(name = "USU_ID")
    private Long id;

    @Column(name = "USU_NOME", length = 100)
    private String nome;

    @Column(name = "USU_LOGIN", length = 100)
    private String login;

    @Column(name = "USU_SENHA")
    private String senha;

    @ManyToMany(targetEntity = Grupo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "TB_USUARIO_GRUPO",
            joinColumns = @JoinColumn(name = "USUARIO_ID", foreignKey = @ForeignKey(name = "FK_USUARIO")),
            inverseJoinColumns = @JoinColumn(name = "GRUPO_ID", foreignKey = @ForeignKey(name = "FK_GRUPO")))
    private Set<Grupo> grupos = new HashSet<>();

    public Usuario() {}

    public Usuario(Long id, String nome, String login, String senha, Set<Grupo> grupos) {
        super();
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.grupos = grupos;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }

    public void adicionaGrupo(Grupo grupo){
        getGrupos().add(grupo);
    }
    
    public void removeGrupo(Grupo grupo){
        getGrupos().remove(grupo);
    }
}