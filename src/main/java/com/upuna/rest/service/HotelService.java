package com.upuna.rest.service;

import com.upuna.rest.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();

    Hotel createNewHotel(Hotel hotel);

    Hotel getHotelById(Long hotelId);

    void deleteHotelById(Long hotelId);
}
