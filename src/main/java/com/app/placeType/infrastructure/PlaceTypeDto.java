package com.app.placeType.infrastructure;

public class PlaceTypeDto {
    private Long id;
    private String typeName;

    // Empty constructor
    public PlaceTypeDto() {
    }

    // Constructor with parameters
    public PlaceTypeDto(Long id, String typeName) {
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


    // toString() method
    @Override
    public String toString() {
        return "PlaceTypeDto{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
