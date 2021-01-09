package com.dev.msscbeerinventoryservice.mappers;

import com.dev.msscbeerinventoryservice.domain.BeerInventory;
import com.dev.msscbeerinventoryservice.domain.BeerInventory.BeerInventoryBuilder;
import com.dev.msscbeerinventoryservice.model.BeerInventoryDto;
import com.dev.msscbeerinventoryservice.model.BeerInventoryDto.BeerInventoryDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-01T21:19:46-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.9.1 (Amazon.com Inc.)"
)
@Component
public class BeerInventoryMapperImpl implements BeerInventoryMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerInventoryDto beerInventoryToDto(BeerInventory beerOrder) {
        if ( beerOrder == null ) {
            return null;
        }

        BeerInventoryDtoBuilder beerInventoryDto = BeerInventoryDto.builder();

        beerInventoryDto.id( beerOrder.getId() );
        beerInventoryDto.createdDate( dateMapper.asOffsetDateTime( beerOrder.getCreatedDate() ) );
        beerInventoryDto.lastModifiedDate( dateMapper.asOffsetDateTime( beerOrder.getLastModifiedDate() ) );
        beerInventoryDto.beerId( beerOrder.getBeerId() );
        beerInventoryDto.quantityOnHand( beerOrder.getQuantityOnHand() );

        return beerInventoryDto.build();
    }

    @Override
    public BeerInventory dtoToBeerInventory(BeerInventoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        BeerInventoryBuilder beerInventory = BeerInventory.builder();

        beerInventory.id( dto.getId() );
        beerInventory.createdDate( dateMapper.asTimestamp( dto.getCreatedDate() ) );
        beerInventory.lastModifiedDate( dateMapper.asTimestamp( dto.getLastModifiedDate() ) );
        beerInventory.beerId( dto.getBeerId() );
        beerInventory.quantityOnHand( dto.getQuantityOnHand() );

        return beerInventory.build();
    }
}
