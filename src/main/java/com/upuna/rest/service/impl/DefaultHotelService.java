package com.upuna.rest.service.impl;

import com.upuna.rest.exception.BadRequestException;
import com.upuna.rest.exception.ElementNotFoundException;
import com.upuna.rest.model.Hotel;
import com.upuna.rest.repository.HotelRepository;
import com.upuna.rest.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultHotelService implements HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    DefaultHotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel createNewHotel(Hotel hotel) {
        if (hotel.getId() != null) {
            throw new BadRequestException("The ID must not be provided when creating a new Hotel");
        }

        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new ElementNotFoundException("Could not find hotel with ID provided"));
    }

    @Override
    public void deleteHotelById(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ElementNotFoundException("Could not find hotel with ID provided"));
        hotel.setDeleted(true);
        hotelRepository.save(hotel);
    }
}
