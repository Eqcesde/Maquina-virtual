package com.app.locationType.infrastructure;

public class LocationTypeDto {
    private Long id;
    private String name;

    // Empty constructor
    public LocationTypeDto() {
    }

    // Constructor with parameters
    public LocationTypeDto(Long id, String name) {
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

    public void seName(String name) {
        this.name = name;
    }

    // toString() method
    @Override
    public String toString() {
        return "PlaceTypeDto{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                '}';
    }
}
