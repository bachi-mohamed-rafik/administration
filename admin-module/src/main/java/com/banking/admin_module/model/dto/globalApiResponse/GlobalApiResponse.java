package com.banking.admin_module.model.dto.globalApiResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Réponse standardisée pour les API")
public class GlobalApiResponse<T> {
    private int status;
    private String message;
    private T data;
    private String code;
    private LocalDateTime timeStamp;

    public static <T> GlobalApiResponse<T> of(
            HttpStatus status,
            String message,
            T data
    ) {
        GlobalApiResponse<T> response = new GlobalApiResponse<>();
        response.setStatus(status.value());
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    // Read operations
    public static <T> GlobalApiResponse<T> success(T data) {
        return of(HttpStatus.OK, "Request successful", data);
    }

    public static <T> GlobalApiResponse<T> success(T data, String message) {
        return of(HttpStatus.OK, message, null);
    }

    //Create operations
    public static <T> GlobalApiResponse<T> created(T data) {
        return of(HttpStatus.CREATED,  "Ressource created successfuly", data);
    }

    public static <T> GlobalApiResponse<T> created(T data, String message) {
        return of(HttpStatus.CREATED, message, data);
    }

    // Delete operations
    public static GlobalApiResponse<Void> deleted() {
        return of(HttpStatus.NO_CONTENT, "Ressource deleted successfuly", null);
    }

    public static GlobalApiResponse<Void> deleted(String message) {
        return of(HttpStatus.NO_CONTENT, message, null);
    }

}
