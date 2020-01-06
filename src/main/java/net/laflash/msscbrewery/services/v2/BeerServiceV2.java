package net.laflash.msscbrewery.services.v2;

import net.laflash.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {


    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

    void updateBeer(UUID id, BeerDtoV2 beerDto);

    void daleteById(UUID id);
}
