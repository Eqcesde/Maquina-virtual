package com.app.restaurants.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Restaurants")
@Data
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String destinationId;

    @Column(nullable = false)
    private String cuisineType;

    @Column(nullable = false)
    private String averagePrice ;

   

    // Empty constructor (required for JPA)
    public Restaurants() {}

    // Constructor with parameters
    public Restaurants(Long id, String name, String cuisineType, String destinationId, String averagePrice) {
        this.id = id;
        this.name = name;
        this.cuisineType = cuisineType;
        this.destinationId = destinationId;
        this.averagePrice  = averagePrice ;
        
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

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getDestinationId() {
        return this.destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getAveragePrice () {
        return this.averagePrice ;
    }

    public void setAveragePrice (String averagePrice ) {
        this.averagePrice  = averagePrice ;
    }

  
}

