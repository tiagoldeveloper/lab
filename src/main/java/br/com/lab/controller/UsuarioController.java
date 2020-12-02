package br.com.lab.controller;

import br.com.lab.exception.LabBaseException;
import br.com.lab.model.UsuarioModel;
import br.com.lab.model.input.UsuarioInput;
import br.com.lab.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioModel> listar(@RequestParam("size") Integer size,  @PageableDefault(size = 100) Pageable pageable) {
        try {
            return usuarioService.recuperaTodosUsuarios(pageable);
        }catch (Exception ex){
            throw new LabBaseException(ex);
        }
    }

    @GetMapping("/{usuarioId}")
    public UsuarioModel buscar(@PathVariable Long usuarioId) {
        try {
            return usuarioService.recuperaUmUsuario(usuarioId);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(usuarioId), ex);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel adicionar(@RequestBody @Valid UsuarioInput usuarioInput) {
        try {
            return usuarioService.salvar(usuarioInput);
        }catch (Exception ex){
            throw new LabBaseException(ex.getMessage(), ex);
        }
    }


    @PutMapping("/{usuarioId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel atualizar(@PathVariable Long usuarioId, @RequestBody @Valid UsuarioInput usuarioInput) {
        try{
            return usuarioService.atualizar(usuarioId, usuarioInput);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(usuarioId), ex);
        }
    }

    @DeleteMapping("/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long usuarioId) {
        try{
            usuarioService.remove(usuarioId);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(usuarioId), ex);
        }
    }
}
