package com.neoteric.avoota_inventory.addhotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    private String hotelId;
    private String hotelName;
    private String hotelAddress;
}