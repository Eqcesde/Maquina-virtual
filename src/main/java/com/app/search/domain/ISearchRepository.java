package com.app.search.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ISearchRepository extends JpaRepository<Search, Long> {

    @Override
    @NonNull
    List<Search> findAll();

    @Override
    @NonNull
    Optional<Search> findById(@NonNull Long id);

    @Override
    @NonNull
    <S extends Search> S save(@NonNull S search);

    @Override
    boolean existsById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);

    // Métodos específicos de dominio

    Optional<Search> findByName(String name);

    boolean existsByName(String name);
}