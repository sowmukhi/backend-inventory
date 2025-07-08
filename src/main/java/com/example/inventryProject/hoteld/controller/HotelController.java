package com.example.inventryProject.hoteld.controller;

import com.example.inventryProject.hoteld.dto.HotelDTO;
import com.example.inventryProject.hoteld.entity.Hotel;
import com.example.inventryProject.hoteld.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin("*")
@Slf4j
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/save")
    public ResponseEntity<HotelDTO> saveHotel(@RequestBody HotelDTO hotelDTO) {
        return ResponseEntity.ok(hotelService.saveHotel(hotelDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getHotel(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.getHotel(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelDTO> updateHotel(@PathVariable Long id, @RequestBody HotelDTO hotelDTO) {
        return ResponseEntity.ok(hotelService.updateHotel(id, hotelDTO));
    }

    @GetMapping("/hotels")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }
}
