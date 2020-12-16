package br.com.lab.dto;

import br.com.lab.domain.model.Permissao;
import br.com.lab.model.PermissaoGrupoModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GrupoPermissaoModelDTO {

    private final ModelMapper modelMapper;

    public GrupoPermissaoModelDTO(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public PermissaoGrupoModel toPermissoesGrupoModel(Permissao permissao){
        return modelMapper.map(permissao, PermissaoGrupoModel.class);
    }

    public List<PermissaoGrupoModel> toPermissoesGrupoModelCollection(Collection<Permissao> permissoes){
        return permissoes.stream().map(this::toPermissoesGrupoModel).collect(Collectors.toList());
    }
}