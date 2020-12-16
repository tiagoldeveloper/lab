package br.com.lab.controller;

import br.com.lab.exceptionhandler.ErroDetalheInput;
import br.com.lab.model.GrupoModel;
import br.com.lab.model.PermissaoModel;
import br.com.lab.model.input.GrupoInput;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import static br.com.lab.util.LabConstantes.*;

public interface IGrupoController {

    @ApiOperation(value = "Cadastra grupo.", response = GrupoModel.class, notes = "Essa operação salva um grupo.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Retorna um GrupoModel.", response = GrupoModel.class),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class)
    })
    ResponseEntity<GrupoModel> salvar(@RequestBody @Valid GrupoInput grupoInput);

    @ApiOperation(value = "Lista todos grupos." , response = GrupoModel[].class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna uma lista de GrupoModel.", response = GrupoModel[].class),
            @ApiResponse(code = 403, message = "Acesso negado."),
            @ApiResponse(code = 500, message = "Caso ocorrer erro retornar ErroDetalheInput.", response = ErroDetalheInput.class)
    })
    ResponseEntity<List<GrupoModel>> listar();

    @ApiOperation(value = "Busca um grupo." , response = GrupoModel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um grupo.", response = GrupoModel.class),
            @ApiResponse(code = 404, message = "Grupo não encontrado."),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class),
    })
    ResponseEntity<GrupoModel> buscar(@PathVariable Long grupoId);

    @ApiOperation(value = "Atualiza grupo.", response = PermissaoModel.class, notes = "Essa operação atualiza grupo.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Retorna um GrupoModel atualizado.", response = GrupoModel.class),
            @ApiResponse(code = 404, message = "Grupo não encontrado."),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class),
    })
    ResponseEntity<GrupoModel> atualizar(@PathVariable Long grupoId, @RequestBody @Valid GrupoInput grupoInput);

    @ApiOperation(value = "Remove grupo.", notes = "Essa operação exclui grupo.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Grupo removido com sucesso."),
            @ApiResponse(code = 404, message = "Grupo não encontrado."),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class),
    })
    ResponseEntity<Void> remover(@PathVariable Long grupoId);
}