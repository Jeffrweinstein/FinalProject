package com.promineotech.confinedspace.service;

import java.util.List;
import com.promineotech.confinedspace.entity.Customer;

public interface CustomerService {

  //GET Customers
  List<Customer> fetchAllCustomer();

  //GET Customers by name
  List<Customer> fetchCustomerByName(String customerName);

  //CREATE Customers
  Customer createCustomer(String customerId, String customerName, 
      String customerPhoneNumber, String customerAddress);

  //UPDATE Customers 
  
  Customer updateCustomer(String customerId, String customerName, 
      String customerPhoneNumber, String customerAddress);
  
  //DELETE Customers
  void deleteCustomer(String customerId);





}



