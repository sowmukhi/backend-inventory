package com.neoteric.avoota_inventory.addhotel.repo;

import com.neoteric.avoota_inventory.addhotel.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity,String> {
}
