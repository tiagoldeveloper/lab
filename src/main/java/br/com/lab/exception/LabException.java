package br.com.lab.exception;

public class LabException extends RuntimeException{

    public LabException(String message) {
        super(message);
    }

    public LabException(String message, Throwable cause) {
        super(message, cause);
    }

}
