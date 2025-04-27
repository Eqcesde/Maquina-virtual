package com.app.user_searches.adapters;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.user_searches.domain.ISearchService;
import com.app.user_searches.domain.Searches;

@RestController
@RequestMapping("/api/searches")
public class SearchController {

    private final ISearchService searchService;

    public SearchController(ISearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public ResponseEntity<List<Searches>> getAllSearches() {
        return ResponseEntity.ok(searchService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Searches> getSearchById(@PathVariable Long id) {
        return ResponseEntity.ok(searchService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Searches> createSearch(@RequestBody Searches search) {
        return ResponseEntity.ok(searchService.save(search));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Searches> updateSearch(@PathVariable Long id, @RequestBody Searches search) {
        return ResponseEntity.ok(searchService.update(search, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSearch(@PathVariable Long id) {
        searchService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
