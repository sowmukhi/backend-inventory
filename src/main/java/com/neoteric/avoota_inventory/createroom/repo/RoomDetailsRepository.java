package com.neoteric.avoota_inventory.createroom.repo;


import com.neoteric.avoota_inventory.createroom.entity.RoomDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDetailsRepository extends JpaRepository<RoomDetailsEntity,Long> {
}
