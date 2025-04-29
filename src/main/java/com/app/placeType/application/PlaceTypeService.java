package com.app.placeType.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.placeType.domain.PlaceType;
import com.app.placeType.domain.IPlaceTypeService;
import com.app.placeType.domain.IPlaceTypeRepository;
import com.app.shared.adapters.exception.ResourceNotFoundException;

@Service
public class PlaceTypeService implements IPlaceTypeService {

    private final IPlaceTypeRepository placeTypeRepository;

    public PlaceTypeService(IPlaceTypeRepository placeTypeRepository) {
        this.placeTypeRepository = placeTypeRepository;
    }

    @Override
    public List<PlaceType> findAll() {
        return placeTypeRepository.findAll();
    }

    @Override
    public PlaceType findById(Long id) {
        return placeTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("hotel not found with ID: " + id));
    }

    @Override
    @Transactional
    public PlaceType save(PlaceType placeType) {
        if (placeTypeRepository.existsByName(placeType.getTypeName())) {
            throw new IllegalArgumentException("hotel already exists: " + placeType.getTypeName());
        }
        return placeTypeRepository.save(placeType);
    }

    @Override
    @Transactional
    public PlaceType update(PlaceType placeType, Long id) {
        PlaceType existingPlaceType = findById(id);
        existingPlaceType.setTypeName(placeType.getTypeName());
        return placeTypeRepository.save(existingPlaceType);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        PlaceType placeType = findById(id);
        placeTypeRepository.delete(placeType);
    }
}
