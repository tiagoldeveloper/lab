package br.com.lab.dto;

import br.com.lab.domain.model.Grupo;
import br.com.lab.model.GrupoModel;
import br.com.lab.model.input.GrupoInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GrupoModelDTO {

    @Autowired
    private ModelMapper modelMapper;

    public Grupo toGrupoObject(GrupoInput grupoInput){
       return modelMapper.map(grupoInput, Grupo.class);
    }

    public GrupoModel toModelObject(Grupo grupo){
        return modelMapper.map(grupo, GrupoModel.class);
    }

    public void toGrupoDomainObject(GrupoInput grupoInput, Grupo grupo){
        modelMapper.map(grupoInput, grupo);
    }

    public List<GrupoModel> toModelCollection(Collection<Grupo> grupos){
        return grupos.stream().map(grupo -> toModelObject(grupo)).collect(Collectors.toList());
    }

}
