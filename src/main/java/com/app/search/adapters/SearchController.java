package com.app.search.adapters;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.search.domain.ISearchService;
import com.app.search.domain.Search;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final ISearchService searchService;

    public SearchController(ISearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public ResponseEntity<List<Search>> getAllSearches() {
        return ResponseEntity.ok(searchService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Search> getSearchById(@PathVariable Long id) {
        return ResponseEntity.ok(searchService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Search> createSearch(@RequestBody Search search) {
        return ResponseEntity.ok(searchService.save(search));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Search> updateSearch(@PathVariable Long id, @RequestBody Search search) {
        return ResponseEntity.ok(searchService.update(search, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSearch(@PathVariable Long id) {
        searchService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}