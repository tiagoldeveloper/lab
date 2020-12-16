package br.com.lab.controller;

import br.com.lab.exceptionhandler.ErroDetalheInput;
import br.com.lab.model.GrupoModel;
import br.com.lab.model.UsuarioGrupoModel;
import br.com.lab.model.input.UsuarioGrupoInput;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static br.com.lab.util.LabConstantes.ACESSO_NEGADO;
import static br.com.lab.util.LabConstantes.ERRO_INTERNO;

public interface IUsuarioGrupoController {

    @ApiOperation(value = "Lista todos grupos de um usuário incluindo os do usuários.", response = UsuarioGrupoModel[].class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna uma lista de UsuariosGrupoModel.", response = UsuarioGrupoModel[].class),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class)
    })
    ResponseEntity<List<UsuarioGrupoModel>> listaTodosGruposComOuSemUsuario(Long usuarioId);

    @ApiOperation(value = "Lista todos grupos de um usuário.", response = GrupoModel[].class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna uma lista de GrupoModel.", response = GrupoModel[].class),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class)
    })
    ResponseEntity<List<GrupoModel>> recuperaUmUsuarioComPerssisoes(Long usuarioId);

    @ApiOperation(value = "Associa e Desassocia grupo de um usuário.", notes = "Essa operação associa e desassocia grupo de usuário.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Associação e Desassociação com sucesso."),
            @ApiResponse(code = 404, message = "Usuário não encontrado ou Grupo não encontrado."),
            @ApiResponse(code = 403, message = ACESSO_NEGADO),
            @ApiResponse(code = 500, message = ERRO_INTERNO, response = ErroDetalheInput.class),
    })
    ResponseEntity<Void> associarDesassociaEmLote(Long usuarioId, List<UsuarioGrupoInput> gruposIds);
}