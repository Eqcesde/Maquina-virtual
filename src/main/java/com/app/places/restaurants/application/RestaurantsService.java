package com.app.places.restaurants.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.places.restaurants.domain.IRestaurantService;
import com.app.places.restaurants.domain.IRestaurantsRepository;
import com.app.places.restaurants.domain.Restaurants;
import com.app.shared.adapters.exception.ResourceNotFoundException;

@Service
public class RestaurantsService implements IRestaurantService {

    private final IRestaurantsRepository restaurantRepository;

    public RestaurantsService(IRestaurantsRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurants> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurants findById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with ID: " + id));
    }

    @Override
    @Transactional
    public Restaurants save(Restaurants restaurant) {
        if (restaurantRepository.existsByName(restaurant.getName())) {
            throw new IllegalArgumentException("name registred: " + restaurant.getName());
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    @Transactional
    public Restaurants update(Restaurants restaurant, Long id) {
        Restaurants existingRestaurant = findById(id);
        existingRestaurant.setName(restaurant.getName());
        existingRestaurant.setCuisineType(restaurant.getCuisineType());
        existingRestaurant.setDestinationId(restaurant.getDestinationId());
        existingRestaurant.setAveragePrice(restaurant.getAveragePrice());
        return restaurantRepository.save(existingRestaurant);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Restaurants restaurant = findById(id);
        restaurantRepository.delete(restaurant);
    }
}
