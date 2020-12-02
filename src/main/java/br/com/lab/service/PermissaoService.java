package br.com.lab.service;

import br.com.lab.domain.model.Permissao;
import br.com.lab.dto.PermissaoModelDTO;
import br.com.lab.model.PermissaoModel;
import br.com.lab.model.input.PermissaoInput;
import br.com.lab.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoModelDTO permissaoModelDTO;

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Transactional
    public PermissaoModel salvar(PermissaoInput permissaoInput) {
        Permissao novaPermissao = permissaoModelDTO.toPermissaoObject(permissaoInput);
        Permissao permissao = permissaoRepository.salvar(novaPermissao);
        return permissaoModelDTO.toModelObject(permissao);
    }

    @Transactional
    public PermissaoModel atualizar(Long permissaoId, PermissaoInput permissaoInput) {
        Permissao permissao = permissaoRepository.recupera(Permissao.class, permissaoId);
        permissaoModelDTO.copyToDomainObject(permissaoInput, permissao);
        permissao = permissaoRepository.salvar(permissao);
        return permissaoModelDTO.toModelObject(permissao);
    }

    public List<PermissaoModel> recuperaTodasPermissoes(Pageable pageable) {
        List<Permissao> permissoes = permissaoRepository.recupera(Permissao.class, pageable);
        return permissaoModelDTO.toModelCollection(permissoes);
    }

    public PermissaoModel recuperaUmaPermissao(Long permissaoId) {
        Permissao permissao = permissaoRepository.recupera(Permissao.class, permissaoId);
        return permissaoModelDTO.toModelObject(permissao);
    }

    @Transactional
    public void remove(Long permissaoId) {
        Permissao permissao = permissaoRepository.recupera(Permissao.class, permissaoId);
        permissaoRepository.remove(permissao);
    }

}
