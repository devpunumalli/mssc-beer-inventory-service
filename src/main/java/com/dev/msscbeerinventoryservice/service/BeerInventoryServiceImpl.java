package com.dev.msscbeerinventoryservice.service;

import com.dev.msscbeerinventoryservice.repositories.BeerInventoryRepository;
import com.dev.msscbeerinventoryservice.mappers.BeerInventoryMapper;
import com.dev.msscbeerinventoryservice.model.BeerInventoryDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BeerInventoryServiceImpl implements BeerInventoryService {

    private final BeerInventoryRepository beerInventoryRepository;
    private final BeerInventoryMapper beerInventoryMapper;

    public BeerInventoryServiceImpl(BeerInventoryRepository beerInventoryRepository, BeerInventoryMapper beerInventoryMapper) {
        this.beerInventoryRepository = beerInventoryRepository;
        this.beerInventoryMapper = beerInventoryMapper;
    }

    @Override
    public List<BeerInventoryDto> findAllByBeerId(UUID beerId) {
        return beerInventoryRepository.findAllByBeerId(beerId)
                .stream()
                .map(beerInventoryMapper::beerInventoryToDto)
                .collect(Collectors.toList());
    }
}
