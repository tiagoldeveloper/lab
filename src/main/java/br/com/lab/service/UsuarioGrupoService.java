package br.com.lab.service;

import br.com.lab.domain.model.Grupo;
import br.com.lab.domain.model.Usuario;
import br.com.lab.dto.UsuarioGrupoModelDTO;
import br.com.lab.model.*;
import br.com.lab.model.input.UsuarioGrupoInput;
import br.com.lab.repository.UsuarioGrupoRepository;
import br.com.lab.util.LabUtil;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioGrupoService {

    private final UsuarioGrupoModelDTO usuarioGrupoModelDTO;
    private final UsuarioGrupoRepository usuarioGrupoRepository;

    public UsuarioGrupoService(UsuarioGrupoModelDTO usuarioGrupoModelDTO, UsuarioGrupoRepository usuarioGrupoRepository) {
        this.usuarioGrupoModelDTO = usuarioGrupoModelDTO;
        this.usuarioGrupoRepository = usuarioGrupoRepository;
    }

    private static void setGrupoSelecionado(UsuarioGrupoModel usuariosGrupoModel) {
        usuariosGrupoModel.setGrupoSelecionado(true);
    }

    public List<UsuarioGrupoModel> recuperaTodosGruposComOuSemUsuario(Long usuarioId) {

        var usuario = usuarioGrupoRepository.recupera(Usuario.class, usuarioId);
        List<UsuarioGrupoModel> usuariosGrupoModels = usuarioGrupoRepository.recuperaGruposPorUsuario(usuario.getId());
        var grupoSemUsuario = new ArrayList<UsuarioGrupoModel>();

        if (LabUtil.isNotEmpty(usuariosGrupoModels)) {
            usuariosGrupoModels.forEach(UsuarioGrupoService::setGrupoSelecionado);
            grupoSemUsuario.addAll(usuariosGrupoModels);

            var gruposIdsUsuario = usuariosGrupoModels.stream().map(UsuarioGrupoModel::getId).collect(Collectors.toList());
            List<Grupo> gruposSemUsuario = usuarioGrupoRepository.recuperaNotIn(Grupo.class, gruposIdsUsuario);
            if (LabUtil.isNotEmpty(gruposSemUsuario)) {
                grupoSemUsuario.addAll(usuarioGrupoModelDTO.toUsuariosGrupoModelCollection(gruposSemUsuario));
            }

        } else {
            List<Grupo> grupos = usuarioGrupoRepository.recupera(Grupo.class);
            grupoSemUsuario.addAll(usuarioGrupoModelDTO.toUsuariosGrupoModelCollection(grupos));
        }
        return grupoSemUsuario;
    }

    public List<GrupoModel> recuperaUmUsuarioComPerssisoes(Long usuarioId) {
        var usuario = usuarioGrupoRepository.recupera(Usuario.class, usuarioId);
        return usuarioGrupoRepository.recuperaGruposUsuario(usuario.getId());
    }

    @Transactional
    public void associarDesassociar(Long usuarioId, List<UsuarioGrupoInput> gruposIds) {

        var usuario = usuarioGrupoRepository.recupera(Usuario.class, usuarioId);

        var gruposIdsNaoSelecionado = gruposIds.stream()
                .filter(umGrupo -> !umGrupo.isGrupoSelecionado()).map(UsuarioGrupoInput::getGrupoId).collect(Collectors.toList());

        var gruposNaoSelecionados = usuarioGrupoRepository.recupera(Grupo.class, gruposIdsNaoSelecionado);

        gruposNaoSelecionados.forEach(usuario::removeGrupo);

        var gruposIdsSelecionados = gruposIds.stream()
                .filter(UsuarioGrupoInput::isGrupoSelecionado).map(UsuarioGrupoInput::getGrupoId).collect(Collectors.toList());

        var gruposSelecionados = usuarioGrupoRepository.recupera(Grupo.class, gruposIdsSelecionados);

        gruposSelecionados.forEach(usuario::adicionaGrupo);
    }
}