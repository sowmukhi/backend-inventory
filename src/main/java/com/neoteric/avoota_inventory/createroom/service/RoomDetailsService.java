package com.neoteric.avoota_inventory.createroom.service;


import com.neoteric.avoota_inventory.HotelNotFoundException;

import com.neoteric.avoota_inventory.addhotel.entity.HotelEntity;
import com.neoteric.avoota_inventory.addhotel.repo.HotelRepository;
import com.neoteric.avoota_inventory.createroom.entity.RoomDetailsEntity;
import com.neoteric.avoota_inventory.createroom.model.RoomDetailsDTO;
import com.neoteric.avoota_inventory.createroom.repo.RoomDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomDetailsService {

    private final RoomDetailsRepository roomRepo;
    private final HotelRepository hotelRepo;

    public ResponseEntity<String> saveRoomDetails( RoomDetailsDTO dto) {
        log.info("Entering to saveroomdetailsservie hoteid {} , ",dto.getHotelId());
        try {


            HotelEntity hotel = hotelRepo.findById(dto.getHotelId())
                    .orElseThrow(() -> new HotelNotFoundException("Invalid hotel ID: " + dto.getHotelId()));

            RoomDetailsEntity entity = new RoomDetailsEntity();
            entity.setHotel(hotel);
            entity.setRoomType(dto.getRoomType());
            entity.setRoomView(dto.getRoomView());
            entity.setSizeUnit(dto.getSizeUnit());
            entity.setRoomSize(dto.getRoomSize());
            entity.setRoomName(dto.getRoomName());
            entity.setNumberOfRooms(dto.getNumberOfRooms());
            entity.setDescription(dto.getDescription());
            roomRepo.save(entity);
            log.info("Saved room for hotel ID = {}",dto.getHotelId());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception e) {
            log.error("Failed to save room details: {}", e.getMessage(), e);


            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<RoomDetailsDTO> getRoomDetailsById(Long roomId) {
        log.info("🔍 Entering getRoomDetailsById() for roomId = {}", roomId);

        try {
            RoomDetailsEntity entity = roomRepo.findById(roomId)
                    .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomId));

            RoomDetailsDTO dto = convertToDTO(entity);
            log.info(" Room found for ID: {}", roomId);
            return new ResponseEntity<>(dto, HttpStatus.OK);

        } catch (RuntimeException e) {
            log.warn(" Room not found: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error(" Error while fetching room details: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private RoomDetailsDTO convertToDTO(RoomDetailsEntity entity) {
        RoomDetailsDTO dto = new RoomDetailsDTO();
        dto.setRoomid(entity.getRoomId());
        dto.setHotelId(entity.getHotel().getHotelId());
        dto.setRoomName(entity.getRoomName());
        dto.setRoomType(entity.getRoomType());
        dto.setRoomView(entity.getRoomView());
        dto.setRoomSize(entity.getRoomSize());
        dto.setSizeUnit(entity.getSizeUnit());
        dto.setNumberOfRooms(entity.getNumberOfRooms());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
