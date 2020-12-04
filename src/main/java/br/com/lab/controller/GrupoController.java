package br.com.lab.controller;

import br.com.lab.exception.LabBaseException;
import br.com.lab.model.GrupoModel;
import br.com.lab.model.input.GrupoInput;
import br.com.lab.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/grupo")
@CrossOrigin(origins  = "http://localhost:4200")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public GrupoModel adicionar(@RequestBody @Valid GrupoInput grupoInput) {
        try {
            return grupoService.salvar(grupoInput);
        } catch (Exception ex) {
            throw new LabBaseException(ex);
        }
    }

    @PutMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.CREATED)
    public GrupoModel atualizar(@PathVariable Long grupoId, @RequestBody @Valid GrupoInput grupoInput) {
        try {
            return grupoService.atualizar(grupoId, grupoInput);
        } catch (Exception ex) {
            throw new LabBaseException(String.valueOf(grupoId), ex);
        }
    }

    @GetMapping("/{grupoId}")
    public GrupoModel buscar(@PathVariable Long grupoId) {
        try {
            return grupoService.recuperaUmGrupo(grupoId);
        } catch (Exception ex) {
            throw new LabBaseException(String.valueOf(grupoId), ex);
        }
    }

    @GetMapping
    public List<GrupoModel> listar(@RequestParam("size") Integer size,  @PageableDefault(size = 100) Pageable pageable) {
        try {
            return grupoService.recuperaTodosGrupos(pageable);
        } catch (Exception ex) {
            throw new LabBaseException(ex);
        }
    }

    @DeleteMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long grupoId) {
        try {
            grupoService.remove(grupoId);
        } catch (Exception ex) {
            throw new LabBaseException(String.valueOf(grupoId), ex);
        }
    }
}
