package br.com.lab.service;

import br.com.lab.domain.model.Grupo;
import br.com.lab.domain.model.Permissao;
import br.com.lab.dto.GrupoModelDTO;
import br.com.lab.model.GrupoModel;
import br.com.lab.model.input.GrupoInput;
import br.com.lab.repository.GrupoRepository;
import br.com.lab.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Component
public class GrupoService {

    @Autowired
    private GrupoModelDTO grupoModelDTO;

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Transactional
    public GrupoModel salvar(GrupoInput grupoInput) {

        List<Permissao> permissoesAux = grupoInput.getPermissoes() !=null ? permissaoRepository.recupera(Permissao.class, grupoInput.getPermissoes()) : null;

        Grupo novoGrupo = grupoModelDTO.toGrupoObject(grupoInput);
        if(permissoesAux !=null){
            permissoesAux.forEach(umPermissao -> {
                novoGrupo.adicionaPermissao(umPermissao);
            });
        }
        Grupo grupo = grupoRepository.salvar(novoGrupo);
        return grupoModelDTO.toModelObject(grupo);
    }

    @Transactional
    public GrupoModel atualizar(Long grupoId, GrupoInput grupoInput) {
        Grupo grupoAtual = grupoRepository.recupera(Grupo.class, grupoId);
        grupoModelDTO.toGrupoDomainObject(grupoInput, grupoAtual);
        grupoAtual =  grupoRepository.salvar(grupoAtual);
        return grupoModelDTO.toModelObject(grupoAtual);
    }

    @Transactional
    public void remove(Long grupoId){
        Grupo grupo = grupoRepository.recupera(Grupo.class, grupoId);
        try {
            grupoRepository.remove(grupo);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public GrupoModel recuperaUmGrupo(Long grupoId) {
        Grupo grupo = grupoRepository.recupera(Grupo.class, grupoId);
        return grupoModelDTO.toModelObject(grupo);
    }

    public List<GrupoModel> recuperaTodosGrupos(Pageable pageable) {
        List<Grupo> grupos = grupoRepository.recupera(Grupo.class, pageable);
        return grupoModelDTO.toModelCollection(grupos);
    }


}
