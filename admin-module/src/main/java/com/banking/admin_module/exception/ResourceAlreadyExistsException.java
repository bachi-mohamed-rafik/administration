package com.banking.admin_module.exception;

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }

    public ResourceAlreadyExistsException(String ressourceName, String fieldName, Object fieldValue) {
        super(String.format("%s with %s '%s' already exists", ressourceName, fieldName, fieldValue));
    }
}
