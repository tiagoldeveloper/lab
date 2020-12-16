package br.com.lab.service;

import br.com.lab.dto.GrupoModelDTO;
import br.com.lab.model.input.GrupoInput;
import br.com.lab.repository.GrupoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class GrupoServiceTest {

    @InjectMocks
    private GrupoService grupoService;

    @Mock
    private GrupoRepository grupoRepository;

    @Mock
    private GrupoModelDTO grupoModelDTO;

    @BeforeEach
    void setUp(){
        when(grupoService.salvar(any(GrupoInput.class))).thenReturn(GrupoServiceMockTest.grupoModel());
        when(grupoService.recuperaUmGrupo(GrupoServiceMockTest.grupoModel().getId())).thenReturn(GrupoServiceMockTest.grupoModel());
        when(grupoModelDTO.toModelCollection(grupoRepository.recupera(any()))).thenReturn(GrupoServiceMockTest.gruposModel());
    }

    @Test
    @DisplayName(value = "Salva e retorna um GrupoModel.")
    void salvar(){
        var grupoModel = grupoService.salvar(GrupoServiceMockTest.novoGrupo());
        assertThat(grupoModel).isNotNull();
        assertThat(grupoModel.getId()).isNotNull();
        assertThat(grupoModel.getNome()).isNotBlank().isEqualTo(GrupoServiceMockTest.grupoModel().getNome());
        assertThat(grupoModel.getDescricao()).isNotBlank().isEqualTo(GrupoServiceMockTest.grupoModel().getDescricao());
    }

    @Test
    @DisplayName(value = "Recupera um GrupoModel pelo id.")
    void recuperaUmGrupo(){
        var grupoModel = grupoService.recuperaUmGrupo(GrupoServiceMockTest.grupoModel().getId());
        assertThat(grupoModel).isNotNull();
        assertThat(grupoModel.getId()).isNotNull().isEqualTo(GrupoServiceMockTest.grupoModel().getId());
        assertThat(grupoModel.getNome()).isNotBlank().isEqualTo(GrupoServiceMockTest.grupoModel().getNome());
        assertThat(grupoModel.getDescricao()).isNotBlank().isEqualTo(GrupoServiceMockTest.grupoModel().getDescricao());
    }

    @Test
    @DisplayName(value = "Recupera todos grupos GrupoModel.")
    void recuperaTodosGrupos() {
        var grupoModels = grupoService.recuperaTodosGrupos();
        assertThat(grupoModels).isNotNull().isNotEmpty().hasSize(10);
    }

}