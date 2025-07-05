package com.neoteric.avoota_inventory.createroom.model;


import com.neoteric.avoota_inventory.createroom.entity.SizeUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDetailsDTO {
    private Long roomid;
    private String roomType;
    private String roomView;
    private int roomSize;
    private SizeUnit sizeUnit;
    private String roomName;
    private int numberOfRooms;
    private String description;
   private String hotelId;
//    private List<RatePlanDTo> ratePlanDToList;

}
