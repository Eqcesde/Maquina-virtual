package com.app.placeType.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.placeType.domain.IPlaceTypeRepository;
import com.app.placeType.domain.PlaceType;

@Component
public class PlaceTypeDatasource {

    private final IPlaceTypeRepository placeTypeRepository;

    public PlaceTypeDatasource(IPlaceTypeRepository placeTypeRepository) {
        this.placeTypeRepository = placeTypeRepository;
    }

    public List<PlaceType> findAll() {
        return placeTypeRepository.findAll();
    }
    public Optional<PlaceType> findById(Long id) {
        return placeTypeRepository.findById(id);
    }

    public PlaceType save(PlaceType placeType) {
        return placeTypeRepository.save(placeType);
    }

    public Optional<PlaceType> update(PlaceType placeType, Long id) {
        return placeTypeRepository.findById(id).map(existingplaceType -> {
            existingplaceType.setId(placeType.getId());
            existingplaceType.setTypeName(placeType.getTypeName());
            return placeTypeRepository.save(existingplaceType);
        });
    }

    public boolean deleteById(Long id) {
        if (placeTypeRepository.existsById(id)) {
            placeTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
