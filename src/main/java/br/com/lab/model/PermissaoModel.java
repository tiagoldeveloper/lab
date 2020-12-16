package br.com.lab.model;

public class PermissaoModel {

    private Long id;
    private String url;
    private String nome;

    public PermissaoModel() {
    }

    public PermissaoModel(Long id, String url, String nome) {
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
