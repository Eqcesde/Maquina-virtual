package com.app.places.hotels.adapters;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.places.hotels.domain.Hotels;
import com.app.places.hotels.domain.IHotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final IHotelService hotelService;

    public HotelController(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<Hotels>> getAllHotels() {
        return ResponseEntity.ok(hotelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotels> getHotelById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Hotels> createHotel(@RequestBody Hotels hotel) {
        return ResponseEntity.ok(hotelService.save(hotel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotels> updateHotel(@PathVariable Long id, @RequestBody Hotels hotel) {
        return ResponseEntity.ok(hotelService.update(hotel, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
