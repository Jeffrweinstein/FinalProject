package com.promineotech.confinedspace.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.confinedspace.entity.Customer;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultCustomerDao implements CustomerDao {

  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Customer> fetchAllCustomer() {
   // @formatter:off
    String sql = ""
        + "SELECT * FROM customer";
    //@formatter:on
    
    return jdbcTemplate.query(sql, newRowMapper<Customer>(() {
      


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
  public void deleteCustomer(int customerId) {
    // TODO Auto-generated method stub
    
  }
}
