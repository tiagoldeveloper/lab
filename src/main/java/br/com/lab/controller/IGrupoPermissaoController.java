package br.com.lab.controller;

import br.com.lab.exceptionhandler.ErroDetalheInput;
import br.com.lab.model.PermissaoModel;
import br.com.lab.model.PermissaoGrupoModel;
import br.com.lab.model.input.GrupoPermissaoInput;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static br.com.lab.util.LabConstantes.ACESSO_NEGADO;
import static br.com.lab.util.LabConstantes.ERRO_INTERNO;

public interface IGrupoPermissaoController {

    @ApiOperation(value = "Lista todas permissões de um grupo e sem grupo.", response = PermissaoGrupoModel[].class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna uma lista de PermissoesGrupoModel.", response = PermissaoGrupoModel[].class),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class)
    })
    ResponseEntity<List<PermissaoGrupoModel>> listaTodasPermissoesComESemGrupo(Long grupoId);


    @ApiOperation(value = "Lista todas permissões de um grupo.", response = PermissaoModel[].class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna uma lista de PermissaoModel.", response = PermissaoModel[].class),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class)
    })
    ResponseEntity<List<PermissaoModel>> listarPermissoesPorGrupo(Long grupoId);

    @ApiOperation(value = "Associa e Desassocia permissão de um grupo.", notes = "Essa operação associa e desassocia permissão de grupo.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Associação e Desassociação com sucesso."),
            @ApiResponse(code = 404, message = "Grupo não encontrado ou Permissão não encontrada."),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class),
    })
    ResponseEntity<Void> associarDesassociaEmLote(Long grupoId, List<GrupoPermissaoInput> permissoesInput);
}