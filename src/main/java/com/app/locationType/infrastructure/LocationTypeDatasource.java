package com.app.locationType.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.locationType.domain.ILocationTypeRepository;
import com.app.locationType.domain.LocationType;

@Component
public class LocationTypeDatasource {

    private final ILocationTypeRepository locationTypeRepository;

    public LocationTypeDatasource(ILocationTypeRepository locationTypeRepository) {
        this.locationTypeRepository = locationTypeRepository;
    }

    public List<LocationType> findAll() {
        return locationTypeRepository.findAll();
    }
    public Optional<LocationType> findById(Long id) {
        return locationTypeRepository.findById(id);
    }

    public LocationType save(LocationType locationType) {
        return locationTypeRepository.save(locationType);
    }

    public Optional<LocationType> update(LocationType locationType, Long id) {
        return locationTypeRepository.findById(id).map(existinglocationType -> {
            existinglocationType.setId(locationType.getId());
            existinglocationType.setName(locationType.getName());
            return locationTypeRepository.save(existinglocationType);
        });
    }

    public boolean deleteById(Long id) {
        if (locationTypeRepository.existsById(id)) {
            locationTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
