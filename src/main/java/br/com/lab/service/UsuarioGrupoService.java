package br.com.lab.service;

import br.com.lab.domain.model.Grupo;
import br.com.lab.domain.model.Usuario;
import br.com.lab.dto.GrupoModelDTO;
import br.com.lab.model.GrupoModel;
import br.com.lab.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioGrupoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GrupoModelDTO grupoModelDTO;

    public List<GrupoModel> recuperaGruposPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.recupera(Usuario.class, usuarioId);
        return grupoModelDTO.toModelCollection(usuario.getGrupos());
    }

    @Transactional
    public void associar(Long usuarioId, Long grupoId){
        Usuario usuario = usuarioRepository.recupera(Usuario.class, usuarioId);
        Grupo grupo = usuarioRepository.recupera(Grupo.class, grupoId);
        usuario.adicionaGrupo(grupo);
    }

    @Transactional
    public void desassociar(Long usuarioId, Long grupoId){
        Usuario usuario = usuarioRepository.recupera(Usuario.class, usuarioId);
        Grupo grupo = usuarioRepository.recupera(Grupo.class, grupoId);
        usuario.removeGrupo(grupo);
    }

}








