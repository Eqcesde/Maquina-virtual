package com.app.locationType.adapters;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.locationType.domain.ILocationTypeService;
import com.app.locationType.domain.LocationType;

@RestController
@RequestMapping("/api/locationType")
public class LocationTypeController {

    private final ILocationTypeService locationTypeService;

    public LocationTypeController(ILocationTypeService locationTypeService) {
        this.locationTypeService = locationTypeService;
    }

    @GetMapping
    public ResponseEntity<List<LocationType>> getAllLocationType() {
        return ResponseEntity.ok(locationTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationType> getLocationTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(locationTypeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<LocationType> createLocationType(@RequestBody LocationType locationType) {
        return ResponseEntity.ok(locationTypeService.save(locationType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationType> updateLocationType(@PathVariable Long id, @RequestBody LocationType locationType) {
        return ResponseEntity.ok(locationTypeService.update(locationType, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocationType(@PathVariable Long id) {
        locationTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
