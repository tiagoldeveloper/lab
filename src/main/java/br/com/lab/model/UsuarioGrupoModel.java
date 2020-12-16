package br.com.lab.model;

public class UsuarioGrupoModel {

    private Long id;
    private String nome;
    private boolean isGrupoSelecionado = false;

    public UsuarioGrupoModel() {
    }

    public UsuarioGrupoModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public boolean isGrupoSelecionado() {
        return isGrupoSelecionado;
    }

    public void setGrupoSelecionado(boolean grupoSelecionado) {
        isGrupoSelecionado = grupoSelecionado;
    }
}