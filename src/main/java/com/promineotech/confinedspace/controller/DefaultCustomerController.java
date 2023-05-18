package com.promineotech.confinedspace.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.confinedspace.entity.Customer;
import com.promineotech.confinedspace.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCustomerController implements CustomerController {

  @Autowired
  private CustomerService customerService;
  
  //GET all customers
  @Override
  public List<Customer> fetchCustomers() {
    
    return customerService.fetchAllCustomer();
  }
 
  
  //GET customer by name
  @Override
  public List<Customer> fetchCustomerByName(String customerName) {
    return customerService.fetchCustomerByName(customerName);
  }
  
  //CREATE/POST a new customer
  @Override
  public Customer createCustomer(@Valid Customer customerDto) {
    return customerService.createCustomer
        (customerDto.getCustomerId(), customerDto.getCustomerName(),
        customerDto.getCustomerAddress(), customerDto.getCustomerPhoneNumber());
  }
  //UPDATE/PUT a customer
  @Override
  public Customer updateCustomer(@Valid Customer customerDto) {
    return customerService.updateCustomer
        (customerDto.getCustomerId(), customerDto.getCustomerName(),
            customerDto.getCustomerAddress(), customerDto.getCustomerPhoneNumber());
   
  }
  //DELETE a customer
  @Override
  public void deleteCustomer(@Valid Customer customer) {
      log.debug("Customer ID Deleted = {}", customer.getCustomerId());
      customerService.deleteCustomer(customer.getCustomerId());

  }

 

}
