package com.app.placeType.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PlaceType")
@Data
public class PlaceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String typeName;

    
    // Empty constructor (required for JPA)
    public PlaceType() {}

    // Constructor con parámetros
    public PlaceType(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
        
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}

