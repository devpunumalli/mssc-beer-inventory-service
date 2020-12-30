package com.dev.msscbeerinventoryservice.service;

import com.dev.msscbeerinventoryservice.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;


public interface BeerInventoryService {


    List<BeerInventoryDto> findAllByBeerId(UUID beerId);
}
