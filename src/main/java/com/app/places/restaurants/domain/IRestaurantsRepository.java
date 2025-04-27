package com.app.places.restaurants.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantsRepository extends JpaRepository<Restaurants, Long> {

    // Get all users (already provided by JpaRepository)
    @Override
    @NonNull
    List<Restaurants> findAll();

    // Search user by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<Restaurants> findById(@NonNull Long id);

    // Save a user (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends Restaurants> S save(@NonNull S restaurant);

    // Check if a user with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete user by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    // Search for a user by their name
    Optional<Restaurants> findByName(String name);

    // Check if an name is already registered
    boolean existsByName(String name);
}