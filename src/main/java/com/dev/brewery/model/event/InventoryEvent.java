package com.dev.brewery.model.event;


import com.dev.brewery.model.BeerDto;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class InventoryEvent extends BeerEvent{
    public InventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
