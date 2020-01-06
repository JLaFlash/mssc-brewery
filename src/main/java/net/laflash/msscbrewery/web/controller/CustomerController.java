package net.laflash.msscbrewery.web.controller;

import net.laflash.msscbrewery.services.CustomerService;
import net.laflash.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerID}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name = "customerID") UUID id){
        return new ResponseEntity<CustomerDto>(customerService.getCustomer(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CustomerDto> handlePost(@Valid @RequestBody() CustomerDto customerDto){
        CustomerDto dto = customerService.saveNewCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/beer/" + dto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@PathVariable(name = "customerId") UUID id,
                                       @Valid @RequestBody() CustomerDto customerDto){
        customerService.updateCustomer(id, customerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void daleteBeer(@PathVariable(name = "customerId") UUID id){
        customerService.daleteById(id);

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
