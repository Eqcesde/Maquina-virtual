package com.app.destinations.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.destinations.domain.IDestinationsRepository;
import com.app.destinations.domain.Destinations;

@Component
public class DestinationDatasource {

    private final IDestinationsRepository destinationRepository;

    public DestinationDatasource(IDestinationsRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<Destinations> findAll() {
        return destinationRepository.findAll();
    }
    public Optional<Destinations> findById(Long id) {
        return destinationRepository.findById(id);
    }

    public Destinations save(Destinations destination) {
        return destinationRepository.save(destination);
    }

    public Optional<Destinations> update(Destinations destination, Long id) {
        return destinationRepository.findById(id).map(existingDestination-> {
            existingDestination.setName(destination.getName());
            existingDestination.setCountry(destination.getCountry());
            return destinationRepository.save(existingDestination);
        });
    }

    public boolean deleteById(Long id) {
        if (destinationRepository.existsById(id)) {
        destinationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
