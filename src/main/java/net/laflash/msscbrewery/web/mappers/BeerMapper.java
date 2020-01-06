package net.laflash.msscbrewery.web.mappers;

import net.laflash.msscbrewery.domain.Beer;
import net.laflash.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
