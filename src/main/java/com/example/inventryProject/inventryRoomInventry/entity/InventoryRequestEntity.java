package com.example.inventryProject.inventryRoomInventry.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Table(name = "room_inventory")
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private boolean showNettRate;

    @ElementCollection
    @CollectionTable(name = "selected_days", joinColumns = @JoinColumn(name = "request_id"))
    @Column(name = "day")
    private List<String> selectedDays;

    @ElementCollection
    @CollectionTable(name = "room_quantities", joinColumns = @JoinColumn(name = "request_id"))
    @MapKeyColumn(name = "room_type")
    @Column(name = "quantity")
    private Map<String, Integer> roomQuantities;
}