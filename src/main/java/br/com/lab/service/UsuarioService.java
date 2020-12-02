package br.com.lab.service;

import br.com.lab.domain.model.Usuario;
import br.com.lab.dto.UsuarioModelDTO;
import br.com.lab.model.UsuarioModel;
import br.com.lab.model.input.UsuarioInput;
import br.com.lab.repository.UsuarioRepository;
import br.com.lab.util.UsuarioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioModelDTO usuarioModelDTO;

    @Autowired
    private UsuarioUtil usuarioUtil;

    @Transactional
    public UsuarioModel salvar(UsuarioInput usuarioInput) {
        Usuario novoUsuario = usuarioModelDTO.toUsuarioObject(usuarioInput);
        Usuario usuarioSaved = usuarioRepository.salvar(novoUsuario);
        return usuarioModelDTO.toUsuarioModel(usuarioSaved);
    }

    @Transactional
    public UsuarioModel atualizar(Long usuarioId, UsuarioInput usuarioInput) {
        Usuario usuarioAtual = usuarioRepository.recupera(Usuario.class, usuarioId);
        usuarioModelDTO.copyToUsuarioDomainObject(usuarioInput, usuarioAtual);
        usuarioAtual = usuarioRepository.salvar(usuarioAtual);
        return usuarioModelDTO.toUsuarioModel(usuarioAtual);
    }

    @Transactional
    public void remove(Long usuarioId) {
        Usuario usuario = usuarioRepository.recupera(Usuario.class, usuarioId);
        usuarioRepository.remove(usuario);
    }


    public UsuarioModel logar(String usuarioLogin) {
        Usuario usuario = usuarioRepository.logar(usuarioLogin);
        return usuarioModelDTO.toUsuarioModel(usuario);
    }

    public UsuarioModel recuperaUmUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.recupera(Usuario.class, usuarioId);
        return usuarioModelDTO.toUsuarioModel(usuario);
    }

    public List<UsuarioModel> recuperaTodosUsuarios(Pageable pageable) {
        List<Usuario> usuarios = usuarioRepository.recupera(Usuario.class, pageable);
        return usuarioModelDTO.toCollectionModel(usuarios);
    }


    //TODO: falta fazer
    public void recuperaSenha(Long usuarioId) {
        Usuario usuario = usuarioRepository.recupera(Usuario.class, usuarioId);
        String novaSenha = usuarioUtil.geraNovaSenha(usuario);
        usuario.setSenha(novaSenha);
        usuarioRepository.salvar(usuario);
    }

    //TODO: falta fazer
    public void alteraSenha(Long usuarioId, String senhaNova, String senhaAtual) {
        Usuario usuario = usuarioRepository.recupera(Usuario.class, usuarioId);
        usuarioRepository.salvar(usuario);
    }

}








