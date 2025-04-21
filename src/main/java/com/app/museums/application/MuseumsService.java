package com.app.museums.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.museums.domain.IMuseumsRepository;
import com.app.museums.domain.IMuseumService;
import com.app.museums.domain.Museums;

@Service
public class MuseumsService implements IMuseumService {

    private final IMuseumsRepository museumRepository;

    public MuseumsService(IMuseumsRepository museumRepository) {
        this.museumRepository = museumRepository;
    }

    @Override
    public List<Museums> findAll() {
        return museumRepository.findAll();
    }

    @Override
    public Museums findById(Long id) {
        return museumRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with ID: " + id));
    }

    @Override
    @Transactional
    public Museums save(Museums museum) {
        if (museumRepository.existsByName(museum.getName())) {
            throw new IllegalArgumentException("name registred: " + museum.getName());
        }
        return museumRepository.save(museum);
    }

    @Override
    @Transactional
    public Museums update(Museums museum, Long id) {
        Museums existingMuseum = findById(id);
        existingMuseum.setName(museum.getName());
        existingMuseum.setentryPrice(museum.getentryPrice());
        existingMuseum.setdestinationId(museum.getdestinationId());
        return museumRepository.save(existingMuseum);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Museums museum = findById(id);
        museumRepository.delete(museum);
    }
}
