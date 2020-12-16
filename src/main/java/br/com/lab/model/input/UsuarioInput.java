package br.com.lab.model.input;

import javax.validation.constraints.NotBlank;

public class UsuarioInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String login;

    private String senha;

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
}