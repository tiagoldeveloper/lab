package br.com.lab.model.input;

public class UsuarioGrupoInput {

    private Long grupoId;
    private boolean grupoSelecionado;

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    public boolean isGrupoSelecionado() {
        return grupoSelecionado;
    }

    public void setGrupoSelecionado(boolean grupoSelecionado) {
        this.grupoSelecionado = grupoSelecionado;
    }
}