package com.app.places.restaurants.adapters;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.places.restaurants.domain.IRestaurantService;
import com.app.places.restaurants.domain.Restaurants;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final IRestaurantService restaurantService;

    public RestaurantController(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<List<Restaurants>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurants> getRestaurantById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Restaurants> createRestaurant(@RequestBody Restaurants restaurant) {
        return ResponseEntity.ok(restaurantService.save(restaurant));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurants> updateRestaurant(@PathVariable Long id, @RequestBody Restaurants restaurant) {
        return ResponseEntity.ok(restaurantService.update(restaurant, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
