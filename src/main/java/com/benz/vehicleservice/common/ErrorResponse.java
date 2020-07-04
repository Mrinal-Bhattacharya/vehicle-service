package com.benz.vehicleservice.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ErrorResponse {
    private final int statusCode;
    private final String reasonPhrase;
    private final List<ApiError> errors;

    private ErrorResponse(int statusCode, String reason, List<ApiError> errors) {
        this.statusCode = statusCode;
        this.reasonPhrase = reason;
        this.errors = errors;
    }

    private static ErrorResponse ofErrors(HttpStatus status, List<ApiError> errors) {
        return new ErrorResponse(status.value(), status.getReasonPhrase(), errors);
    }

    public static ErrorResponse of(HttpStatus status, ApiError error) {
        return ofErrors(status, Collections.singletonList(error));
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class ApiError {
        private final String code;

        private final String message;

        public ApiError(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}