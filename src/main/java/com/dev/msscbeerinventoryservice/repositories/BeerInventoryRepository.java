package com.dev.msscbeerinventoryservice.repositories;

import com.dev.msscbeerinventoryservice.domain.BeerInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Repository
public interface BeerInventoryRepository extends JpaRepository<BeerInventory, UUID> {

    List<BeerInventory> findAllByBeerId(UUID beerId);
}
