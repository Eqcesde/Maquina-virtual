package com.app.place.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPlaceRepository extends JpaRepository<Place, String> {

    // Buscar lugares por país
    List<Place> findByCountry(String country);

    // Buscar lugar por país y ciudad exacta
    Optional<Place> findByCountryAndCity(String country, String city);

    // Buscar lugares que contengan una palabra clave en la descripción (ignorando mayúsculas/minúsculas)
    List<Place> findByDescriptionContainingIgnoreCase(String keyword);

    // Buscar lugares con un costo de transporte menor o igual a cierto valor
    List<Place> findByTransportCostLessThanEqual(Float maxCost);
}
