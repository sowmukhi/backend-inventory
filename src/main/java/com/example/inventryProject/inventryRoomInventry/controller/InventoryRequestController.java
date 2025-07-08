package com.example.inventryProject.inventryRoomInventry.controller;

import com.example.inventryProject.inventryRoomInventry.Dto.InventoryRequestDTO;
import com.example.inventryProject.inventryRoomInventry.service.InventoryRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
@CrossOrigin(origins = "*")
public class InventoryRequestController {
    @Autowired
    private InventoryRequestService service;

    @PostMapping("/save")
    public InventoryRequestDTO save(@RequestBody InventoryRequestDTO dto) {
        return service.saveRequest(dto);
    }

    @GetMapping("/all")
    public List<InventoryRequestDTO> getAll() {
        return service.getAllRequests();
    }

}
