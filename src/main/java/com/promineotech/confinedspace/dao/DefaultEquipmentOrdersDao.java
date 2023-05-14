package com.promineotech.confinedspace.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.confinedspace.entity.EquipmentOrders;
import com.promineotech.confinedspace.entity.Orders;

@Component
public class DefaultEquipmentOrdersDao implements EquipmentOrdersDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<EquipmentOrders> fetchAllEquipmentOrders() {
 // @formatter:off
    String sql = ""
        + "SELECT * FROM equipment_orders";
    //@formatter:on
   
    return jdbcTemplate.query(sql, new RowMapper<EquipmentOrders>() {

      @Override
      public EquipmentOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return EquipmentOrders.builder()
           .orderId(rs.getString("order_id"))
           .equipmentId(rs.getString("equipment_id"))
           .quantity(rs.getInt("quantity"))
           .build();
        //@formatter:on
      }
    });
  }

}