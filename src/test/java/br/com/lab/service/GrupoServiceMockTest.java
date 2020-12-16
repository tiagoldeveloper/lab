package br.com.lab.service;

import br.com.lab.model.GrupoModel;
import br.com.lab.model.input.GrupoInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrupoServiceMockTest {

    public static GrupoInput novoGrupo() {
        var grupoInput = new GrupoInput();
        grupoInput.setNome("Transporte x");
        grupoInput.setDescricao("Transporte xx");
        return grupoInput;
    }

    public static GrupoModel grupoModel() {
        var grupoModel = new GrupoModel();
        grupoModel.setNome("Transporte x");
        grupoModel.setDescricao("Transporte xx");
        grupoModel.setId(1L);
        return grupoModel;
    }

    public static GrupoModel recuperaUmGrupo() {
        GrupoModel grupo = new GrupoModel();
        grupo.setId(1L);
        grupo.setNome("Teste  xxxxxx");
        grupo.setDescricao("Teste  xxxxxx");
        return grupo;
    }

    public static GrupoInput atualiazarGrupoInput() {
        var grupoInput = new GrupoInput();
        grupoInput.setNome("Transportessss");
        grupoInput.setDescricao("Transporte");
        return grupoInput;
    }

    public static GrupoModel grupoModelAtualizado() {
        var grupoModel = new GrupoModel();
        grupoModel.setNome("Transportessss");
        grupoModel.setDescricao("Transporte");
        grupoModel.setId(1L);
        return grupoModel;
    }

    public static List<GrupoModel> gruposModel() {
        var grupos = new ArrayList<GrupoModel>();
        GrupoModel grupo = null;
        for (int i = 0; i < 10; i++) {
            grupo = new GrupoModel();
            grupo.setId(new Random().nextLong());
            grupo.setNome("Teste  xxxxxx");
            grupo.setDescricao("Teste  xxxxxx");
            grupos.add(grupo);
        }
        return grupos;
    }
}