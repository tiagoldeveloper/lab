package br.com.lab.controller;

import br.com.lab.exception.LabBaseException;
import br.com.lab.model.MenuItemModel;
import br.com.lab.service.UsuarioPermissoesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/usuario/permissoes")
public class UsuarioPermissoesController {

    private final UsuarioPermissoesService permissaoUsuarioService;

    public UsuarioPermissoesController(UsuarioPermissoesService permissaoUsuarioService){
        this.permissaoUsuarioService = permissaoUsuarioService;
    }

    @GetMapping
    public ResponseEntity<List<MenuItemModel>> recuperaPermissoesMenuItem() {
        try {
            return ResponseEntity.ok(permissaoUsuarioService.recuperaPermissoesMenuItem());
        }catch (Exception ex){
            throw new LabBaseException(ex);
        }
    }
}