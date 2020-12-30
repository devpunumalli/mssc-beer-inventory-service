package com.dev.msscbeerinventoryservice.controller;


import com.dev.msscbeerinventoryservice.service.BeerInventoryService;
import com.dev.msscbeerinventoryservice.model.BeerInventoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class BeerInventoryController {

    private final BeerInventoryService beerInventoryService;

    public BeerInventoryController(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }


    @GetMapping("api/v1/beer/{beerId}/inventory")
    List<BeerInventoryDto> listBeersById(@PathVariable UUID beerId) {
        log.debug("Finding Inventory for beerId:" + beerId);

        return beerInventoryService.findAllByBeerId(beerId);
    }
}
