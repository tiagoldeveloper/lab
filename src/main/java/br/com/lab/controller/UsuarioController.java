package br.com.lab.controller;

import br.com.lab.exception.LabBaseException;
import br.com.lab.model.UsuarioModel;
import br.com.lab.model.input.UsuarioInput;
import br.com.lab.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/usuario")
public class UsuarioController implements IUsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping(path = "/salvar")
    public ResponseEntity<UsuarioModel> salvar(@RequestBody @Valid UsuarioInput usuarioInput) {
        try {
            return new ResponseEntity<>(usuarioService.salvar(usuarioInput), HttpStatus.CREATED);
        }catch (Exception ex){
            throw new LabBaseException(ex.getMessage(), ex);
        }
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<List<UsuarioModel>> listar() {
        try {
            return ResponseEntity.ok(usuarioService.recuperaTodosUsuarios());
        }catch (Exception ex){
            throw new LabBaseException(ex);
        }
    }

    @GetMapping(path = "/buscar/{usuarioId}")
    public ResponseEntity<UsuarioModel> buscar(@PathVariable Long usuarioId) {
        try {
            return ResponseEntity.ok(usuarioService.recuperaUmUsuario(usuarioId));
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(usuarioId), ex);
        }
    }

    @PutMapping(path = "/atualizar/{usuarioId}")
    public ResponseEntity<UsuarioModel> atualizar(@PathVariable Long usuarioId, @RequestBody @Valid UsuarioInput usuarioInput) {
        try{
            return new ResponseEntity<>(usuarioService.atualizar(usuarioId, usuarioInput), HttpStatus.CREATED);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(usuarioId), ex);
        }
    }

    @DeleteMapping(path = "/remover/{usuarioId}")
    public ResponseEntity<Void> remover(@PathVariable Long usuarioId) {
        try{
            usuarioService.remove(usuarioId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(usuarioId), ex);
        }
    }
}