package br.com.lab.controller;

import br.com.lab.exception.LabBaseException;
import br.com.lab.model.GrupoModel;
import br.com.lab.model.UsuarioGrupoModel;
import br.com.lab.model.input.UsuarioGrupoInput;
import br.com.lab.service.UsuarioGrupoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/usuario/grupo")
public class UsuarioGrupoController implements IUsuarioGrupoController{

    private final UsuarioGrupoService usuarioGrupoService;

    public UsuarioGrupoController(UsuarioGrupoService usuarioGrupoService){
        this.usuarioGrupoService = usuarioGrupoService;
    }

    @GetMapping(path = "/listar/{usuarioId}")
    public ResponseEntity<List<UsuarioGrupoModel>> listaTodosGruposComOuSemUsuario(@PathVariable Long usuarioId) {
        try {
            return ResponseEntity.ok(usuarioGrupoService.recuperaTodosGruposComOuSemUsuario(usuarioId));
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(usuarioId), ex);
        }
    }

    @GetMapping(path = "/buscar/{usuarioId}")
    public ResponseEntity<List<GrupoModel>> recuperaUmUsuarioComPerssisoes(@PathVariable Long usuarioId) {
        try {
            return ResponseEntity.ok(usuarioGrupoService.recuperaUmUsuarioComPerssisoes(usuarioId));
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(usuarioId), ex);
        }
    }

    @PostMapping(path = "/associar/desassociar/{usuarioId}")
    public ResponseEntity<Void> associarDesassociaEmLote(@PathVariable Long usuarioId, @RequestBody List<UsuarioGrupoInput> gruposIds) {
        try {
            usuarioGrupoService.associarDesassociar(usuarioId, gruposIds);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(String.valueOf(usuarioId)), ex);
        }
    }
}