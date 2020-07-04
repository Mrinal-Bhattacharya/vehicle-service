package com.benz.vehicleservice.config;

import com.benz.vehicleservice.common.ErrorResponse;
import com.benz.vehicleservice.exception.ErrorCode;
import com.benz.vehicleservice.exception.ErrorCodes;
import org.hibernate.service.spi.ServiceException;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;
import java.util.Objects;

@ControllerAdvice
public class BenzExceptionHandlerAdvice extends ResponseEntityExceptionHandler {
    private static final String NO_MESSAGE_AVAILABLE = "No message available";

    private final ErrorCodes errorCodes;

    private final MessageSource apiErrorMessageSource;

    BenzExceptionHandlerAdvice(ErrorCodes errorCodes, MessageSource apiErrorMessageSource) {
        Objects.requireNonNull(errorCodes);
        Objects.requireNonNull(apiErrorMessageSource);

        this.errorCodes = errorCodes;
        this.apiErrorMessageSource = apiErrorMessageSource;
    }

    @ExceptionHandler(ServiceException.class)
    ResponseEntity<ErrorResponse> handleExceptions(ServiceException exception, Locale locale) {
        ErrorCode errorCode = errorCodes.of(exception);
        ErrorResponse errorResponse = ErrorResponse.of(errorCode.httpStatus(), toApiError(errorCode, locale));

        return ResponseEntity.status(errorCode.httpStatus()).body(errorResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST, toApiError("BV-101", Locale.getDefault()));
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse.ApiError toApiError(ErrorCode errorCode, Locale locale) {
        String message;
        String code = errorCode.code();
        return getApiError(locale, code);
    }

    private ErrorResponse.ApiError toApiError(String errorCode, Locale locale) {
        String message;
        return getApiError(locale, errorCode);
    }

    private ErrorResponse.ApiError getApiError(final Locale locale, final String code) {
        String message;
        try {
            message = apiErrorMessageSource.getMessage(code, new Object[]{}, locale);
        } catch (NoSuchMessageException e) {
            message = NO_MESSAGE_AVAILABLE;
        }

        return new ErrorResponse.ApiError(code, message);
    }


}
