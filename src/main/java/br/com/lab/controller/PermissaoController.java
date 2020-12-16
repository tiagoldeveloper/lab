package br.com.lab.controller;

import br.com.lab.exception.LabBaseException;
import br.com.lab.model.PermissaoModel;
import br.com.lab.model.input.PermissaoInput;
import br.com.lab.service.PermissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/permissao")
public class PermissaoController implements IPermissaoController {

    private final PermissaoService permissaoService;

    public PermissaoController(PermissaoService permissaoService){
        this.permissaoService = permissaoService;
    }

    @PostMapping(path = "/salvar")
    public ResponseEntity<PermissaoModel> salvar(@RequestBody @Valid PermissaoInput permissaoInput){
        try {
            return new ResponseEntity<>(permissaoService.salvar(permissaoInput), HttpStatus.CREATED);
        }catch (Exception ex){
            throw new LabBaseException(ex);
        }
    }

    @PutMapping(path = "/atualizar/{permissaoId}")
    public ResponseEntity<PermissaoModel> atualizar(@PathVariable Long permissaoId, @RequestBody @Valid PermissaoInput permissaoInput){
        try {
            return new ResponseEntity<>(permissaoService.atualizar(permissaoId, permissaoInput), HttpStatus.CREATED);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(permissaoId), ex);
        }
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<List<PermissaoModel>> listar() {
        try {
            return ResponseEntity.ok(permissaoService.recuperaTodasPermissoes());
        }catch (Exception ex){
            throw new LabBaseException(ex);
        }
    }

    @GetMapping(path = "/buscar/{permissaoId}")
    public ResponseEntity<PermissaoModel> buscar(@PathVariable Long permissaoId){
        try {
            return ResponseEntity.ok(permissaoService.recuperaUmaPermissao(permissaoId));
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(permissaoId), ex);
        }
    }

    @DeleteMapping(path = "/remover/{permissaoId}")
    public ResponseEntity<Void> remover(@PathVariable Long permissaoId){
        try {
            permissaoService.remove(permissaoId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(permissaoId), ex);
        }
    }
}