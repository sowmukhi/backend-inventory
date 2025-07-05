package com.neoteric.avoota_inventory.addhotel.service;


import com.neoteric.avoota_inventory.HotelNotFoundException;
import com.neoteric.avoota_inventory.addhotel.entity.HotelEntity;
import com.neoteric.avoota_inventory.addhotel.mapper.HotelMapper;
import com.neoteric.avoota_inventory.addhotel.model.HotelDTO;
import com.neoteric.avoota_inventory.addhotel.repo.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public HotelDTO saveHotel(HotelDTO dto) {
        log.info("Saving new hotel: {}", dto.getHotelId());

        if (dto.getHotelId() == null || dto.getHotelId().isBlank()) {
            throw new IllegalArgumentException("Hotel ID must not be null or empty");
        }

        HotelEntity hotel = new HotelEntity();
        hotel.setHotelId(dto.getHotelId());  // ✅ Use ID from client
        hotel.setHotelName(dto.getHotelName());
        hotel.setHotelAddress(dto.getHotelAddress());

        HotelEntity saved = hotelRepository.save(hotel);
        return HotelMapper.toDTO(saved);
    }


    public HotelDTO getHotel(Long id) {
        log.info("Fetching hotel by ID: {}", id);
        HotelEntity hotel = hotelRepository.findById("id")
                .orElseThrow(() -> new HotelNotFoundException("Hotel with ID " + id + " not found"));
        return HotelMapper.toDTO(hotel);
    }

    public HotelDTO updateHotel(Long id, HotelDTO dto) {
        log.info("Updating hotel with ID: {}", id);
        HotelEntity hotel = hotelRepository.findById("id")
                .orElseThrow(() -> new HotelNotFoundException("Hotel with ID " + id + " not found"));

        hotel.setHotelName(dto.getHotelName());
        hotel.setHotelAddress(dto.getHotelAddress());

        HotelEntity updated = hotelRepository.save(hotel);
        return HotelMapper.toDTO(updated);
    }

    public List<HotelEntity> getAllHotels() {
        return hotelRepository.findAll();
    }
}