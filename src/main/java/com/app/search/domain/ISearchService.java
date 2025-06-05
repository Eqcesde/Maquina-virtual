package com.app.search.domain;

import java.util.List;

public interface ISearchService {

    List<Search> findAll();

    Search findById(Long id);

    Search save(Search search);

    Search update(Search search, Long id);

    void deleteById(Long id);
}