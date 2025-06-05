package com.app.place.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Place")
@Data
public class Place {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(length = 1000)
    private String description;

    @Lob
    private String food;

    @Lob
    private String beaches;

    @Lob
    private String hotels;

    private Float transportCost;

    @Lob
    private String weather;

    @Lob
    private String sites;

    @Lob
    private String dates;

    // Empty constructor (required for JPA)
    public Place() {
    }

    // Constructor with all fields
    public Place(String id, String country, String city, String description, String food, String beaches,
            String hotels, Float transportCost, String weather, String sites, String dates) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.description = description;
        this.food = food;
        this.beaches = beaches;
        this.hotels = hotels;
        this.transportCost = transportCost;
        this.weather = weather;
        this.sites = sites;
        this.dates = dates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getBeaches() {
        return beaches;
    }

    public void setBeaches(String beaches) {
        this.beaches = beaches;
    }

    public String getHotels() {
        return hotels;
    }

    public void setHotels(String hotels) {
        this.hotels = hotels;
    }

    public Float getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(Float transportCost) {
        this.transportCost = transportCost;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getSites() {
        return sites;
    }

    public void setSites(String sites) {
        this.sites = sites;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

}