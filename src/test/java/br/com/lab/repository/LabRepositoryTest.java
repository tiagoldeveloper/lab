package br.com.lab.repository;

import br.com.lab.domain.model.Grupo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@DisplayName(value = "Classe generica, ou seja remove, salva, atualiza, lista qualquer entidade mapeada.")
class LabRepositoryTest {

    @Autowired
    private LabRepository labRepository;

    @Test
    @DisplayName(value = "Salva uma entidade.")
    @Transactional
    void salvar() {
        var grupo = new Grupo();
        grupo.setNome("Grupo teste");
        grupo.setDescricao("Grupo teste");
        var grupoSalvo = labRepository.salvar(grupo);
        assertThat(grupoSalvo).isNotNull();
        assertThat(grupoSalvo.getNome()).isNotNull().isNotEmpty();
        assertThat(grupoSalvo.getDescricao()).isNotNull().isNotEmpty();
    }

    @Test
    @DisplayName(value = "Remove uma entidade.")
    @Transactional
    void remove() {
        var grupos = labRepository.recupera(Grupo.class);
        labRepository.remove(grupos.get(0));
    }

    @Test
    @DisplayName(value = "Recupera uma um entidade, uma lista entidade, entidade por ids.")
    void recupera() {
        var grupos = labRepository.recupera(Grupo.class);
        var umGrupo = labRepository.recupera(Grupo.class, grupos.get(0).getId());
        var gruposIds = grupos.stream().map(Grupo::getId).collect(Collectors.toList());
        var gruposPorIds = labRepository.recupera(Grupo.class, gruposIds);
        assertThat(grupos).isNotNull().isNotEmpty();
        assertThat(umGrupo).isNotNull();
        assertThat(gruposPorIds).isNotNull().isNotEmpty();
    }

    @Test
    @DisplayName(value = "Recupera entidade que não contem ids igual informados.")
    void recuperaNotIn() {
        var grupos = labRepository.recupera(Grupo.class);
        var grupo1 = grupos.get(0);
        var grupo2 = grupos.get(1);
        var gruposPorIds = labRepository.recuperaNotIn(Grupo.class, Arrays.asList(grupo1.getId(), grupo2.getId()));
        var gruposNulo = gruposPorIds.stream()
                .filter((Grupo grupo) -> (grupo.getId().equals(grupo1.getId()) || grupo.getId().equals(grupo2.getId())))
                .collect(Collectors.toList());
        assertThat(gruposNulo).isEmpty();
    }

    @Test
    @DisplayName(value = "Recupera uma um entidade, uma lista entidade, entidade por ids.")
    void testRecupera1() {
        var grupos = labRepository.recupera(Grupo.class);
        var umGrupo = labRepository.recupera(Grupo.class, grupos.get(0).getId());
        var gruposIds = grupos.stream().map(Grupo::getId).collect(Collectors.toList());
        var gruposPorIds = labRepository.recupera(Grupo.class, gruposIds);
        assertThat(grupos).isNotNull().isNotEmpty();
        assertThat(umGrupo).isNotNull();
        assertThat(gruposPorIds).isNotNull().isNotEmpty();
    }

    @Test
    @DisplayName(value = "Recupera uma um entidade, uma lista entidade, entidade por ids.")
    void testRecupera2() {
        var grupos = labRepository.recupera(Grupo.class);
        var umGrupo = labRepository.recupera(Grupo.class, grupos.get(0).getId());
        var gruposIds = grupos.stream().map(Grupo::getId).collect(Collectors.toList());
        var gruposPorIds = labRepository.recupera(Grupo.class, gruposIds);
        assertThat(grupos).isNotNull().isNotEmpty();
        assertThat(umGrupo).isNotNull();
        assertThat(gruposPorIds).isNotNull().isNotEmpty();
    }

    @Test
    @DisplayName(value = "Recupera uma um entidade, uma lista entidade, entidade por ids.")
    void getManager() {
        var grupos = labRepository.recupera(Grupo.class);
        var umGrupo = labRepository.recupera(Grupo.class, grupos.get(0).getId());
        var gruposIds = grupos.stream().map(Grupo::getId).collect(Collectors.toList());
        var gruposPorIds = labRepository.recupera(Grupo.class, gruposIds);
        assertThat(grupos).isNotNull().isNotEmpty();
        assertThat(umGrupo).isNotNull();
        assertThat(gruposPorIds).isNotNull().isNotEmpty();
    }
}