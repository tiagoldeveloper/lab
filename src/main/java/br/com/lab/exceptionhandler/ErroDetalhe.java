package br.com.lab.exceptionhandler;

import java.util.Calendar;

public class ErroDetalhe {

    private String titulo;
    private String mensage;
    private String campos;
    private Integer status;
    private String trace;
    private Calendar timestamp = Calendar.getInstance();


    public ErroDetalhe(){}

    public ErroDetalhe(String titulo, String mensage, String campos, Integer status, String trace, Calendar timestamp) {
        this.titulo = titulo;
        this.mensage = mensage;
        this.campos = campos;
        this.status = status;
        this.trace = trace;
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {this.titulo = titulo; }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public String getCampos() {
        return campos;
    }
    public void setCampos(String campos) {
        this.campos = campos;
    }

}
