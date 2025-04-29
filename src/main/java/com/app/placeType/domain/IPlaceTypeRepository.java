package com.app.placeType.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceTypeRepository extends JpaRepository<PlaceType, Long> {

    // Get all PlaceType (already provided by JpaRepository)
    @Override
    @NonNull
    List<PlaceType> findAll();

    // Search PlaceType by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<PlaceType> findById(@NonNull Long id);

    // Save a PlaceType (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends PlaceType> S save(@NonNull S PlaceType);

    // Check if a user with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete user by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    // Search for a user by their name
    Optional<PlaceType> findByName(String name);

    // Check if an name is already registered
    boolean existsByName(String name);
}