package br.com.lab.exceptionhandler;

public class ErroDetalheInput {

    private String titulo;
    private String mensage;
    private String campos;
    private Integer status;
    private String trace;
    private Object[] parametros;

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