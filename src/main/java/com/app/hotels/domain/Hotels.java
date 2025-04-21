package com.app.hotels.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Hotels")
@Data
public class Hotels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false, unique = true)
    private String destinationId;

    @Column(nullable = false)
    private Double pricePerNight;

    // Empty constructor (required for JPA)
    public Hotels() {}

    // Constructor con parámetros
    public Hotels(Long id, String name, String location, Double pricePerNight, String destinationId) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.pricePerNight = pricePerNight;
        this.destinationId = destinationId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDestinationId() {
        return this.destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void getPricePerNight(Double pricePerNight){
        this.pricePerNight = pricePerNight;
    }

}

