package com.app.places.hotels.domain;

import java.util.List;

public interface IHotelService {
   
    List<Hotels> findAll();

    Hotels findById(Long id);

    Hotels save(Hotels hotel);

    Hotels update(Hotels hotel, Long id);

    void deleteById(Long id);
}
