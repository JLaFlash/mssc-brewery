package net.laflash.msscbrewery.services.v2;

import net.laflash.msscbrewery.web.model.BeerDto;
import net.laflash.msscbrewery.web.model.v2.BeerDtoV2;
import net.laflash.msscbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2{

    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder()
                .id(beerId)
                .beerName("Galaxy Cat")
                .derStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName("Miller")
                .derStyle(BeerStyleEnum.LOGGER)
                .build();
    }

    @Override
    public void updateBeer(UUID id, BeerDtoV2 beerDto) {
        //todo impl to update beer
        log.debug(" Updated.....");
    }

    @Override
    public void daleteById(UUID id) {

        log.debug(" deleted.......");
    }
}
