package br.com.abd.api.exception;

import org.springframework.http.HttpStatus;

public class HttpException extends RuntimeException {

    private static final long serialVersionUID = -2544217949523231206L;

    private final HttpStatus status;

    public HttpException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpException(String message, Throwable throwable, HttpStatus status) {
        super(message, throwable);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}