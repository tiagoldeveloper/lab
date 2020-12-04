package br.com.lab.model.input;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class GrupoInput {


    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    private List<Long> permissoes;


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

    public List<Long> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Long> permissoes) {
        this.permissoes = permissoes;
    }
}
