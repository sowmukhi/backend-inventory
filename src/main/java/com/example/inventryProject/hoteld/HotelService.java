package com.example.inventryProject.hoteld;

import com.example.inventryProject.hoteld.dto.HotelDTO;
import com.example.inventryProject.hoteld.entity.Hotel;
import com.example.inventryProject.hoteld.excepation.HotelNotFoundException;
import com.example.inventryProject.hoteld.mapper.HotelMapper;
import com.example.inventryProject.hoteld.repository.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public HotelDTO saveHotel(HotelDTO dto) {
        Hotel existingHotel = hotelRepository.findById(dto.getHotelId()).orElse(null);

        if (existingHotel != null) {
            // Update
            existingHotel.setHotelName(dto.getHotelName());
            existingHotel.setHotelAddress(dto.getHotelAddress());
            Hotel updated = hotelRepository.save(existingHotel);
            return HotelMapper.toDTO(updated);
        } else {
            // Create
            Hotel saved = hotelRepository.save(HotelMapper.toEntity(dto));
            return HotelMapper.toDTO(saved);
        }
    }

    public HotelDTO getHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel with ID " + id + " not found"));
        return HotelMapper.toDTO(hotel);
    }

    public HotelDTO updateHotel(Long id, HotelDTO dto) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel with ID " + id + " not found"));

        hotel.setHotelName(dto.getHotelName());
        hotel.setHotelAddress(dto.getHotelAddress());

        Hotel updated = hotelRepository.save(hotel);
        return HotelMapper.toDTO(updated);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
