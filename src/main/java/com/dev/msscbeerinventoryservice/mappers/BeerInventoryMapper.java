package com.dev.msscbeerinventoryservice.mappers;

import com.dev.msscbeerinventoryservice.domain.BeerInventory;
import com.dev.msscbeerinventoryservice.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {
    BeerInventoryDto beerInventoryToDto(BeerInventory beerOrder);

    BeerInventory dtoToBeerInventory(BeerInventoryDto dto);
}
