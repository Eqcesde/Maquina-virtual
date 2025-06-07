package com.app.place.domain;

import java.util.List;

public interface IPlaceService {
    
    List<Place> findAll();

    Place findById(String id);

    Place save(Place Place);

    Place update(Place Place, String id);

    void deleteById(String id);
}
