package net.laflash.msscbrewery.web.controller.v2;

import net.laflash.msscbrewery.services.v2.BeerServiceV2;
import net.laflash.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable(name = "beerId" ) UUID beerId){

        return new ResponseEntity<BeerDtoV2>(beerService.getBeerById(beerId), HttpStatus.OK);

    }

    @PostMapping("/")
    public ResponseEntity<BeerDtoV2> handlePost(@Valid @RequestBody() BeerDtoV2 beerDto){
        BeerDtoV2 newbeerDto = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/beer/" + newbeerDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable(name = "beerId") UUID id,
                                       @Valid @RequestBody() BeerDtoV2 beerDto){
        beerService.updateBeer(id, beerDto);

        return new  ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void daleteBeer(@PathVariable(name = "beerId") UUID id){
        beerService.daleteById(id);

    }

    // Added as A Controler advice --> MvcExceptionHandler.class
//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException e){
//        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
//
//        e.getConstraintViolations().forEach(constraintViolation -> {
//            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
//        });
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
}
