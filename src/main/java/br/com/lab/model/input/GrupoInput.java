package br.com.lab.model.input;

import javax.validation.constraints.NotBlank;

public class GrupoInput {


    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

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
