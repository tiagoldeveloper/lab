package br.com.lab.controller;

import br.com.lab.exceptionhandler.ErroDetalheInput;
import br.com.lab.model.PermissaoModel;
import br.com.lab.model.input.PermissaoInput;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static br.com.lab.util.LabConstantes.*;

public interface IPermissaoController {

    @ApiOperation(value = "Lista todas permissões." , response = PermissaoModel[].class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna uma lista de PermissaoModel.", response = PermissaoModel[].class),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class)
    })
    ResponseEntity<List<PermissaoModel>> listar();

    @ApiOperation(value = "Cadastra permissão.", response = PermissaoModel.class, notes = "Essa operação salva uma permissão.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Retorna uma PermissaoModel.", response = PermissaoModel.class),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class)
    })
    ResponseEntity<PermissaoModel> salvar(@RequestBody @Valid PermissaoInput permissaoInput);

    @ApiOperation(value = "Busca uma permissão." , response = PermissaoModel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma PermissaoModel.", response = PermissaoModel.class),
            @ApiResponse(code = 404, message = "Permissão não encontrada."),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class),
    })
    ResponseEntity<PermissaoModel> buscar(@PathVariable Long permissaoId);

    @ApiOperation(value = "Atualiza permissão.", response = PermissaoModel.class, notes = "Essa operação atualiza permissão.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Retorna uma permissão PermissaoModel atualizada.", response = PermissaoModel.class),
            @ApiResponse(code = 404, message = "Permissão não encontrada."),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class),
    })
    ResponseEntity<PermissaoModel> atualizar(@PathVariable Long permissaoId, @RequestBody @Valid PermissaoInput permissaoInput);

    @ApiOperation(value = "Remove permissão.", notes = "Essa operação exclui permissão.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Permissão removida com sucesso."),
            @ApiResponse(code = 404, message = "Permissão não encontrada."),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class),
    })
    ResponseEntity<Void> remover(@PathVariable Long permissaoId);
}