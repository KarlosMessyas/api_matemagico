package br.com.matemagico.exception;

public class ProfileAlreadyExistsException extends RuntimeException {
    public ProfileAlreadyExistsException(String message) {
        super(message);
    }
}