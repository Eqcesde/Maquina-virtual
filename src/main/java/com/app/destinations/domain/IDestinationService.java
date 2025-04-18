package com.app.destinations.domain;

import java.util.List;

public interface IDestinationService {

    List<Destinations> findAll();

    Destinations findById(Long id);

    Destinations save(Destinations destination);

    Destinations update(Destinations destination, Long id);

    void deleteById(Long id);
}
