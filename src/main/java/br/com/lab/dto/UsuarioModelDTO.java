package br.com.lab.dto;

import br.com.lab.domain.model.Usuario;
import br.com.lab.model.UsuarioModel;
import br.com.lab.model.input.UsuarioInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioModelDTO {

    @Autowired
    private ModelMapper modelMapper;

    public Usuario toUsuarioObject(UsuarioInput usuarioInput){
        return modelMapper.map(usuarioInput, Usuario.class);
    }

    public UsuarioModel toUsuarioModel(Usuario usuario){
        return modelMapper.map(usuario, UsuarioModel.class);
    }

    public List<UsuarioModel> toCollectionModel(List<Usuario> usuarios){
        return usuarios.stream().map(usuario -> toUsuarioModel(usuario))
                .collect(Collectors.toList());
    }

    public UsuarioModel toUsuarioModelsssss(Object usuario){
        UsuarioModel map = modelMapper.map(usuario, UsuarioModel.class);
        return modelMapper.map(usuario, UsuarioModel.class);
    }

    public List<UsuarioModel> toCollectionModelsssssss(List<Object[]> usuarioss){
       return usuarioss.stream().map(objects -> toUsuarioModelsssss(objects)).collect(Collectors.toList());
    }


    public void copyToUsuarioDomainObject(UsuarioInput usuarioInput, Usuario usuarioAtual) {
        modelMapper.map(usuarioInput, usuarioAtual);
    }
}
