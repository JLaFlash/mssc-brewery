package net.laflash.msscbrewery.services;

import net.laflash.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(beerId)
                .beerName("Galaxy Cat")
                .derStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Miller")
                .derStyle("light")
                .build();
    }

    @Override
    public void updateBeer(UUID id, BeerDto beerDto) {
        //todo impl to update beer
    }

    @Override
    public void daleteById(UUID id) {
        log.debug("Deleting a beer....!");

    }
}
