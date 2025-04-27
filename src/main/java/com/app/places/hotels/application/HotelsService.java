package com.app.places.hotels.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.places.hotels.domain.Hotels;
import com.app.places.hotels.domain.IHotelService;
import com.app.places.hotels.domain.IHotelsRepository;
import com.app.shared.adapters.exception.ResourceNotFoundException;

@Service
public class HotelsService implements IHotelService {

    private final IHotelsRepository hotelRepository;

    public HotelsService(IHotelsRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotels> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotels findById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("hotel not found with ID: " + id));
    }

    @Override
    @Transactional
    public Hotels save(Hotels hotel) {
        if (hotelRepository.existsByName(hotel.getName())) {
            throw new IllegalArgumentException("hotel already exists: " + hotel.getName());
        }
        return hotelRepository.save(hotel);
    }

    @Override
    @Transactional
    public Hotels update(Hotels hotel, Long id) {
        Hotels existingHotel = findById(id);
        existingHotel.setName(hotel.getName());
        existingHotel.setLocation(hotel.getLocation());
        existingHotel.setDestinationId(hotel.getDestinationId());
        existingHotel.setPricePerNight(hotel.getPricePerNight());
        return hotelRepository.save(existingHotel);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Hotels hotel = findById(id);
        hotelRepository.delete(hotel);
    }
}
