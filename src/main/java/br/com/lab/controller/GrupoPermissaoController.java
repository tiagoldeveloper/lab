package br.com.lab.controller;

import br.com.lab.exception.LabBaseException;
import br.com.lab.model.PermissaoModel;
import br.com.lab.service.GrupoPermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/grupo/{grupoId}/permissao")
public class GrupoPermissaoController {

    @Autowired
    private GrupoPermissaoService grupoPermissaoService;

    @GetMapping
    public List<PermissaoModel> listar(@PathVariable Long grupoId) {
        try {
            return grupoPermissaoService.recuperaPermissoesPorGrupo(grupoId);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(grupoId), ex);
        }
    }

    @PutMapping("/{permissaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar(@PathVariable Long grupoId, @PathVariable Long permissaoId) {
        try {
            grupoPermissaoService.associar(grupoId, permissaoId);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(grupoId), ex);
        }
    }

    @DeleteMapping("/{permissaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar(@PathVariable Long grupoId, @PathVariable Long permissaoId) {
        try {
            grupoPermissaoService.desassociar(grupoId, permissaoId);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(grupoId), ex);
        }
    }

}
