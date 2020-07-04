package com.benz.vehicleservice.service;

import com.benz.vehicleservice.common.VehicleRequest;
import com.benz.vehicleservice.domain.VehicleEntity;
import com.benz.vehicleservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<VehicleEntity> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<VehicleEntity> findAllByModelYear(String modelYear) {
        return vehicleRepository.findAllByModelYear(modelYear);
    }

    @Override
    public Optional<VehicleEntity> findByVin(final Long vin) {
        return vehicleRepository.findById(vin);
    }

    @Override
    public List<VehicleEntity> findAllByColor(String color) {
        return vehicleRepository.findAllByColor(color);
    }

    @Override
    public void delete(final long vin) {
        vehicleRepository.deleteById(vin);
    }

    @Override
    public VehicleEntity update(final VehicleRequest vehicleRequest) {
        return null;
    }

    @Override
    public VehicleEntity create(final VehicleRequest vehicleRequest) {
        return null;
    }
}
