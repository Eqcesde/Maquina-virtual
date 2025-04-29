package com.app.userSearches.domain;

import java.util.List;

public interface IUserSearchService {
    List<UserSearches> findAll();

    UserSearches findById(Long id);

    UserSearches save(UserSearches searche);

    UserSearches update(UserSearches searche, Long id);

    void deleteById(Long id);
}

