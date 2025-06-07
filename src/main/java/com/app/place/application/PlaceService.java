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
public Place findById(String id) {
    return placeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Place not found with ID: " + id));
}

@Override
@Transactional
public Place save(Place place) {
    // Verifica si ya existe un lugar con el mismo país y ciudad
    if (placeRepository.findByCountryAndCity(place.getCountry(), place.getCity()).isPresent()) {
        throw new IllegalArgumentException("Ya existe un lugar registrado con ese país y ciudad.");
    }

    return placeRepository.save(place);
}


    @Override
    @Transactional
    public Place update(Place place, String id) {
        Place existingplace = findById(id);
        existingplace.setCountry(place.getCountry());
        return placeRepository.save(existingplace);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        Place place = findById(id);
        placeRepository.delete(place);
    }
}
