package br.com.matemagico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(NotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                erros.put(error.getField(), error.getDefaultMessage())
        );

        return erros;
    }

    @ExceptionHandler(ProfileAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleProfileAlreadyExists(ProfileAlreadyExistsException ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("error", ex.getMessage());
        return erro;
    }
}