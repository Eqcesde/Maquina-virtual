package com.app.destinations.adapters;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.destinations.domain.Destinations;
import com.app.destinations.domain.IDestinationService;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    private final IDestinationService destinationService;

    public DestinationController(IDestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    public ResponseEntity<List<Destinations>> getAllDestinations() {
        List<Destinations> destinations = destinationService.findAll();
        return ResponseEntity.ok(destinations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destinations> getDestinationById(@PathVariable Long id) {
        Destinations destination = destinationService.findById(id);
        return ResponseEntity.ok(destination);
    }

    @PostMapping
    public ResponseEntity<Destinations> createDestination(@RequestBody Destinations destination) {
        Destinations newDestination = destinationService.save(destination);
        return ResponseEntity.ok(newDestination);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destinations> updateDestination(@PathVariable Long id, @RequestBody Destinations destination) {
        Destinations updatedDestination = destinationService.update(destination, id);
        return ResponseEntity.ok(updatedDestination);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Long id) {
        destinationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
