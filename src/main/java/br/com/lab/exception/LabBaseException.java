package br.com.lab.exception;

public class LabBaseException extends RuntimeException {

    public LabBaseException(String message) {
        super(message);
    }

    public LabBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public LabBaseException(Throwable cause) {
        super(cause);
    }

}