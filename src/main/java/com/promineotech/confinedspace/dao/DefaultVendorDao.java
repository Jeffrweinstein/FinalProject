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
import com.promineotech.confinedspace.entity.Vendor;

@Component
public class DefaultVendorDao implements VendorDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  
  @Override
  public List<Vendor> fetchAllVendor() {
    //@formatter:off
    String sql = ""
        + "SELECT "
        + "FROM vendor";
    
    //@formatter:on
    
    return jdbcTemplate.query(sql, new RowMapper <Vendor>() {
      
      @Override
      public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Vendor.builder()
            .vendorId(rs.getString("vendor_id"))
            .vendorName(rs.getString("vendor_name"))
            .vendorAddress(rs.getString("vendor_address"))
            .vendorPhoneNumber(rs.getString("vendor_phone_number"))
            .build();

      }
  });
  
}
    

  @Override
  public List<Vendor> fetchVendorByName(String vendorName) {
    String sql = ""
        +"SELECT * FROM vendor "
        +"WHERE vendor_Name = :vendor_name";
    
    Map<String, Object> params = new HashMap<>();
    params.put("vendor_name", vendorName);
   return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
      @Override
      public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return Vendor.builder()
           .vendorId(rs.getString("vendor_id"))
           .vendorName(rs.getString("vendor_name"))
           .vendorAddress(rs.getString("vendor_address"))
           .vendorPhoneNumber(rs.getString("vendor_phone_number"))
           .build();
        //@formatter:on
      }
    });
  }
  @Override
  public Vendor createVendor(String vendorId, String vendorName, String vendorPhoneNumber,
      String vendorAddress) {
     
    SqlParams params = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    //@formatter:off
    params.sql= ""
        +"INSERT INTO vendor "
        +"(vendor_id, vendor_name, vendor_address, vendor_phone_number) "
        +"VALUES (:vendor_id, :vendor_name, :vendor_address, :vendor_phone_number)";
    //@formatter:on
    
    params.source.addValue("vendor_id", vendorId);
    params.source.addValue("vendor_name", vendorName);
    params.source.addValue("vendor_address", vendorAddress);
    params.source.addValue("vendor_phone_number", vendorPhoneNumber);
    
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    
    
 // @formatter:off
    return Vendor.builder()
        .vendorId(vendorId)
        .vendorName(vendorName)
        .vendorAddress(vendorAddress)
        .vendorPhoneNumber(vendorPhoneNumber)
        .build();
     //@formatter:on
    
  }
  
  //Need this to implement the create method
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  

    
  }
  @Override
  public Vendor updateVendor(String vendorId, String vendorName, String vendorPhoneNumber,
      String vendorAddress) {//@formatter::off
      String sql = ""
        +"UPDATE vendor "
        +"SET "
        +"vendor_name = :vendor_name, "
        +"vendor_address = :vendor_address "
        +"vendor_phone_number = :vendor_phone_number, " 
        +"WHERE vendor_id = :vendor_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("vendor_id", vendorId);
    params.put("vendor_name", vendorName);
    params.put("vendor_address", vendorAddress);
    params.put("vendor_phone_number", vendorPhoneNumber);   
    
    if(jdbcTemplate.update(sql, params) == 0) {
      
      throw new NoSuchElementException("Could not update employee info");
  }
  
  //@formatter:off
  return Vendor.builder()
      .vendorId(vendorId)
      .vendorName(vendorName)
      .vendorAddress(vendorAddress)
      .vendorPhoneNumber(vendorPhoneNumber)
      .build();
  //@formatter:on
    
  }

  @Override
  public void deleteVendor(String vendorId) {
    //@formatter:off
    String sql = ""
        +"DELETE FROM vendor "
        +"WHERE vendor_id = :vendor_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("vendor_id", vendorId);
    
    if(jdbcTemplate.update(sql, params) == 0) {
      throw new NoSuchElementException("Could not delete vendor");
    }
  }

}