package com.example.inventryProject.hoteld.mapper;

import com.example.inventryProject.hoteld.dto.HotelDTO;
import com.example.inventryProject.hoteld.entity.Hotel;

public class HotelMapper {

    public static HotelDTO toDTO(Hotel hotel) {
        return new HotelDTO(hotel.getHotelId(), hotel.getHotelName(), hotel.getHotelAddress());
    }

    public static Hotel toEntity(HotelDTO dto) {
        return new Hotel(dto.getHotelId(), dto.getHotelName(), dto.getHotelAddress());
    }
}
