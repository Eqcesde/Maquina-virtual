package com.app.locationType.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "LocationType")
@Data
public class LocationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    
    // Empty constructor (required for JPA)
    public LocationType() {}

    // Constructor con parámetros
    public LocationType(Long id, String name) {
        this.id = id;
        this.name = name;
        
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
}

