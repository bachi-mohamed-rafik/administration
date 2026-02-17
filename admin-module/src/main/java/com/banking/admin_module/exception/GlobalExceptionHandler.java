package com.banking.admin_module.exception;

import com.banking.admin_module.model.dto.globalApiResponse.ErrorResponseGlobal;
import com.banking.admin_module.model.enums.ErrorCode;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        String detailsMessage = (ex.getMessage() != null && !ex.getMessage().isBlank())
                ? ex.getMessage()
                : "Une erreur est survenue lors du traitement de votre demande. Veuillez réessayer plus tard.";
        ErrorResponseGlobal response = ErrorResponseGlobal.of(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ErrorCode.ERR_INVALID_ARGUMENT.getCode(),
                ErrorCode.ERR_INVALID_ARGUMENT.getDescription(),
                detailsMessage
        );
        logger.error(ex.getMessage());
        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    // Handle EntityNotFoundException globally
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(
            EntityNotFoundException ex,
            WebRequest request) {
        String detailsMessage = (ex.getMessage() != null && !ex.getMessage().isBlank())
                ? ex.getMessage()
                : "L'entité demandée n'a pas été trouvée. Veuillez vérifier votre requête et réessayer.";
        ErrorResponseGlobal response = ErrorResponseGlobal.of(
                HttpStatus.NOT_FOUND,
                ErrorCode.ERR_ENTITY_NOT_FOUND.getCode(),
                ErrorCode.ERR_ENTITY_NOT_FOUND.getDescription(),
                detailsMessage
        );
        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        List<String> errors= ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::buildFieldErrorMessage)
                .collect(Collectors.toList());

        ErrorResponseGlobal response = ErrorResponseGlobal.of(
                HttpStatus.BAD_REQUEST,
                ErrorCode.ERR_INVALID_ARGUMENT.getCode(),
                ErrorCode.ERR_INVALID_ARGUMENT.getDescription(),
                errors
        );
        return handleExceptionInternal(ex, response, headers, HttpStatus.BAD_REQUEST, request);
    }

    private String buildFieldErrorMessage(FieldError fieldError) {
        if (fieldError.contains(org.springframework.beans.TypeMismatchException.class)) {
            TypeMismatchException typeMismatch = fieldError.unwrap(TypeMismatchException.class);
            return buildTypeMismatchErrorMessage(typeMismatch);
        }

        return String.format("%s", fieldError.getDefaultMessage());
    }

    private String buildTypeMismatchErrorMessage(TypeMismatchException ex) {
        if (ex.getRequiredType() != null && ex.getRequiredType().isEnum()) {
            return String.format("Une erreur est survenue. Veuillez réessayer plus tard");
        }

        return String.format("Une erreur est survenue. Veuillez réessayer plus tard");
    }

}
