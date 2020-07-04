package com.benz.vehicleservice.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VehicleResponse {
    private final long vin;
    private final int modelYear;
    private final String color;
    private final String details;

}
