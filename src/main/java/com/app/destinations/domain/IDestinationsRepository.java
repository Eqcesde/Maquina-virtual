package com.app.destinations.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IDestinationsRepository extends JpaRepository<Destinations, Long> {

    // Get all destinations (already provided by JpaRepository)
    @Override
    @NonNull
    List<Destinations> findAll();

    // Search destination by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<Destinations> findById(@NonNull Long id);

    // Save a destination (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends Destinations> S save(@NonNull S destination);

    // Check if a destination with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete destination by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    // Search for a destination by its name
    Optional<Destinations> findByName(String name);

    // Check if a name is already registered
    boolean existsByName(String name);

    // Search for destinations by country
    List<Destinations> findByCountry(String country);

    // Search for destinations by climate
    List<Destinations> findByClimate(String climate);

    // Search for destinations by cuisine type
    List<Destinations> findByCuisineType(String cuisineType);

    // Search for destinations by place type ID
    List<Destinations> findByPlaceTipeId(String placeTipeId);
}
