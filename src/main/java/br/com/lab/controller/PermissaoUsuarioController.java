package br.com.lab.controller;

import br.com.lab.exception.LabBaseException;
import br.com.lab.model.MenuItemModel;
import br.com.lab.service.PermissaoUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/permissao/usuario")
public class PermissaoUsuarioController {

    private final PermissaoUsuarioService permissaoUsuarioService;

    public PermissaoUsuarioController(PermissaoUsuarioService permissaoUsuarioService){
        this.permissaoUsuarioService = permissaoUsuarioService;
    }

    @GetMapping(path = "/buscar/{usuarioId}")
    public ResponseEntity<List<MenuItemModel>> recuperaPermissoesPorMenuPorUsuario(@PathVariable Long usuarioId) {
        try {
            return ResponseEntity.ok(permissaoUsuarioService.recuperaPermissoesPorMenuPorUsuario(usuarioId));
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(usuarioId), ex);
        }
    }
}