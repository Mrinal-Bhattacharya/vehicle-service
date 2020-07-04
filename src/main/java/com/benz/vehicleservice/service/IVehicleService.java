package com.benz.vehicleservice.service;

import com.benz.vehicleservice.common.VehicleRequest;
import com.benz.vehicleservice.domain.VehicleEntity;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    List<VehicleEntity> findAll();

    List<VehicleEntity> findAllByModelYear(String modelYear);

    Optional<VehicleEntity> findByVin(final Long vin);

    List<VehicleEntity> findAllByColor(String color);

    void delete(long vin);

    VehicleEntity update(VehicleRequest vehicleRequest);

    VehicleEntity create(VehicleRequest vehicleRequest);
}
