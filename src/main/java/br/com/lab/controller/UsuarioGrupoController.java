package br.com.lab.controller;

import br.com.lab.exception.LabBaseException;
import br.com.lab.model.GrupoModel;
import br.com.lab.service.UsuarioGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario/{usuarioId}/grupo")
public class UsuarioGrupoController {

    @Autowired
    private UsuarioGrupoService usuarioGrupoService;

    @GetMapping
    public List<GrupoModel> listar(@PathVariable Long usuarioId) {
        try {
            return usuarioGrupoService.recuperaGruposPorUsuario(usuarioId);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(usuarioId), ex);
        }
    }

    @PutMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
        try {
            usuarioGrupoService.associar(usuarioId, grupoId);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(String.valueOf(usuarioId)), ex);
        }
    }

    @DeleteMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
        try {
            usuarioGrupoService.desassociar(usuarioId, grupoId);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(String.valueOf(usuarioId)), ex);
        }
    }

}
