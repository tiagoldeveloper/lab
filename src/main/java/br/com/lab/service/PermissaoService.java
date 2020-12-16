package br.com.lab.service;

import br.com.lab.domain.model.Permissao;
import br.com.lab.dto.PermissaoModelDTO;
import br.com.lab.model.PermissaoModel;
import br.com.lab.model.input.PermissaoInput;
import br.com.lab.repository.PermissaoRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PermissaoService {

    private final PermissaoModelDTO permissaoModelDTO;
    private final PermissaoRepository permissaoRepository;

    public PermissaoService(PermissaoModelDTO permissaoModelDTO, PermissaoRepository permissaoRepository){
        this.permissaoModelDTO = permissaoModelDTO;
        this.permissaoRepository = permissaoRepository;
    }
    public List<PermissaoModel> recuperaTodasPermissoes() {
        List<Permissao> permissoes = permissaoRepository.recupera(Permissao.class);
        return permissaoModelDTO.toPermissaoModelCollection(permissoes);
    }

    public PermissaoModel recuperaUmaPermissao(Long permissaoId) {
        Permissao permissao = permissaoRepository.recupera(Permissao.class, permissaoId);
        return permissaoModelDTO.toPermissaoModel(permissao);
    }

    @Transactional
    public PermissaoModel salvar(PermissaoInput permissaoInput) {
        Permissao novaPermissao = permissaoModelDTO.toPermissaoObject(permissaoInput);
        Permissao permissao = permissaoRepository.salvar(novaPermissao);
        return permissaoModelDTO.toPermissaoModel(permissao);
    }

    @Transactional
    public PermissaoModel atualizar(Long permissaoId, PermissaoInput permissaoInput) {
        Permissao permissao = permissaoRepository.recupera(Permissao.class, permissaoId);
        permissaoModelDTO.copyToDomainObject(permissaoInput, permissao);
        permissao = permissaoRepository.salvar(permissao);
        return permissaoModelDTO.toPermissaoModel(permissao);
    }

    @Transactional
    public void remove(Long permissaoId) {
        Permissao permissao = permissaoRepository.recupera(Permissao.class, permissaoId);
        permissaoRepository.remove(permissao);
    }

}
