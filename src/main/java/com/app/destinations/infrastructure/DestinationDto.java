package com.app.destinations.infrastructure;

// import javax.print.attribute.standard.Destination;

public class DestinationDto {
    private Long id;
    private String name;
    private String country;
    private String climate;
    private String touristFlow;
    private String description;
    private String placeTipeId;
    private String averagePrice;
    private String cuisineType;
    private String entryPrice;

    // Empty constructor
    public DestinationDto() {
    }

    // Constructor with parameters
    public DestinationDto(Long id, String name, String country, String climate, String touristFlow, String description, String placeTipeId, String averagePrice, String cuisineType, String entryPrice) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.climate = climate;
        this.touristFlow = touristFlow;
        this.description = description;
        this.placeTipeId = placeTipeId;
        this.averagePrice = averagePrice;
        this.cuisineType = cuisineType;
        this.entryPrice = entryPrice;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getClimate() {
        return this.climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTouristFlow() {
        return this.touristFlow;
    }

    public void setTouristFlow(String touristFlow) {
        this.touristFlow = touristFlow;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPlaceTipeId() {
        return this.placeTipeId;
    }

    public void setPlaceTipeId(String placeTipeId) {
        this.placeTipeId = placeTipeId;
    }

    public String getAveragePrice() {
        return this.averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getCuisineType() {
        return this.cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public void setentryPrice(String entryPrice) {
        this.entryPrice = entryPrice;
    }

    public String getentryPrice() {
        return this.entryPrice;
    }

    // toString() method
    @Override
    public String toString() {
        return "DestinationDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ". country='" + country + '\'' +
                ", climate='" + climate + '\'' +
                ". touristFlow='" + touristFlow + '\'' +
                ". description='" + description + '\'' +
                ". placeTipeId='" + placeTipeId + '\'' +
                ". averagePrice='" + averagePrice + '\'' +
                ". cuisineType='" + cuisineType + '\'' +
                ". entryPrice='" + entryPrice + '\'' +
                '}';
    }
}
