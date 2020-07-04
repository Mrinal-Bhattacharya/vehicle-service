package com.benz.vehicleservice.exception;

public class VehicleAlreadyExists extends RuntimeException {
    public VehicleAlreadyExists(final String s) {
        super(s);
    }
}
