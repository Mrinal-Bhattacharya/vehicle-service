package com.benz.vehicleservice.exception;

import org.springframework.stereotype.Component;

public class VehicleServiceExceptionMapper {
    @Component
    static class VehicleAlreadyExceptionToErrorCode implements ExceptionToErrorCode {
        @Override
        public boolean canHandle(Exception exception) {
            return exception instanceof VehicleAlreadyExists;
        }

        @Override
        public ErrorCode toErrorCode(Exception exception) {
            return VehicleServiceDatabaseErrorCodes.VEHICLE_ALREADY_EXISTS;
        }
    }

    @Component
    static class VehicleNotFoundExceptionToErrorCode implements ExceptionToErrorCode {
        @Override
        public boolean canHandle(Exception exception) {
            return exception instanceof VehicleNotFoundException;
        }

        @Override
        public ErrorCode toErrorCode(Exception exception) {
            return VehicleServiceDatabaseErrorCodes.VEHICLE_NOT_FOUND;
        }
    }
}
