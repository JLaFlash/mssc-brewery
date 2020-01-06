package net.laflash.msscbrewery.web.mappers;

import net.laflash.msscbrewery.domain.Customer;
import net.laflash.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);
}
