package com.benz.vehicleservice.exception;

import org.springframework.http.HttpStatus;

enum VehicleServiceDatabaseErrorCodes implements ErrorCode {

    VEHICLE_ALREADY_EXISTS("BV-01", HttpStatus.BAD_REQUEST), VEHICLE_NOT_FOUND("BV-02", HttpStatus.NOT_FOUND);

    private final String code;
    private final HttpStatus httpStatus;

    VehicleServiceDatabaseErrorCodes(String code, HttpStatus httpStatus) {
        this.code = code;
        this.httpStatus = httpStatus;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public HttpStatus httpStatus() {
        return httpStatus;
    }
}
