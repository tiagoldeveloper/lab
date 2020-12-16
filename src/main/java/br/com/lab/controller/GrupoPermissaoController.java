package br.com.lab.controller;

import br.com.lab.exception.LabBaseException;
import br.com.lab.model.PermissaoModel;
import br.com.lab.model.PermissaoGrupoModel;
import br.com.lab.model.input.GrupoPermissaoInput;
import br.com.lab.service.GrupoPermissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/grupo/permissao")
public class GrupoPermissaoController implements IGrupoPermissaoController{

    private final GrupoPermissaoService grupoPermissaoService;

    public GrupoPermissaoController(GrupoPermissaoService grupoPermissaoService){
        this.grupoPermissaoService = grupoPermissaoService;
    }

    @GetMapping(path = "/listar/{grupoId}")
    public ResponseEntity<List<PermissaoGrupoModel>> listaTodasPermissoesComESemGrupo(@PathVariable Long grupoId) {
        try {
            return ResponseEntity.ok(grupoPermissaoService.recuperaTodasPermissoesComESemGrupo(grupoId));
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(grupoId), ex);
        }
    }

    @GetMapping(path = "/buscar/{grupoId}")
    public ResponseEntity<List<PermissaoModel>> listarPermissoesPorGrupo(@PathVariable Long grupoId) {
        try {
            return ResponseEntity.ok(grupoPermissaoService.recuperaPermissoesGrupo(grupoId));
        } catch (Exception ex) {
            throw new LabBaseException(String.valueOf(grupoId), ex);
        }
    }

    @PostMapping(path = "/associar/desassociar/{grupoId}")
    public ResponseEntity<Void> associarDesassociaEmLote(@PathVariable Long grupoId, @RequestBody List<GrupoPermissaoInput> permissoesInput) {
        try {
            grupoPermissaoService.associarDesassociaEmLote(grupoId, permissoesInput);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            throw new LabBaseException(ex);
        }
    }
}