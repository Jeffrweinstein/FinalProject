package com.promineotech.confinedspace.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.promineotech.confinedspace.dao.DefaultCustomerDao.SqlParams;
import org.springframework.stereotype.Component;
import com.promineotech.confinedspace.entity.SalesPerson;
import com.promineotech.confinedspace.entity.Customer;
import com.promineotech.confinedspace.entity.Orders;

@Component
public class DefaultOrdersDao implements OrdersDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  
  @Override
  public List<Orders> fetchAllOrders() {
 // @formatter:off
    String sql = ""
        + "SELECT * FROM orders";
    //@formatter:on
   
    return jdbcTemplate.query(sql, new RowMapper<Orders>() {

      @Override
      public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return Orders.builder()
           .orderId(rs.getString("order_id"))
           .customerId(rs.getString("customer_id"))
           .salesPersonId(rs.getString("salesPerson_id"))
           .orderDate(rs.getDate("order_date"))
           .orderPerson(rs.getString("orderPerson"))
           .jobId(rs.getString("jobId"))
           .poNumber(rs.getString("poNumber"))
           .build();
        //@formatter:on
      }
    });
  }

  @Override
  public List<Orders> fetchOrdersByCustomerId(String customerId) {
  //formatter:off
    String sql = ""
        +"SELECT * FROM orders "
        +"WHERE customer_id = :customer_id";
    //formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
      @Override
      public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return Orders.builder()
           .customerId(rs.getString("customer_id"))
           .orderId(rs.getString("order_id"))
           .salesPersonId(rs.getString("salesPerson_id"))
           .orderDate(rs.getDate("order_date"))
           .orderPerson(rs.getString("orderPerson"))
           .jobId(rs.getString("jobId"))
           .poNumber(rs.getString("poNumber"))
           .build();
           
        //@formatter:on
      }
    });
  }

  

  @Override
  public Orders createOrder(String customerId, String jobId, Date orderDate, String orderPerson,
      String poNumber, String salesPersonId, String orderId) {
    SqlParams params = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    //@formatter:off
    params.sql= ""
        +"INSERT INTO orders "
        +"(customer_id, job_id, order_date, order_person, po_number, _sales_person_id, order_id) "
        +"VALUES(:customer_id, :job_id, :order_date, :order_person, :po_number, :sales_person_id, order_id)";
    //@formatter:on
    
    params.source.addValue("customer_id", customerId);
    params.source.addValue("order_id", orderId);
    params.source.addValue("order_date", orderDate);
    params.source.addValue("sales_person_id", salesPersonId);
    params.source.addValue("order_person", orderPerson);
    params.source.addValue("job_id", jobId);
    params.source.addValue("po_number", poNumber);
    
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
  
    
    // @formatter:off
    return Orders.builder()
        .customerId(customerId)
        .orderId(orderId)
        .salesPersonId(salesPersonId)
        .orderPerson(orderPerson)
        .jobId(jobId)
        .poNumber(poNumber)
        .orderDate(null)
        .build();
        //@formatter:on
  }
    class SqlParams {
      String sql;
      MapSqlParameterSource source = new MapSqlParameterSource();
    }
  
  

  @Override
  public Orders updateOrder(String customerId, String jobId, Date orderDate, String orderPerson,
      String poNumber, String salesPersonId) {
    //@formatter:off
  String sql = ""
      +"UPDATE orders "
      +"SET "
      +"customer_id = :customer_id, "
      +"order_date = :order_date, "
      +"sales_person_id = :sales_person_id, "
      +"order_person = :order_person, "
      +"job_id = :job_id, "
      +"po_number = :po_number"
      +"WHERE order_id = :order_id";
  //@formatter:on
  
  Map<String, Object> params = new HashMap<>();
  params.put("customer_id", customerId);
  params.put("order_date", orderDate); 
  params.put("sales_person_id", salesPersonId);
  params.put("job_id,", jobId);
  params.put("po_number", poNumber);
  params.put("order_person", orderPerson);
 
  
  if(jdbcTemplate.update(sql, params) == 0) {
    throw new NoSuchElementException("Could not update order");
  }
  
  //@formatter:off
  return Orders.builder()
      .customerId("customer_id")
      .orderId("order_id")
      .salesPersonId("salesPerson_id")
      .orderPerson("orderPerson")
      .jobId("jobId")
      .poNumber("poNumber")
      .build();
      //@formatter:on
      
  //@formatter:on
}


  @Override
  public void deleteOrder(String orderId) {
  //@formatter:off
    String sql = ""
        +"DELETE FROM orders "
        +"WHERE order_id = :order_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("order_id", orderId);
    
    if(jdbcTemplate.update(sql, params) == 0) {
      throw new NoSuchElementException("Could not delete order");
      }
    }
}
