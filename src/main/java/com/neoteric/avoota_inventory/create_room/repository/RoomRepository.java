package com.neoteric.avoota_inventory.create_room.repository;

import com.neoteric.avoota_inventory.create_room.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    List<RoomEntity> findByHotelHotelId(Long hotelId);

//    @Query("SELECT r FROM RoomEntity r JOIN FETCH r.hotel WHERE r.hotel.hotelId = :hotelId")
//    List<RoomEntity> findAllByHotelIdWithHotel(@Param("hotelId") Long hotelId);

}
