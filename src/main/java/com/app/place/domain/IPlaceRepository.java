package com.app.place.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceRepository extends JpaRepository<Place, Long> {
   
    boolean existsByName(String name);

    Optional<Place> findByName(String name);


    // Get all place (already provided by JpaRepository)
    @Override
    @NonNull
    List<Place> findAll();

    // Search place by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<Place> findById(@NonNull Long id);

    // Save a place (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends Place> S save(@NonNull S Place);

    // Check if a place with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete place by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

}