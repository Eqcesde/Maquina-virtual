package com.app.destinations.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.destinations.domain.Destinations;
import com.app.destinations.domain.IDestinationService;
import com.app.destinations.domain.IDestinationsRepository;
import com.app.shared.adapters.exception.ResourceNotFoundException;

@Service
public class DestinationsService implements IDestinationService {

    private final IDestinationsRepository destinationsRepository;

    public DestinationsService(IDestinationsRepository destinationsRepository) {
        this.destinationsRepository = destinationsRepository;
    }

    @Override
    public List<Destinations> findAll() {
        return destinationsRepository.findAll();
    }

    @Override
    public Destinations findById(Long id) {
        return destinationsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with ID: " + id));
    }

    @Override
    @Transactional
    public Destinations save(Destinations destinations) {
        if (destinationsRepository.existsByName(destinations.getName())) {
            throw new IllegalArgumentException("name registred: " + destinations.getName());
        }
        return destinationsRepository.save(destinations);
    }

    @Override
    @Transactional
    public Destinations update(Destinations destinations, Long id) {
        Destinations existingdestinations = findById(id);
        existingdestinations.setName(destinations.getName());
        return destinationsRepository.save(existingdestinations);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Destinations destinations = findById(id);
        destinationsRepository.delete(destinations);
    }
}
