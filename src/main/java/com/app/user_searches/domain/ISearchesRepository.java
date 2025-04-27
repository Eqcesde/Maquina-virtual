package com.app.user_searches.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ISearchesRepository extends JpaRepository<Searches, Long> {

    // Get all users (already provided by JpaRepository)
    @Override
    @NonNull
    List<Searches> findAll();

    // Search user by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<Searches> findById(@NonNull Long id);

    // Save a user (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends Searches> S save(@NonNull S Searches);

    // Check if a user with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete user by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    // Search for a user by their userId
    Optional<Searches> findByUserId(String userId);

    // Check if an userId is already registered
    boolean existsByUserId(String userId);
}