package com.app.search.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.search.domain.ISearchRepository;
import com.app.search.domain.Search;

@Component
public class SearchDatasource {

    private final ISearchRepository searchRepository;

    public SearchDatasource(ISearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public List<Search> findAll() {
        return searchRepository.findAll();
    }

    public Optional<Search> findById(Long id) {
        return searchRepository.findById(id);
    }

    public Search save(Search search) {
        return searchRepository.save(search);
    }

    public Optional<Search> update(Search search, Long id) {
        return searchRepository.findById(id).map(existingSearch -> {
            existingSearch.setId(search.getId());
            existingSearch.setName(search.getName());
            return searchRepository.save(existingSearch);
        });
    }

    public boolean deleteById(Long id) {
        if (searchRepository.existsById(id)) {
            searchRepository.deleteById(id);
            return true;
        }
        return false;}
}