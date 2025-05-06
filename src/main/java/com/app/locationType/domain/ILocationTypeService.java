package com.app.locationType.domain;

import java.util.List;

public interface ILocationTypeService {
   
    List<LocationType> findAll();

    LocationType findById(Long id);

    LocationType save(LocationType locationType);

    LocationType update(LocationType locationType, Long id);

    void deleteById(Long id);
}
