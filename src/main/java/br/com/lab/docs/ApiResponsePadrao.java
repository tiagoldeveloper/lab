package br.com.lab.docs;

import br.com.lab.exceptionhandler.ErroDetalheInput;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses({
        @ApiResponse(code = 403, message = "Acesso negado."),
        @ApiResponse(code = 500, message = "Caso ocorrer erro retornar ErroDetalheInput.", response = ErroDetalheInput.class)
})
public @interface ApiResponsePadrao {}



