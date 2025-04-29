package com.app.userSearches.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.userSearches.domain.IUserSearchService;
import com.app.userSearches.domain.UserSearches;

@RestController
@RequestMapping("/api/userSearches")
public class UserSearchController {

    private final IUserSearchService userSearchService;

    public UserSearchController(IUserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }

    @GetMapping
    public ResponseEntity<List<UserSearches>> getAllUserSearches() {
        List<UserSearches> userSearches = userSearchService.findAll();
        return ResponseEntity.ok(userSearches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSearches> getUserSearchById(@PathVariable Long id) {
        UserSearches userSearch = userSearchService.findById(id);
        return ResponseEntity.ok(userSearch);
    }

    @PostMapping
    public ResponseEntity<UserSearches> createUserSearch(@RequestBody UserSearches userSearch) {
        UserSearches savedUserSearch = userSearchService.save(userSearch);
        return ResponseEntity.ok(savedUserSearch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserSearches> updateUserSearch(@PathVariable Long id, @RequestBody UserSearches userSearch) {
        UserSearches updatedUserSearch = userSearchService.update(userSearch, id);
        return ResponseEntity.ok(updatedUserSearch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserSearch(@PathVariable Long id) {
        userSearchService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
