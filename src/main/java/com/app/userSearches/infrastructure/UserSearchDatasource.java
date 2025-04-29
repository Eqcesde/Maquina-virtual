package com.app.userSearches.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.userSearches.domain.IUserSearchesRepository;
import com.app.userSearches.domain.UserSearches;

@Component
public class UserSearchDatasource {

    private final IUserSearchesRepository userSearchRepository;

    public UserSearchDatasource(IUserSearchesRepository userSearchRepository) {
        this.userSearchRepository = userSearchRepository;
    }

    public List<UserSearches> findAll() {
        return userSearchRepository.findAll();
    }

    public Optional<UserSearches> findById(Long id) {
        return userSearchRepository.findById(id);
    }

    public UserSearches save(UserSearches userSearch) {
        return userSearchRepository.save(userSearch);
    }

    public Optional<UserSearches> update(UserSearches userSearch, Long id) {
        return userSearchRepository.findById(id).map(existingUserSearch -> {
            existingUserSearch.setUserId(userSearch.getUserId());
            existingUserSearch.setDestinationId(userSearch.getDestinationId());
            return userSearchRepository.save(existingUserSearch);
        });
    }

    public boolean deleteById(Long id) {
        if (userSearchRepository.existsById(id)) {
            userSearchRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
