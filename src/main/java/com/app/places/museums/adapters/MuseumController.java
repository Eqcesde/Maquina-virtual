package com.app.places.museums.adapters;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.places.museums.domain.IMuseumService;
import com.app.places.museums.domain.Museums;

@RestController
@RequestMapping("/api/museums")
public class MuseumController {

    private final IMuseumService museumService;

    public MuseumController(IMuseumService museumService) {
        this.museumService = museumService;
    }

    @GetMapping
    public ResponseEntity<List<Museums>> getAllMuseums() {
        return ResponseEntity.ok(museumService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Museums> getMuseumById(@PathVariable Long id) {
        return ResponseEntity.ok(museumService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Museums> createMuseum(@RequestBody Museums museum) {
        return ResponseEntity.ok(museumService.save(museum));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Museums> updateMuseum(@PathVariable Long id, @RequestBody Museums museum) {
        return ResponseEntity.ok(museumService.update(museum, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMuseum(@PathVariable Long id) {
        museumService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
