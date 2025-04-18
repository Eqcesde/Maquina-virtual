package com.app.searches.domain;

import java.util.List;

public interface ISearchService {
    List<Searches> findAll();

    Searches findById(Long id);

    Searches save(Searches search);

    Searches update(Searches search, Long id);

    void deleteById(Long id);
}
