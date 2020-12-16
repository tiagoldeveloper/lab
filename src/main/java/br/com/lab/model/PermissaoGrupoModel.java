package br.com.lab.model;

public class PermissaoGrupoModel {

    private Long id;
    private String url;
    private String nome;
    private boolean isPermissaoGrupo = false;

    public PermissaoGrupoModel() {}


    public PermissaoGrupoModel(Long id, String url, String nome) {
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

    public boolean isPermissaoGrupo() {
        return isPermissaoGrupo;
    }

    public void setPermissaoGrupo(boolean permissaoGrupo) {
        isPermissaoGrupo = permissaoGrupo;
    }
}
