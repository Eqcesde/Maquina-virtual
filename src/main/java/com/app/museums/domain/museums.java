package com.app.museums.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Searches")
@Data
public class Museums {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String destinationId;

    @Column(nullable = false)
    private String entryPrice;


    // Empty constructor (required for JPA)
    public Museums() {}

    // Constructor with parameters
    public Museums(Long id, String name, String entryPrice, String destinationId) {
        this.id = id;
        this.name = name;
        this.entryPrice = entryPrice;
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

    public String getentryPrice() {
        return entryPrice;
    }

    public void setentryPrice(String entryPrice) {
        this.entryPrice = entryPrice;
    }

    public String getdestinationId() {
        return this.destinationId;
    }

    public void setdestinationId(String destinationId) {
        this.destinationId = destinationId;
    }
}

