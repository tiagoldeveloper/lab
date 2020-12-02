package br.com.lab.controller;

import br.com.lab.exception.LabBaseException;
import br.com.lab.model.PermissaoModel;
import br.com.lab.model.input.PermissaoInput;
import br.com.lab.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PermissaoModel adicionar(@RequestBody @Valid PermissaoInput permissaoInput){
        try {
            return permissaoService.salvar(permissaoInput);
        }catch (Exception ex){
            throw new LabBaseException(ex);
        }

    }

    @PutMapping("/{permissaoId}")
    @ResponseStatus(HttpStatus.CREATED)
    public PermissaoModel atualizar(@PathVariable Long permissaoId, @RequestBody @Valid PermissaoInput permissaoInput){
        try {
            return permissaoService.atualizar(permissaoId, permissaoInput);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(permissaoId), ex);
        }

    }

    @GetMapping("/{permissaoId}")
    public PermissaoModel buscar(@PathVariable Long permissaoId){
        try {
            return permissaoService.recuperaUmaPermissao(permissaoId);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(permissaoId), ex);
        }
    }

    @GetMapping
    public List<PermissaoModel> listar(@RequestParam("size") Integer size,  @PageableDefault(size = 100) Pageable pageable) {
        try {
            return permissaoService.recuperaTodasPermissoes(pageable);
        }catch (Exception ex){
            throw new LabBaseException(ex);
        }
    }

    @DeleteMapping("/{permissaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long permissaoId){
        try {
            permissaoService.remove(permissaoId);
        }catch (Exception ex){
            throw new LabBaseException(String.valueOf(permissaoId), ex);
        }
    }

}
