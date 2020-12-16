package br.com.lab.dto;

import br.com.lab.domain.model.Grupo;
import br.com.lab.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioGrupoModelDTO {

    private final ModelMapper modelMapper;

    public UsuarioGrupoModelDTO(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public UsuarioGrupoModel toUsuariosGrupoModel(Object usuario){
        return modelMapper.map(usuario, UsuarioGrupoModel.class);
    }

    public List<UsuarioGrupoModel> toUsuariosGrupoModelCollection(List<Grupo> gruposSemUsuario) {
        return gruposSemUsuario.stream().map(this::toUsuariosGrupoModel).collect(Collectors.toList());
    }
}