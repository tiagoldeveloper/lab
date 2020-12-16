package br.com.lab.exceptionhandler;

import com.google.gson.Gson;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AcessoNegadoEntryPoint  implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        var erroDetalhe = new ErroDetalhe();
        erroDetalhe.setTitulo("Acesso negado.");
        erroDetalhe.setMensage("Usuário sem permissão ou token inválido, verifique se o token está correto e tente novamente.");
        erroDetalhe.setStatus(403);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setStatus(403);
        httpServletResponse.getWriter().write(new Gson().toJson(erroDetalhe));
    }
}