package com.neoteric.avoota_inventory.createroom.controller;


import com.neoteric.avoota_inventory.createroom.model.RoomDetailsDTO;
import com.neoteric.avoota_inventory.createroom.service.RoomDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
@Slf4j
public class RoomDetailsController {

    private final RoomDetailsService roomService;

    @PostMapping("/hotel")
    public ResponseEntity<String> createRoom(

            @RequestBody RoomDetailsDTO roomDetailsDTO) {
        log.info("Received hotelId = {}", roomDetailsDTO.getHotelId());
        return   roomService.saveRoomDetails( roomDetailsDTO);

    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomDetailsDTO> getRoomById(@PathVariable Long roomId) {
        log.info(" GET Request for Room ID: {}", roomId);
        return roomService.getRoomDetailsById(roomId);
    }
}
