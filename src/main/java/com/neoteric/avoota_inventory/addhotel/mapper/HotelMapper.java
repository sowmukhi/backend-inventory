package com.neoteric.avoota_inventory.addhotel.mapper;


import com.neoteric.avoota_inventory.addhotel.entity.HotelEntity;
import com.neoteric.avoota_inventory.addhotel.model.HotelDTO;

public class HotelMapper {

    public static HotelDTO toDTO(HotelEntity hotel) {
        if (hotel == null) return null;

        return new HotelDTO(
                hotel.getHotelId(),       // ✅ use real ID from entity
                hotel.getHotelName(),
                hotel.getHotelAddress()
        );
    }

    public static HotelEntity toEntity(HotelDTO dto) {
        if (dto == null) return null;

        return new HotelEntity(
                dto.getHotelId(),         // ✅ use real ID from DTO
                dto.getHotelName(),
                dto.getHotelAddress(),
                null // rooms field not mapped
        );
    }
}
