package com.app.place.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.place.domain.IPlaceRepository;
import com.app.place.domain.IPlaceService;
import com.app.place.domain.Place;
import com.app.shared.adapters.exception.ResourceNotFoundException;

@Service
public class PlaceService implements IPlaceService {

    private final IPlaceRepository placeRepository;

    public PlaceService(IPlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    @Override
    public Place findById(Long id) {
        return placeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("place not found with ID: " + id));
    }

    @Override
    @Transactional
    public Place save(Place place) {
        if (placeRepository.existsByName(place.getCountry())) {
            throw new IllegalArgumentException("Name registred: " + place.getCountry());
        }
        return placeRepository.save(place);
    }

    @Override
    @Transactional
    public Place update(Place place, Long id) {
        Place existingplace = findById(id);
        existingplace.setCountry(place.getCountry());
        return placeRepository.save(existingplace);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Place place = findById(id);
        placeRepository.delete(place);
    }
}
