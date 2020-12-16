package br.com.lab.model.input;

public class GrupoPermissaoInput {

    private Long permissaoId;
    private boolean permissaoSelecionada;

    public Long getPermissaoId() {
        return permissaoId;
    }

    public void setPermissaoId(Long permissaoId) {
        this.permissaoId = permissaoId;
    }

    public boolean isPermissaoSelecionada() {
        return permissaoSelecionada;
    }

    public void setPermissaoSelecionada(boolean permissaoSelecionada) {
        this.permissaoSelecionada = permissaoSelecionada;
    }
}