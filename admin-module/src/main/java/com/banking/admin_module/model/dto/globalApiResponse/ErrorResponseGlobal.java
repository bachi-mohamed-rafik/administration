package com.banking.admin_module.model.dto.globalApiResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponseGlobal extends GlobalApiResponse<Void> {

    private List<String> errors;
    private String code;

    public static ErrorResponseGlobal of(
            HttpStatus httpStatus,
            String code,
            String message,
            List<String> errors
    ){
        ErrorResponseGlobal response = new ErrorResponseGlobal();
        response.setStatus(httpStatus.value());
        response.setCode(code);
        response.setMessage(message);
        response.setErrors(errors);
        response.setTimeStamp(LocalDateTime.now());
        return response;
    }

    public static ErrorResponseGlobal of(
            HttpStatus httpStatus,
            String code,
            String message,
            String error
    ){
        return of(httpStatus, code, message, List.of(error));
    }

}
