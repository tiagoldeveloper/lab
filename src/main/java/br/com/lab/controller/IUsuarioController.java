package br.com.lab.controller;

import br.com.lab.docs.ApiResponsePadrao;
import br.com.lab.exceptionhandler.ErroDetalheInput;
import br.com.lab.model.PermissaoModel;
import br.com.lab.model.UsuarioModel;
import br.com.lab.model.input.UsuarioInput;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

import static br.com.lab.util.LabConstantes.ACESSO_NEGADO;
import static br.com.lab.util.LabConstantes.ERRO_INTERNO;

public interface IUsuarioController {

    @ApiResponsePadrao()
    @ApiOperation(value = "Cadastra usuário.", response = UsuarioModel.class, notes = "Essa operação salva usuário.")
    @ApiResponse(code = 201, message = "Retorna um UsuarioModel cadastrado.", response = UsuarioModel.class)
    ResponseEntity<UsuarioModel> salvar(@RequestBody @Valid UsuarioInput usuarioInput);

    @ApiResponsePadrao()
    @ApiOperation(value = "Lista todos usuários." , response = UsuarioModel[].class)
    @ApiResponse(code = 200, message = "Retorna uma lista de UsuarioModel.", response = PermissaoModel[].class)
    ResponseEntity<List<UsuarioModel>> listar();

    @ApiOperation(value = "Busca um usuário." , response = UsuarioModel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um UsuarioModel.", response = UsuarioModel.class),
            @ApiResponse(code = 404, message = "Usuário não encontrado."),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class),
    })
    ResponseEntity<UsuarioModel> buscar(@PathVariable Long usuarioId);

    @ApiOperation(value = "Atualiza usuário.", response = PermissaoModel.class, notes = "Essa operação atualiza usuário.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Retorna um UsuarioModel atualizado.", response = UsuarioModel.class),
            @ApiResponse(code = 404, message = "Usuário não encontrado."),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class),
    })
    ResponseEntity<UsuarioModel> atualizar(@PathVariable Long usuarioId, @RequestBody @Valid UsuarioInput usuarioInput);

    @ApiOperation(value = "Remove usuário.", notes = "Essa operação exclui usuário.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Usuário removido com sucesso."),
            @ApiResponse(code = 404, message = "Usuário não encontrado."),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class),
    })
    ResponseEntity<Void> remover(@PathVariable Long usuarioId);
}