package br.com.lab.controller;

import br.com.lab.exception.LabBaseException;
import br.com.lab.model.GrupoModel;
import br.com.lab.model.input.GrupoInput;
import br.com.lab.service.GrupoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/grupo")
public class GrupoController implements IGrupoController {

    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService){
      this.grupoService = grupoService;
    }

    @PostMapping(path = "/salvar")
    public ResponseEntity<GrupoModel> salvar(@RequestBody @Valid GrupoInput grupoInput) {
        try {
            return new ResponseEntity<>(grupoService.salvar(grupoInput), HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new LabBaseException(ex);
        }
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<List<GrupoModel>> listar() {
        try {
            return ResponseEntity.ok(grupoService.recuperaTodosGrupos());
        } catch (Exception ex) {
            throw new LabBaseException(ex);
        }
    }

    @GetMapping(path = "/buscar/{grupoId}")
    public ResponseEntity<GrupoModel> buscar(@PathVariable Long grupoId) {
        try {
            return ResponseEntity.ok(grupoService.recuperaUmGrupo(grupoId));
        } catch (Exception ex) {
            throw new LabBaseException(String.valueOf(grupoId), ex);
        }
    }

    @PutMapping(path = "/atualizar/{grupoId}")
    public ResponseEntity<GrupoModel> atualizar(@PathVariable Long grupoId, @RequestBody @Valid GrupoInput grupoInput) {
        try {
            return new ResponseEntity<>(grupoService.atualizar(grupoId, grupoInput), HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new LabBaseException(String.valueOf(grupoId), ex);
        }
    }

    @DeleteMapping(path = "/remover/{grupoId}")
    public ResponseEntity<Void> remover(@PathVariable Long grupoId) {
        try {
            grupoService.remove(grupoId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            throw new LabBaseException(String.valueOf(grupoId), ex);
        }
    }
}