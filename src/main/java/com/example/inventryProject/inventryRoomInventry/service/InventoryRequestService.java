package com.example.inventryProject.inventryRoomInventry.service;

import com.example.inventryProject.inventryRoomInventry.Dto.InventoryRequestDTO;
import com.example.inventryProject.inventryRoomInventry.entity.InventoryRequestEntity;
import com.example.inventryProject.inventryRoomInventry.mapper.InventoryRequestMapper;
import com.example.inventryProject.inventryRoomInventry.repository.InventoryRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InventoryRequestService  {

    @Autowired
    private InventoryRequestRepository repository;

    public InventoryRequestDTO saveRequest(InventoryRequestDTO dto) {
        log.info("Saving Inventory Request: {}", dto);
        InventoryRequestEntity entity = InventoryRequestMapper.toEntity(dto);
        InventoryRequestEntity saved = repository.save(entity);
        log.debug("Saved with ID: {}", saved.getId());
        return InventoryRequestMapper.toDTO(saved);
    }

    public List<InventoryRequestDTO> getAllRequests() {
        log.info("Fetching all inventory requests");
        return repository.findAll().stream()
                .map(InventoryRequestMapper::toDTO)
                .collect(Collectors.toList());
    }


}
