package br.com.lab.controller;

import br.com.lab.model.input.GrupoInput;
import br.com.lab.service.GrupoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.http.HttpStatus.*;

@ExtendWith(SpringExtension.class)
class GrupoControllerTest {

    @InjectMocks
    private GrupoController grupoController;

    @Mock
    private GrupoService grupoServiceMock;

    @BeforeEach
    void setUp(){
        when(grupoServiceMock.salvar(ArgumentMatchers.any(GrupoInput.class))).thenReturn(GrupoControllerMockTest.grupoModel());
        when(grupoServiceMock.recuperaTodosGrupos()).thenReturn(GrupoControllerMockTest.recuperaTodosGrupos());
        when(grupoServiceMock.recuperaUmGrupo(ArgumentMatchers.anyLong())).thenReturn(GrupoControllerMockTest.grupoModel());
        when(grupoServiceMock.atualizar(ArgumentMatchers.anyLong(), ArgumentMatchers.any(GrupoInput.class))).thenReturn(GrupoControllerMockTest.grupoModelAtualizado());
        doNothing().when(grupoServiceMock).remove(ArgumentMatchers.anyLong());
    }

    @Test
    @DisplayName(value = "Salva um grupo.")
    void salvar(){
        var responseEntity = grupoController.salvar(GrupoControllerMockTest.novoGrupoInput());
        var grupoModel = responseEntity.getBody();
        assertThat(grupoModel).isNotNull();
        assertThat(grupoModel.getId()).isNotNull();
        assertThat(grupoModel.getNome()).isEqualTo(GrupoControllerMockTest.grupoModel().getNome());
        assertThat(grupoModel.getDescricao()).isEqualTo(GrupoControllerMockTest.grupoModel().getDescricao());
        assertThat(responseEntity.getStatusCode()).isEqualTo(CREATED);
    }

    @Test
    @DisplayName(value = "Lista todos grupos.")
    void listar() {
        var responseEntity = grupoController.listar();
        var grupos = responseEntity.getBody();
        assertThat(grupos).isNotNull().isNotEmpty().hasSize(10);
        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
    }

    @Test
    @DisplayName(value = "Busca um grupo.")
    void buscar(){
        var responseEntity = grupoController.buscar(1L);
        var grupoModel = responseEntity.getBody();
        assertThat(grupoModel).isNotNull();
        assertThat(grupoModel.getId()).isEqualTo(GrupoControllerMockTest.grupoModel().getId());
        assertThat(grupoModel.getNome()).isEqualTo(GrupoControllerMockTest.grupoModel().getNome());
        assertThat(grupoModel.getDescricao()).isEqualTo(GrupoControllerMockTest.grupoModel().getDescricao());
        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
    }

    @Test
    @DisplayName(value = "Atualiza um grupo.")
    void atualizar(){
        var responseEntity = grupoController.atualizar(1L, GrupoControllerMockTest.atualiazarGrupoInput());
        var grupoModel = responseEntity.getBody();
        assertThat(grupoModel).isNotNull();
        assertThat(grupoModel.getId()).isEqualTo(GrupoControllerMockTest.grupoModelAtualizado().getId());
        assertThat(grupoModel.getNome()).isEqualTo(GrupoControllerMockTest.grupoModelAtualizado().getNome());
        assertThat(grupoModel.getNome()).isEqualTo(GrupoControllerMockTest.grupoModelAtualizado().getNome());
        assertThat(grupoModel.getDescricao()).isEqualTo(GrupoControllerMockTest.grupoModelAtualizado().getDescricao());
        assertThat(responseEntity.getStatusCode()).isEqualTo(CREATED);
    }

    @Test
    @DisplayName(value = "Remove um grupo.")
    void remover(){
        var responseEntity = grupoController.remover(1L);
        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(NO_CONTENT);
    }
}