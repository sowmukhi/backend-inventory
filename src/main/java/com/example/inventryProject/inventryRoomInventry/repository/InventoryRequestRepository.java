package com.example.inventryProject.inventryRoomInventry.repository;

import com.example.inventryProject.inventryRoomInventry.entity.InventoryRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRequestRepository extends JpaRepository<InventoryRequestEntity,Long> {
}
