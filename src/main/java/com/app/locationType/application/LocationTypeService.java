package com.app.locationType.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.locationType.domain.ILocationTypeRepository;
import com.app.locationType.domain.ILocationTypeService;
import com.app.locationType.domain.LocationType;
import com.app.shared.adapters.exception.ResourceNotFoundException;

@Service
public class LocationTypeService implements ILocationTypeService {

    private final ILocationTypeRepository locationTypeRepository;

    public LocationTypeService(ILocationTypeRepository locationTypeRepository) {
        this.locationTypeRepository = locationTypeRepository;
    }

    @Override
    public List<LocationType> findAll() {
        return locationTypeRepository.findAll();
    }

    @Override
    public LocationType findById(Long id) {
        return locationTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("hotel not found with ID: " + id));
    }

    @Override
    @Transactional
    public LocationType save(LocationType locationType) {
        if (locationTypeRepository.existsByName(locationType.getName())) {
            throw new IllegalArgumentException("hotel already exists: " + locationType.getName());
        }
        return locationTypeRepository.save(locationType);
    }

    @Override
    @Transactional
    public LocationType update(LocationType locationType, Long id) {
        LocationType existinglocationType = findById(id);
        existinglocationType.setName(locationType.getName());
        return locationTypeRepository.save(existinglocationType);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        LocationType locationType = findById(id);
        locationTypeRepository.delete(locationType);
    }
}
