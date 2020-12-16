package br.com.lab.controller;

import br.com.lab.model.GrupoModel;
import br.com.lab.model.input.GrupoInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrupoControllerMockTest {

    public static GrupoInput novoGrupoInput() {
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

    public static List<GrupoModel> recuperaTodosGrupos() {
        var grupoModels = new ArrayList<GrupoModel>();
        GrupoModel grupoModel;
        for (int i = 0; i < 10; i++) {
            grupoModel = new GrupoModel();
            grupoModel.setId(new Random().nextLong());
            grupoModel.setNome("Teste  xxxxxx");
            grupoModel.setDescricao("Teste  xxxxxx");
            grupoModels.add(grupoModel);
        }
        return grupoModels;
    }
}