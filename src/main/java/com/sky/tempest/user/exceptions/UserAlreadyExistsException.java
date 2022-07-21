package com.sky.tempest.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.AuthenticationException;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@ResponseStatus(
        code = HttpStatus.BAD_REQUEST,
        reason = "Account exists already with this email.")
public class UserAlreadyExistsException extends EntityExistsException {
    public UserAlreadyExistsException (){
        super("Account exists already with this email.");
    }
}
