package com.dev.msscbeerinventoryservice.service;

import com.dev.brewery.model.BeerOrderDto;

public interface AllocationService {

    Boolean allocateOrder(BeerOrderDto beerOrderDto);
}
