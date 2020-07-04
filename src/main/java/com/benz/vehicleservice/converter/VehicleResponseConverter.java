package com.benz.vehicleservice.converter;

import com.benz.vehicleservice.common.VehicleResponse;
import com.benz.vehicleservice.domain.VehicleEntity;
import com.benz.vehicleservice.exception.VehicleNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VehicleResponseConverter {
    public ResponseEntity<List<VehicleResponse>> convert(final List<VehicleEntity> all) {
        return ResponseEntity.ok(all.stream().map(e -> new VehicleResponse(e.getVin(), e.getModelYear(), e.getColor(), e.getDetails())).collect(Collectors.toList()));
    }

    public ResponseEntity<VehicleResponse> convert(final Optional<VehicleEntity> optionalVehicleEntity) {
        VehicleEntity vehicleEntity = optionalVehicleEntity.orElseThrow(VehicleNotFoundException::new);
        return ResponseEntity.ok(new VehicleResponse(vehicleEntity.getVin(), vehicleEntity.getModelYear(), vehicleEntity.getColor(), vehicleEntity.getDetails()));
    }

    public ResponseEntity<VehicleResponse> convert(VehicleEntity vehicleEntity) {
        return ResponseEntity.ok(new VehicleResponse(vehicleEntity.getVin(), vehicleEntity.getModelYear(), vehicleEntity.getColor(), vehicleEntity.getDetails()));
    }
}
