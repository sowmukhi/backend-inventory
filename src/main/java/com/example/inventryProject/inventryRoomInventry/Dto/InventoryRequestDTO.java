package com.example.inventryProject.inventryRoomInventry.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequestDTO {

    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> selectedDays;

    private Map<String,Integer> roomQuantities;
    private  boolean showNettRate;


}
