package com.app.restaurants.domain;

import java.util.List;

public interface IRestaurantService {
    List<Restaurants> findAll();

    Restaurants findById(Long id);

    Restaurants save(Restaurants restaurant);

    Restaurants update(Restaurants restaurant, Long id);

    void deleteById(Long id);
}
