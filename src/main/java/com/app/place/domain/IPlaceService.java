package com.app.place.domain;

import java.util.List;

public interface IPlaceService {
    
    List<Place> findAll();

    Place findById(Long id);

    Place save(Place Place);

    Place update(Place Place, Long id);

    void deleteById(Long id);
}
