package com.benz.vehicleservice.repository;

import com.benz.vehicleservice.domain.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    List<VehicleEntity> findAllByModelYear(String modelYear);

    List<VehicleEntity> findAllByColor(String color);
}
