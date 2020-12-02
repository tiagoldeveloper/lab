package br.com.lab.dto;

import br.com.lab.domain.model.Permissao;
import br.com.lab.model.PermissaoModel;
import br.com.lab.model.input.PermissaoInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PermissaoModelDTO {

    @Autowired
    private ModelMapper modelMapper;

    public Permissao toPermissaoObject(PermissaoInput permissaoInput){
        return modelMapper.map(permissaoInput, Permissao.class);
    }

    public PermissaoModel toModelObject(Permissao  permissao){
        return modelMapper.map(permissao, PermissaoModel.class);
    }

    public List<PermissaoModel> toModelCollection(Collection<Permissao> permissoes){
        return permissoes.stream().map(permissao -> toModelObject(permissao)).collect(Collectors.toList());
    }

    public void copyToDomainObject(PermissaoInput permissaoInput, Permissao permissao){
        modelMapper.map(permissaoInput, permissao);
    }

}
