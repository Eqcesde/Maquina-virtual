package com.app.search.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.search.domain.ISearchRepository;
import com.app.search.domain.ISearchService;
import com.app.search.domain.Search;
import com.app.shared.adapters.exception.ResourceNotFoundException;

@Service
public class SearchService implements ISearchService {

    private final ISearchRepository searchRepository;

    public SearchService(ISearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Override
    public List<Search> findAll() {
        return searchRepository.findAll();
    }

    @Override
    public Search findById(Long id) {
        return searchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("search not found with ID: " + id));
    }

    @Override
    @Transactional
    public Search save(Search search) {
        if (searchRepository.existsByName(search.getName())) {
            throw new IllegalArgumentException("search already exists: " + search.getName());
        }
        return searchRepository.save(search);
    }

    @Override
    @Transactional
    public Search update(Search search, Long id) {
        Search existingSearch = findById(id);
        existingSearch.setName(search.getName());
        return searchRepository.save(existingSearch);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Search search = findById(id);
        searchRepository.delete(search);
    }
}