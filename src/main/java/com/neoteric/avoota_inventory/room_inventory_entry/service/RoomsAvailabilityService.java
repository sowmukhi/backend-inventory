package com.neoteric.avoota_inventory.room_inventory_entry.service;

import com.neoteric.avoota_inventory.room_inventory_entry.entity.RoomsAvailabilityEntity;
import com.neoteric.avoota_inventory.room_inventory_entry.model.RoomAvailabilityDTO;
import com.neoteric.avoota_inventory.room_inventory_entry.model.SaveInventoryRequest;
import com.neoteric.avoota_inventory.room_inventory_entry.repository.RoomsAvailabilityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomsAvailabilityService {
    private final RoomsAvailabilityRepository availabilityRepository;

    public void saveInventory(SaveInventoryRequest request) {
        log.info("Received inventory request: {}", request);

        // Validate input
        if (request.getHotelId() == null || request.getFromDate() == null || request.getToDate() == null) {
            log.error("Hotel ID, fromDate, or toDate is null");
            throw new IllegalArgumentException("Hotel ID, from date, and to date are required.");
        }

        if (request.getFromDate().isAfter(request.getToDate())) {
            log.error("Invalid date range: fromDate {} is after toDate {}", request.getFromDate(), request.getToDate());
            throw new IllegalArgumentException("From date cannot be after to date.");
        }

        if (request.getRooms() == null || request.getRooms().isEmpty()) {
            log.error("No room availability data provided.");
            throw new IllegalArgumentException("Room availability list cannot be empty.");
        }

        // Construct entities
        List<RoomsAvailabilityEntity> entities = new ArrayList<>();

        for (RoomAvailabilityDTO room : request.getRooms()) {
            if (room.getRoomId() == null || room.getRoomName() == null) {
                log.warn("Skipping room with missing roomId or roomName: {}", room);
                continue;
            }

            for (LocalDate date = request.getFromDate(); !date.isAfter(request.getToDate()); date = date.plusDays(1)) {
                RoomsAvailabilityEntity entity = new RoomsAvailabilityEntity();
                entity.setHotelId(request.getHotelId());
                entity.setRoomId(room.getRoomId());
                entity.setRoomName(room.getRoomName());
                entity.setDate(date);
                entity.setAvailableCount(room.getAvailableCount());

                entities.add(entity);
            }
        }

        log.info("Prepared {} availability records for saving.", entities.size());

        availabilityRepository.saveAll(entities);

        log.info("Successfully saved {} records for hotel ID {}", entities.size(), request.getHotelId());
    }
}
