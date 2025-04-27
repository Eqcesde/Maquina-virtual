package com.app.user_searches.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;
import com.app.user_searches.domain.ISearchService;
import com.app.user_searches.domain.ISearchesRepository;
import com.app.user_searches.domain.Searches;

@Service
public class SearchesService implements ISearchService {

    private final ISearchesRepository searcheRepository;

    public SearchesService(ISearchesRepository searcheRepository) {
        this.searcheRepository = searcheRepository;
    }

    @Override
    public List<Searches> findAll() {
        return searcheRepository.findAll();
    }

    @Override
    public Searches findById(Long id) {
        return searcheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with ID: " + id));
    }

    @Override
    @Transactional
    public Searches save(Searches searche) {
        if (searcheRepository.existsByUserId(searche.getUserId())) {
            throw new IllegalArgumentException("email registred: " + searche.getUserId());
        }
        return searcheRepository.save(searche);
    }

    @Override
    @Transactional
    public Searches update(Searches searche, Long id) {
        Searches existingSearche = findById(id);
        existingSearche.setUserId(searche.getUserId());
        existingSearche.setSearchDate(searche.getSearchDate());
        existingSearche.setDestinationId(searche.getDestinationId());
        return searcheRepository.save(existingSearche);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Searches searche = findById(id);
        searcheRepository.delete(searche);
    }
}
