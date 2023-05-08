package com.promineotech.confinedspace.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.promineotech.confinedspace.entity.Customer;



public class DefaultVendorService implements VendorService {


    @Autowired
    private CustomerDao customerDao;
    
    //Get
    @Override
    public List<Customer> fetchAllCustomer() {
      List<Customer> customer = customerDao.fetchAllCustomer();
      return customer;
    }

    @Override
    public List<Customer> fetchCustomerByName(String customerName) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Customer createCustomer(String customerId, String customerName, String customerPhoneNumber,
        String CustomerAddress) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Customer updateCustomer(String customerId, String customerName, String customerPhoneNumber,
        String customerAddress) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public void deleteCustomer(String customerId) {
      // TODO Auto-generated method stub

    }

  }
  
  
}
