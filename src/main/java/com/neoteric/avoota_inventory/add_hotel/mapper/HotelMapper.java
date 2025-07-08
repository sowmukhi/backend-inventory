package com.neoteric.avoota_inventory.add_hotel.mapper;

import com.neoteric.avoota_inventory.add_hotel.entity.HotelEntity;
import com.neoteric.avoota_inventory.add_hotel.model.HotelDTO;
import com.neoteric.avoota_inventory.create_room.mapper.RoomMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    private final ModelMapper modelMapper;

    public HotelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public HotelDTO toDto(HotelEntity hotelEntity) {
        return modelMapper.map(hotelEntity, HotelDTO.class);
    }

    public HotelEntity toEntity(HotelDTO hotelDTO) {
        return modelMapper.map(hotelDTO, HotelEntity.class);
    }
}
