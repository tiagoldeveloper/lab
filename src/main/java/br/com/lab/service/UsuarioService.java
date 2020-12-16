package br.com.lab.service;

import br.com.lab.domain.model.Usuario;
import br.com.lab.dto.UsuarioModelDTO;
import br.com.lab.model.*;
import br.com.lab.model.input.UsuarioInput;
import br.com.lab.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioModelDTO usuarioModelDTO;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioModelDTO usuarioModelDTO){
        this.usuarioRepository = usuarioRepository;
        this.usuarioModelDTO = usuarioModelDTO;
    }

    @Transactional
    public UsuarioModel salvar(UsuarioInput usuarioInput) {
        var novoUsuario = usuarioModelDTO.toUsuarioObject(usuarioInput);
        var usuarioSaved = usuarioRepository.salvar(novoUsuario);
        return usuarioModelDTO.toUsuarioModel(usuarioSaved);
    }

    @Transactional
    public UsuarioModel atualizar(Long usuarioId, UsuarioInput usuarioInput) {
        var usuarioAtual = usuarioRepository.recupera(Usuario.class, usuarioId);
        usuarioModelDTO.copyToUsuarioDomainObject(usuarioInput, usuarioAtual);
        usuarioAtual = usuarioRepository.salvar(usuarioAtual);
        return usuarioModelDTO.toUsuarioModel(usuarioAtual);
    }

    @Transactional
    public void remove(Long usuarioId) {
        var usuario = usuarioRepository.recupera(Usuario.class, usuarioId);
        usuarioRepository.remove(usuario);
    }

    public UsuarioModel recuperaUmUsuario(Long usuarioId) {
        var usuario = usuarioRepository.recupera(Usuario.class, usuarioId);
        return usuarioModelDTO.toUsuarioModel(usuario);
    }

    public List<UsuarioModel> recuperaTodosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.recupera(Usuario.class);
        return usuarioModelDTO.toCollectionModel(usuarios);
    }
}