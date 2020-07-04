package com.benz.vehicleservice.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class VehicleRequest {
    private String modelYear;
    private String color;
    private String details;


}
