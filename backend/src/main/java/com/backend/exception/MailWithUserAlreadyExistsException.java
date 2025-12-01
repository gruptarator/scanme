package com.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MailWithUserAlreadyExistsException extends RuntimeException {
    public MailWithUserAlreadyExistsException(String message) {
        super(message);
    }
}
