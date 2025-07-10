package com.neoteric.avoota_inventory.room_inventory_entry.controller;

import com.neoteric.avoota_inventory.room_inventory_entry.model.SaveInventoryRequest;
import com.neoteric.avoota_inventory.room_inventory_entry.service.RoomsAvailabilityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class RoomsAvailabilityController {
    private final RoomsAvailabilityService availabilityService;

    @PostMapping("/saveRoomsAvailability")
    public ResponseEntity<String> saveInventory(@RequestBody SaveInventoryRequest request) {
        log.info("API: POST /saveRoomsAvailability triggered");

        try {
            availabilityService.saveInventory(request);
            return ResponseEntity.ok("Inventory saved successfully.");
        } catch (IllegalArgumentException ex) {
            log.error("Validation error: {}", ex.getMessage());
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Unexpected error: ", ex);
            return ResponseEntity.internalServerError().body("Internal Server Error occurred.");
        }
    }
}
