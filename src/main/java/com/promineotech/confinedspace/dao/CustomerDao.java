package com.promineotech.confinedspace.dao;

import java.util.List;
import com.promineotech.confinedspace.entity.Customer;

public interface CustomerDao {

//GET
  List<Customer> fetchAllCustomer();

  //GET
  List<Customer> fetchCustomerByName(String customerName);

  //POST
  Customer createCustomer(String customerId, String customerName, 
      String customerPhoneNumber, String CustomerAddress);

  //PUT

  Customer updateCustomer(String customerId, String customerName, String customerPhoneNumber,
      String customerAddress);
  
  //DELETE

  void deleteCustomer(String customerId);



}

