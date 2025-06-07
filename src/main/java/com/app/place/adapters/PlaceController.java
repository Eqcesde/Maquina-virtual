package com.app.place.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.place.domain.IPlaceService;
import com.app.place.domain.Place;

@RestController
@RequestMapping("/api/place")
public class PlaceController {

    private final IPlaceService placeService;

    public PlaceController(IPlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public ResponseEntity<List<Place>> getAllPlace() {
        return ResponseEntity.ok(placeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable String id) {
        Place place = placeService.findById(id);
        return ResponseEntity.ok(place);
    }

    @PostMapping
    public ResponseEntity<Place> createPlace(@RequestBody Place place) {
        Place newPlace = placeService.save(place);
        return ResponseEntity.ok(newPlace);
    }

    // update place
    @PutMapping("/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable String id, @RequestBody Place place) {
        Place updatedPlace = placeService.update(place, id);
        return ResponseEntity.ok(updatedPlace);
    } 
    // delete place
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable String id) {
        placeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
