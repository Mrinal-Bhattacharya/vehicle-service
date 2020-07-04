package com.benz.vehicleservice.controller;

import com.benz.vehicleservice.common.VehicleRequest;
import com.benz.vehicleservice.common.VehicleResponse;
import com.benz.vehicleservice.converter.VehicleResponseConverter;
import com.benz.vehicleservice.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/api")
public class VehicleServiceController {

    @Autowired
    private VehicleServiceImpl vehicleService;

    @Autowired
    private VehicleResponseConverter vehicleResposeConverter;

    @GetMapping("/vehicle")
    public ResponseEntity<List<VehicleResponse>> getAll() {
        return vehicleResposeConverter.convert(vehicleService.findAll());
    }

    @GetMapping("/vehicle/{vin}")
    public ResponseEntity<VehicleResponse> getVehicle(@PathVariable(value = "vin") long vin) {
        return vehicleResposeConverter.convert(vehicleService.findByVin(vin));
    }

    @GetMapping(value = "/vehicle", params = "modelYear")
    public ResponseEntity<List<VehicleResponse>> getByModelYear(@RequestParam(value = "modelYear") String modelYear) {
        return vehicleResposeConverter.convert(vehicleService.findAllByModelYear(modelYear));
    }

    @GetMapping(value = "/vehicle", params = "color")
    public ResponseEntity<List<VehicleResponse>> getByColor(@RequestParam(value = "color") String color) {
        return vehicleResposeConverter.convert(vehicleService.findAllByColor(color));
    }

    @PostMapping("/vehicle")
    public ResponseEntity<VehicleResponse> create(@Valid @RequestBody VehicleRequest vehicleRequest) {
        return vehicleResposeConverter.convert(vehicleService.create(vehicleRequest));
    }

    @PutMapping("/vehicle")
    public ResponseEntity<VehicleResponse> update(@Valid @RequestBody VehicleRequest vehicleRequest) {
        return vehicleResposeConverter.convert(vehicleService.update(vehicleRequest));
    }
}
