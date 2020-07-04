package com.benz.vehicleservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class VehicleEntity extends BaseEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private long vin;

    @Column(name = "modelYear", nullable = false)
    private int modelYear;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "details", nullable = false)
    private String details;


}
