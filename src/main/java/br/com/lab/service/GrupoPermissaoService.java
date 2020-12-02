package br.com.lab.service;

import br.com.lab.domain.model.Grupo;
import br.com.lab.domain.model.Permissao;
import br.com.lab.dto.PermissaoModelDTO;
import br.com.lab.model.PermissaoModel;
import br.com.lab.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GrupoPermissaoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private PermissaoModelDTO permissaoModelDTO;

    public List<PermissaoModel> recuperaPermissoesPorGrupo(Long grupoId) {
        Grupo grupo = grupoRepository.recupera(Grupo.class, grupoId);
        return permissaoModelDTO.toModelCollection(grupo.getPermissoes());
    }

    @Transactional
    public void associar(Long grupoId, Long permissaoId){
        Grupo grupo = grupoRepository.recupera(Grupo.class, grupoId);
        Permissao permissao = grupoRepository.recupera(Permissao.class, permissaoId);
        grupo.adicionaPermissao(permissao);
    }

    @Transactional
    public void desassociar(Long grupoId, Long permissaoId){
        Grupo grupo = grupoRepository.recupera(Grupo.class, grupoId);
        Permissao permissao = grupoRepository.recupera(Permissao.class, permissaoId);
        grupo.removePermissao(permissao);
    }


}
