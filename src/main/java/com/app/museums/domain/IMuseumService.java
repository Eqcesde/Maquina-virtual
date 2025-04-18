package com.app.museums.domain;

import java.util.List;

public interface IMuseumService {
    List<Museums> findAll();

    Museums findById(Long id);

    Museums save(Museums museum);

    Museums update(Museums museum, Long id);

    void deleteById(Long id);
}
