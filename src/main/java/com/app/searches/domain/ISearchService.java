package com.app.searches.domain;

import java.util.List;

public interface ISearchService {
    List<Searches> findAll();

    Searches findById(Long id);

    Searches save(Searches searche);

    Searches update(Searches searche, Long id);

    void deleteById(Long id);
}

