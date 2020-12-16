package br.com.lab.dto;

import br.com.lab.domain.model.Usuario;
import br.com.lab.model.UsuarioModel;
import br.com.lab.model.input.UsuarioInput;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioModelDTO {

    private final ModelMapper modelMapper;

    public UsuarioModelDTO(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Usuario toUsuarioObject(UsuarioInput usuarioInput){
        return modelMapper.map(usuarioInput, Usuario.class);
    }

    public UsuarioModel toUsuarioModel(Usuario usuario){
        return modelMapper.map(usuario, UsuarioModel.class);
    }

    public List<UsuarioModel> toCollectionModel(List<Usuario> usuarios){
        return usuarios.stream().map(this::toUsuarioModel).collect(Collectors.toList());
    }

    public void copyToUsuarioDomainObject(UsuarioInput usuarioInput, Usuario usuarioAtual) {
        modelMapper.map(usuarioInput, usuarioAtual);
    }
}