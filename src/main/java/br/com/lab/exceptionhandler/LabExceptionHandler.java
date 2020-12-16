package br.com.lab.exceptionhandler;

import br.com.lab.exception.LabBaseException;
import br.com.lab.mensagens.Mensagens;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class LabExceptionHandler extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var erro = new ErroDetalheInput();
        erro.setTitulo("campo.formato.invalido.titulo");
        erro.setMensage("campo.formato.invalido.msg");
        erro.setStatus(status.value());
        erro.setTrace(ex.getClass().getName());
        return new ResponseEntity<>(trataErroDetalhe(erro), status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var erro = new ErroDetalheInput();
        erro.setTitulo("metodo.nao.suportado.titulo");
        erro.setMensage("metodo.nao.suportado.msg");
        erro.setStatus(status.value());
        erro.setTrace(ex.getClass().getName());

        return new ResponseEntity<>(trataErroDetalhe(erro), status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var campos = exception.getFieldErrors().stream().map(FieldError::getField).collect(Collectors.joining(", "));
        var erro = new ErroDetalheInput();
        erro.setTitulo("campos.invalidos.titulo");
        erro.setMensage("campos.invalidos.msg");
        erro.setCampos(campos);
        erro.setTrace(exception.getClass().getName());
        return new ResponseEntity<>(trataErroDetalhe(erro), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class, LabBaseException.class, UsernameNotFoundException.class})
    public ResponseEntity<ErroDetalhe> handleLabException(Exception exception, WebRequest request){

        var status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErroDetalheInput erroInput = new ErroDetalheInput();

        if(exception instanceof  LabBaseException){
            if(exception.getCause().toString().contains("NoResultException")){
                status = HttpStatus.NOT_FOUND;
                erroInput.setTitulo("registro.nao.encontrado.titulo");
                erroInput.setMensage("registro.nao.encontrado.msg");
                erroInput.setStatus(status.value());
                erroInput.setTrace(exception.getClass().getName());
                erroInput.setParametros(new Object[]{exception.getMessage()});
            }

            if(exception.getCause().toString().contains("ConstraintViolationException")){
                status = HttpStatus.CONFLICT;
                erroInput.setTitulo("registro.em.uso.titulo");
                erroInput.setMensage("registro.nao.pode.ser.excluido");
                erroInput.setStatus(status.value());
                erroInput.setTrace(exception.getClass().getName());
                erroInput.setParametros(new Object[]{exception.getMessage()});
            }

            if(exception.getCause().toString().contains("DataException")){
                status = HttpStatus.CONFLICT;
                erroInput.setTitulo("campos.valores.invalidos.titulo");
                erroInput.setMensage("campos.valores.invalidos.msg");
                erroInput.setStatus(status.value());
                erroInput.setTrace(exception.getClass().getName());
                erroInput.setParametros(new Object[]{exception.getMessage()});
            }

        }else if(exception instanceof UsernameNotFoundException){
            status = HttpStatus.FORBIDDEN;
            erroInput.setTitulo("Usuário não encontrado");
            erroInput.setMensage("Usuário não encontrado");
            erroInput.setStatus(status.value());
            erroInput.setTrace(exception.getClass().getName());
            erroInput.setParametros(new Object[]{exception.getMessage()});
        }

        else{
            erroInput.setTitulo("erro.nao.tratado.titulo");
            erroInput.setMensage("erro.nao.tratado.msg");
            erroInput.setStatus(status.value());
            erroInput.setTrace(exception.toString());
        }

        return new ResponseEntity<>(trataErroDetalhe(erroInput), status);
    }

    private ErroDetalhe trataErroDetalhe(ErroDetalheInput erro){
        var erroDetalhe = new ErroDetalhe();
        erroDetalhe.setTitulo(Mensagens.getInstance().getMsg(erro.getTitulo()));
        erroDetalhe.setMensage(Mensagens.getInstance().getMsg(erro.getMensage(), erro.getParametros()));
        erroDetalhe.setCampos(StringUtils.defaultString(erro.getCampos(), ""));
        erroDetalhe.setStatus(null != erro.getStatus() ? erro.getStatus() : HttpStatus.BAD_REQUEST.value());
        erroDetalhe.setTrace(StringUtils.defaultString(erro.getTrace(), Mensagens.getInstance().getMsg("stacktrace.nao.econtrado")));
        return erroDetalhe;
    }
}