package net.laflash.msscbrewery.services;

import net.laflash.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomer(UUID id) {
        return CustomerDto.builder().id(id)
                .name("Jody LaFlash")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Jody LaFlash").build();
    }

    @Override
    public void updateCustomer(UUID id, CustomerDto customerDto) {
        //todo impl to update beer
        log.debug("Updated customer");
    }

    @Override
    public void daleteById(UUID id) {
        log.debug("Deleted customer");
    }
}
