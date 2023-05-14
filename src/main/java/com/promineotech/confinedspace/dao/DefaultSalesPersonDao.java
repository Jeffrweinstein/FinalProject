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
import com.promineotech.confinedspace.entity.SalesPerson;

@Component

public class DefaultSalesPersonDao implements SalesPersonDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;


  @Override
  public List<SalesPerson> fetchAllSalesPerson() {
  //@formatter:off
    String sql = ""
        + "SELECT "
        + "FROM sales_person";
    
    //@formatter:on
    return jdbcTemplate.query(sql, new RowMapper<SalesPerson>() {
      
        @Override
        public SalesPerson mapRow(ResultSet rs, int rowNum) throws SQLException {
          return SalesPerson.builder()
              .salesPersonId(rs.getString("sales_person_id"))
              .lastName(rs.getString("last_name"))
              .firstName(rs.getString("first_name"))
              .build();

        }
    });
    
  }

  @Override
  public List<SalesPerson> fetchSalesPersonById(String salesPersonId) {
    String sql = ""
        +"SELECT * FROM sales_person "
        +"WHERE sales_Person_Id = :sales_person_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("sales_person_id", salesPersonId);
   return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
      @Override
      public SalesPerson mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return SalesPerson.builder()
           .salesPersonId(rs.getString("sales_person_id"))
           .lastName(rs.getString("last_name"))
           .firstName(rs.getString("first_name"))
           .build();
        //@formatter:on
      }
    });
  }
   @Override
   public SalesPerson createSalesPerson(String salesPersonId, String lastName, String firstName) {
     SqlParams params = new SqlParams();
     KeyHolder keyHolder = new GeneratedKeyHolder();
     
     //@formatter:off
     params.sql= ""
         +"INSERT INTO sales_person "
         +"(sales_person_id, last_name, first_name) "
         +"VALUES (:sales_person_id, :last_name, :first_name)";
     //@formatter:on
     
     params.source.addValue("sales_person_id", salesPersonId);
     params.source.addValue("last_name", lastName);
     params.source.addValue("first_name", firstName);
     
     
     jdbcTemplate.update(params.sql, params.source, keyHolder);
     
     
     
  // @formatter:off
     return SalesPerson.builder()
         .salesPersonId(salesPersonId)
         .lastName(lastName)
         .firstName(firstName)
         .build();
      //@formatter:on
     
   }
   
   //Need this to implement the create method
   class SqlParams {
     String sql;
     MapSqlParameterSource source = new MapSqlParameterSource();
   }

     
   

   @Override
   public SalesPerson updateSalesPerson(String salesPersonId, String lastName, String firstName) {
   //@formatter::off
       String sql = ""
         +"UPDATE sales_person "
         +"SET "
         +"last_name = :last_name, "
         +"fist_name = :first_name"
         +"WHERE sales_person_id = :sales_person_id";
     //@formatter:on
     
     Map<String, Object> params = new HashMap<>();
     params.put("sales_person_id", salesPersonId);
     params.put("last_name", lastName);
     params.put("first_name", firstName);  
     
     if(jdbcTemplate.update(sql, params) == 0) {
       
       throw new NoSuchElementException("Could not update employee info");
   }
   
   //@formatter:off
   return SalesPerson.builder()
       .salesPersonId(salesPersonId)
       .lastName(lastName)
       .firstName(firstName)
       .build();
   //@formatter:on
 }

   @Override
   public void deleteSalesPerson(String salesPersonId) {
   //@formatter:off
     String sql = ""
         +"DELETE FROM sales_person "
         +"WHERE sales_person_id = :sales_person_id";
     //@formatter:on
     
     Map<String, Object> params = new HashMap<>();
     params.put("sales_person_id", salesPersonId);
     
     if(jdbcTemplate.update(sql, params) == 0) {
       throw new NoSuchElementException("Could not delete sales person");
     }
   }

 }


 
  
