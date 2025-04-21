package com.app.museums.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IMuseumsRepository extends JpaRepository<Museums, Long> {

    // Get all users (already provided by JpaRepository)
    @Override
    @NonNull
    List<Museums> findAll();

    // Search user by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<Museums> findById(@NonNull Long id);

    // Save a user (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends Museums> S save(@NonNull S Museums);

    // Check if a user with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete user by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    // Search for a user by their name
    Optional<Museums> findByName(String name);

    // Check if an name is already registered
    boolean existsByName(String name);
}