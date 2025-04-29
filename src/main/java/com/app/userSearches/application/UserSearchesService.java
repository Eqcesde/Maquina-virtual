package com.app.userSearches.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;
import com.app.userSearches.domain.IUserSearchService;
import com.app.userSearches.domain.IUserSearchesRepository;
import com.app.userSearches.domain.UserSearches;

@Service
public class UserSearchesService implements IUserSearchService {

    private final IUserSearchesRepository usersearchesRepository;

    public UserSearchesService(IUserSearchesRepository usersearcheRepository) {
        this.usersearchesRepository = usersearcheRepository;
    }

    @Override
    public List<UserSearches> findAll() {
        return usersearchesRepository.findAll();
    }

    @Override
    public UserSearches findById(Long id) {
        return usersearchesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with ID: " + id));
    }

    @Override
    @Transactional
    public UserSearches save(UserSearches usersearches) {
        if (usersearchesRepository.existsByUserId(usersearches.getUserId())) {
            throw new IllegalArgumentException("email registred: " + usersearches.getUserId());
        }
        return usersearchesRepository.save(usersearches);
    }

    @Override
    @Transactional
    public UserSearches update(UserSearches usersearches, Long id) {
        UserSearches existingUserSearches = findById(id);
        existingUserSearches.setUserId(usersearches.getUserId());
        existingUserSearches.setSearchDate(usersearches.getSearchDate());
        existingUserSearches.setDestinationId(usersearches.getDestinationId());
        return usersearchesRepository.save(existingUserSearches);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        UserSearches usersearche = findById(id);
        usersearchesRepository.delete(usersearche);
    }
}
