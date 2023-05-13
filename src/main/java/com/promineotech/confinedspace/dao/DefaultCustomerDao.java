package com.promineotech.confinedspace.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.promineotech.confinedspace.entity.Customer;


@Component

public class DefaultCustomerDao implements CustomerDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Customer> fetchAllCustomer() {
    //@formatter:off
    String sql = ""
        + "SELECT "
        + "FROM customer";
    
    //@formatter:on
    return jdbcTemplate.query(sql, new RowMapper<Customer>() {
      
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
          return Customer.builder()
              .customerId(rs.getString("customer_id"))
              .customerName(rs.getString("customer_name"))
              .customerAddress(rs.getString("customer_address"))
              .customerPhoneNumber(rs.getString("customer_phone_number"))
              .build();

        }
    });
    
  }
        
    

  @Override
  public List<Customer> fetchCustomerByName(String customerName) {
    String sql = ""
        +"SELECT * FROM customer "
        +"WHERE customer_Name = :customer_name";
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_name", customerName);
   return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
      @Override
      public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return Customer.builder()
           .customerId(rs.getString("customer_id"))
           .customerName(rs.getString("customer_name"))
           .customerAddress(rs.getString("customer_address"))
           .customerPhoneNumber(rs.getString("customer_phone_number"))
           .build();
        //@formatter:on
      }
    });
  }
  @Override
  public Customer createCustomer(String customerId, String customerName, String customerPhoneNumber,
      String customerAddress) {
    SqlParams params = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    //@formatter:off
    params.sql= ""
        +"INSERT INTO customer "
        +"(customer_id, customer_name, customer_address, customer_phone_number) "
        +"VALUES (:customer_id, :customer_name, :customer_address, :customer_phone_number)";
    //@formatter:on
    
    params.source.addValue("customer_id", customerId);
    params.source.addValue("customer_name", customerName);
    params.source.addValue("customer_address", customerAddress);
    params.source.addValue("customer_phone_number", customerPhoneNumber);
    
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    
    
 // @formatter:off
    return Customer.builder()
        .customerId(customerId)
        .customerName(customerName)
        .customerAddress(customerAddress)
        .customerPhoneNumber(customerPhoneNumber)
        .build();
     //@formatter:on
    
  }
  
  //Need this to implement the create method
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

    
  

  @Override
  public Customer updateCustomer(String customerId, String customerName, String customerPhoneNumber,
      String customerAddress) {
  //@formatter::off
      String sql = ""
        +"UPDATE customer "
        +"SET "
        +"customer_name = :customer_name, "
        +"customer_address = :customer_address "
        +"customer_phone_number = :customer_phone_number, " 
        +"WHERE customer_id = :customer_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    params.put("customer_name", customerName);
    params.put("customer_address", customerAddress);
    params.put("customer_phone_number", customerPhoneNumber);   
    
    if(jdbcTemplate.update(sql, params) == 0) {
      
      throw new NoSuchElementException("Could not update employee info");
  }
  
  //@formatter:off
  return Customer.builder()
      .customerId(customerId)
      .customerName(customerName)
      .customerAddress(customerAddress)
      .customerPhoneNumber(customerPhoneNumber)
      .build();
  //@formatter:on
}

  @Override
  public void deleteCustomer(String customerId) {
  //@formatter:off
    String sql = ""
        +"DELETE FROM customer "
        +"WHERE customer_id = :customer_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    
    if(jdbcTemplate.update(sql, params) == 0) {
      throw new NoSuchElementException("Could not delete customer");
    }
  }

}
