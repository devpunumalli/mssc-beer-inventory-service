package com.dev.msscbeerinventoryservice.service;


import com.dev.brewery.model.BeerDto;
import com.dev.brewery.model.event.InventoryEvent;
import com.dev.msscbeerinventoryservice.config.JmsConfig;
import com.dev.msscbeerinventoryservice.domain.BeerInventory;
import com.dev.msscbeerinventoryservice.repositories.BeerInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryService {

    private final BeerInventoryRepository beerInventoryRepository;
    @JmsListener(destination = JmsConfig.INVENTORY_QUEUE)
    public void listenInventoryEvents(InventoryEvent event){
        log.debug("Got Inventory:" + event.toString());
        BeerDto beerDto = event.getBeerDto();
        beerInventoryRepository.save(BeerInventory.builder()
                                             .beerId(beerDto.getId()).
                        quantityOnHand(beerDto.getQuantityOnHand()).
                        upc(beerDto.getUpc()).build());


    }
}
