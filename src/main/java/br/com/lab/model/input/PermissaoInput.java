package br.com.lab.model.input;

import javax.validation.constraints.NotBlank;

public class PermissaoInput {

    @NotBlank
    private String url;

    @NotBlank
    private String nome;

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
