package com.promineotech.confinedspace.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.confinedspace.entity.Customer;
import com.promineotech.confinedspace.entity.dto.CustomerDto;
import com.promineotech.confinedspace.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCustomerController implements CustomerController {

  @Autowired
  private CustomerService customerService;
  
  @Override
  public List<Customer> fetchCustomers() {
    
    return customerService.fetchAllCustomer();
  }
 
  
  //Gets customer by name
  @Override
  public List<Customer> fetchCustomerByName(String customerName) {
    return customerService.fetchCustomerByName(customerName);
  }
  
  //Creates customer
  @Override
  public Customer createCustomer(@Valid CustomerDto customerDto) {
    return customerService.createCustomer
        (customerDto.getCustomerId(), customerDto.getCustomerName(),
        customerDto.getCustomerAddress(), customerDto.getCustomerPhoneNumber());
  }
  //Updates customer
  @Override
  public Customer updateCustomer(@Valid CustomerDto customerDto) {
    return customerService.updateCustomer
        (customerDto.getCustomerId(), customerDto.getCustomerName(),
            customerDto.getCustomerAddress(), customerDto.getCustomerPhoneNumber());
   
  }

  @Override
  public void deleteCustomer(@Valid CustomerDto customerDto) {
      log.debug("Customer ID Deleted = {}", customerDto.getCustomerId());
      customerService.deleteCustomer(customerDto.getCustomerId());

  }

 

}
