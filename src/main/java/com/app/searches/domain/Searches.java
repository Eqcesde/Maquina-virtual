package com.app.searches.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Searches")
@Data
public class Searches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false, unique = true)
    private String destinationId;

    @Column(nullable = false)
    private String searchDate;


    // Empty constructor (required for JPA)
    public Searches() {}

    // Constructor with parameters
    public Searches(Long id, String userId, String searchDate, String destinationId, String tourist_flow, String description) {
        this.id = id;
        this.userId = userId;
        this.searchDate = searchDate;
        this.destinationId = destinationId;
        
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }

    public String getDestinationId() {
        return this.destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }
}

