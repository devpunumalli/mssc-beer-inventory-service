package com.dev.brewery.model.event;

import com.dev.brewery.model.BeerOrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AllocateOrderRequest
{
    private BeerOrderDto beerOrderDto;
}
