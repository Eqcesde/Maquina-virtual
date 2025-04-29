package com.app.placeType.domain;

import java.util.List;

public interface IPlaceTypeService {
   
    List<PlaceType> findAll();

    PlaceType findById(Long id);

    PlaceType save(PlaceType placeType);

    PlaceType update(PlaceType placeType, Long id);

    void deleteById(Long id);
}
