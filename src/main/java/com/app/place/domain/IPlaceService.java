package com.app.place.domain;

import java.util.List;

public interface IPlaceService {
    
    List<Place> findAll();

    Place findById(Long id);

    Place save(Place place);

    Place update(Place place, Long id);

    void deleteById(Long id);
}
