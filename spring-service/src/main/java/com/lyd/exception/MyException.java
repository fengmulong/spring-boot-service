package com.lyd.exception;

import org.apache.commons.lang3.exception.DefaultExceptionContext;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MyException extends ResponseStatusException {

    public MyException() {
        super(HttpStatus.BAD_REQUEST);
    }

    public MyException(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }

    public MyException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public MyException(int status, String reason) {
        super(HttpStatus.valueOf(status), reason);
    }

    public MyException(Throwable t) {
        super(HttpStatus.BAD_REQUEST, t.getMessage(), t);
    }
}
