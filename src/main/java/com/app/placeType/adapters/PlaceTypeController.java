package com.app.placeType.adapters;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.placeType.domain.PlaceType;
import com.app.placeType.domain.IPlaceTypeService;

@RestController
@RequestMapping("/api/placeType")
public class PlaceTypeController {

    private final IPlaceTypeService placeTypeService;

    public PlaceTypeController(IPlaceTypeService placeTypeService) {
        this.placeTypeService = placeTypeService;
    }

    @GetMapping
    public ResponseEntity<List<PlaceType>> getAllPlaceType() {
        return ResponseEntity.ok(placeTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceType> getPlaceTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(placeTypeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PlaceType> createPlaceType(@RequestBody PlaceType placeType) {
        return ResponseEntity.ok(placeTypeService.save(placeType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaceType> updatePlaceType(@PathVariable Long id, @RequestBody PlaceType placeType) {
        return ResponseEntity.ok(placeTypeService.update(placeType, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaceType(@PathVariable Long id) {
        placeTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
