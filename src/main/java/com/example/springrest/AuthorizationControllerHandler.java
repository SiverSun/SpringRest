package com.example.springrest;

import com.google.gson.Gson;
import exeptions.AuthorizationException;
import exeptions.InvalidCredentialsException;
import exeptions.UnauthorizedUserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestControllerAdvice
public class AuthorizationControllerHandler {
    private static final Gson GSON = new Gson();

    @ExceptionHandler(InvalidCredentialsException.class)
    ResponseEntity<String> resolveValidationException(InvalidCredentialsException e) {
        return new ResponseEntity<>(GSON.toJson(e.getMessage()), BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUserException.class)
    ResponseEntity<String> resolveValidationException(UnauthorizedUserException e) {
        return new ResponseEntity<>(GSON.toJson(e.getMessage()), UNAUTHORIZED);
    }

    @ExceptionHandler(AuthorizationException.class)
    ResponseEntity<String> resolveValidationException(AuthorizationException e) {
        return new ResponseEntity<>(GSON.toJson(e.getMessage()), UNAUTHORIZED);
    }

    @ExceptionHandler(BindException.class)
    ResponseEntity<String> resolveValidationException(BindException e) {
        List<String> errors = e.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        return new ResponseEntity<>(GSON.toJson(errors), BAD_REQUEST);
    }
}