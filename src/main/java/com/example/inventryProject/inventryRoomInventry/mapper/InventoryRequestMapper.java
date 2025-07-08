package com.example.inventryProject.inventryRoomInventry.mapper;

import com.example.inventryProject.inventryRoomInventry.Dto.InventoryRequestDTO;
import com.example.inventryProject.inventryRoomInventry.entity.InventoryRequestEntity;

public class InventoryRequestMapper {
    public static InventoryRequestEntity toEntity(InventoryRequestDTO dto) {
        InventoryRequestEntity entity = new InventoryRequestEntity();
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setSelectedDays(dto.getSelectedDays());
        entity.setRoomQuantities(dto.getRoomQuantities());
        entity.setShowNettRate(dto.isShowNettRate());
        return entity;
    }

    public static InventoryRequestDTO toDTO(InventoryRequestEntity entity) {
        InventoryRequestDTO dto = new InventoryRequestDTO();
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setSelectedDays(entity.getSelectedDays());
        dto.setRoomQuantities(entity.getRoomQuantities());
        dto.setShowNettRate(entity.isShowNettRate());
        return dto;
    }
}
