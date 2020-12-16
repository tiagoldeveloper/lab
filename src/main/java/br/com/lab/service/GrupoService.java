package br.com.lab.service;

import br.com.lab.domain.model.Grupo;
import br.com.lab.dto.GrupoModelDTO;
import br.com.lab.model.GrupoModel;
import br.com.lab.model.input.GrupoInput;
import br.com.lab.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class GrupoService {

    private final GrupoModelDTO grupoModelDTO;
    private final GrupoRepository grupoRepository;

    @Autowired
    public GrupoService(GrupoModelDTO grupoModelDTO, GrupoRepository grupoRepository) {
        this.grupoModelDTO = grupoModelDTO;
        this.grupoRepository = grupoRepository;
    }

    public List<GrupoModel> recuperaTodosGrupos() {
        List<Grupo> grupos = grupoRepository.recupera(Grupo.class);
        return grupoModelDTO.toModelCollection(grupos);
    }

    public GrupoModel recuperaUmGrupo(Long grupoId) {
        Grupo grupo = grupoRepository.recupera(Grupo.class, grupoId);
        return grupoModelDTO.toModelObject(grupo);
    }

    @Transactional
    public GrupoModel salvar(GrupoInput grupoInput) {
        var novoGrupo = grupoModelDTO.toGrupoObject(grupoInput);
        var grupo = grupoRepository.salvar(novoGrupo);
        return grupoModelDTO.toModelObject(grupo);
    }

    @Transactional
    public GrupoModel atualizar(Long grupoId, GrupoInput grupoInput) {
        var grupoAtual = grupoRepository.recupera(Grupo.class, grupoId);
        grupoModelDTO.toGrupoDomainObject(grupoInput, grupoAtual);
        grupoAtual = grupoRepository.salvar(grupoAtual);
        return grupoModelDTO.toModelObject(grupoAtual);
    }

    @Transactional
    public void remove(Long grupoId) {
        Grupo grupo = grupoRepository.recupera(Grupo.class, grupoId);
        grupoRepository.remove(grupo);
    }

}
