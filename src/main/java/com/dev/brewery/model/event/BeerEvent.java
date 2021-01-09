package com.dev.brewery.model.event;


import com.dev.brewery.model.BeerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BeerEvent implements Serializable
{

    static final long serialVersionUID= -9020656274974724762L;
private BeerDto beerDto;


}
