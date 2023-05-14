package com.promineotech.confinedspace.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.confinedspace.entity.Equipment;
import com.promineotech.confinedspace.entity.EquipmentGroup;
import com.promineotech.confinedspace.entity.EquipmentSize;
import com.promineotech.confinedspace.entity.EquipmentType;

@Component

public class DefaultEquipmentDao implements EquipmentDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Equipment> fetchEquipment() {
 // @formatter:off
    String sql = ""
        + "SELECT * FROM equipment";
 // @formatter:on
    
    return jdbcTemplate.query(sql, new RowMapper<Equipment>() {
    
      @Override
      public Equipment mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return Equipment.builder()
           .equipmentId(rs.getString("equipment_id"))
           .size(EquipmentSize.valueOf(rs.getString("size")))
           .group(EquipmentGroup.valueOf(rs.getString("group")))
           .type(EquipmentType.valueOf(rs.getString("type")))
           .price(new BigDecimal(rs.getString("price")))
           .build();
        //@formatter:on
      }
    });
  }
}
    
  