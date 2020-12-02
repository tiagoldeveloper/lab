package br.com.lab.exceptionhandler;

import java.util.Calendar;

public class ErroDetalheInput {

    private String titulo;
    private String mensage;
    private String campos;
    private Integer status;
    private String trace;
    private Object[] parametros;


    public ErroDetalheInput(){}

    public ErroDetalheInput(String titulo, String mensage, String campos, String trace) {
        this.titulo = titulo;
        this.mensage = mensage;
        this.campos = campos;
        this.trace = trace;
    }

    public ErroDetalheInput(String titulo, String mensage, String trace, Object[] parametros) {
        this.titulo = titulo;
        this.mensage = mensage;
        this.campos = campos;
        this.trace = trace;
        this.parametros = parametros;
    }



    public ErroDetalheInput(String titulo, String mensage, String campos, Integer status, String trace, Object[] parametros) {
        this.titulo = titulo;
        this.mensage = mensage;
        this.campos = campos;
        this.status = status;
        this.trace = trace;
        this.parametros = parametros;
    }

    public ErroDetalheInput(String titulo, String mensage, Object[] parametros, String trace) {
        this.titulo = titulo;
        this.mensage = mensage;
        this.parametros = parametros;
        this.trace = trace;
    }

    public ErroDetalheInput(String titulo, String mensage, String trace) {
        this.titulo = titulo;
        this.mensage = mensage;
        this.trace = trace;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    public String getCampos() {
        return campos;
    }

    public void setCampos(String campos) {
        this.campos = campos;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public Object[] getParametros() {
        return parametros;
    }

    public void setParametros(Object[] parametros) {
        this.parametros = parametros;
    }
}
