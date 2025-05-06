package com.app.locationType.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationTypeRepository extends JpaRepository<LocationType, Long> {

    // Get all LocationType (already provided by JpaRepository)
    @Override
    @NonNull
    List<LocationType> findAll();

    // Search LocationType by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<LocationType> findById(@NonNull Long id);

    // Save a LocationType (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends LocationType> S save(@NonNull S LocationType);

    // Check if a user with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete user by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    // Search for a user by their name
    Optional<LocationType> findByName(String name);

    // Check if an name is already registered
    boolean existsByName(String name);
}