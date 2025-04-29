package com.app.userSearches.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserSearchesRepository extends JpaRepository<UserSearches, Long> {

    // Get all users (already provided by JpaRepository)
    @Override
    @NonNull
    List<UserSearches> findAll();

    // Search user by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<UserSearches> findById(@NonNull Long id);

    // Save a user (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends UserSearches> S save(@NonNull S UserSearches);

    // Check if a user with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete user by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    // Search for a user by their userId
    Optional<UserSearches> findByUserId(String userId);

    // Check if an userId is already registered
    boolean existsByUserId(String userId);
}