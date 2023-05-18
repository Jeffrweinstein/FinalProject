package com.promineotech.confinedspace.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.confinedspace.dao.CustomerDao;
import com.promineotech.confinedspace.entity.Customer;

 @Service
 public class DefaultCustomerService implements CustomerService {

  @Autowired
  private CustomerDao customerDao;
  
  //GET
  @Transactional(readOnly = true)
  @Override
  public List<Customer> fetchAllCustomer() {
    List<Customer> customer = customerDao.fetchAllCustomer();
    return customer;
  }
  //GET customer by name
  @Transactional(readOnly = true)
  @Override
  public List<Customer> fetchCustomerByName(String customerName) {
    List<Customer> customer = customerDao.fetchCustomerByName(customerName);
    return customer;
  }
  
  //POST
  @Override
  public Customer createCustomer(String customerId, String customerName, String customerPhoneNumber,
      String customerAddress) {
    return customerDao.createCustomer(customerId, customerName, customerPhoneNumber,
            customerAddress);
    
  }
  //UPDATE
  @Override
  public Customer updateCustomer(String customerId, String customerName, String customerPhoneNumber,
      String customerAddress) {
    return customerDao.updateCustomer(customerId, customerName, customerPhoneNumber,
        customerAddress);
  }

  @Override
  public void deleteCustomer(String customerId) {
    customerDao.deleteCustomer(customerId);

  }

}
