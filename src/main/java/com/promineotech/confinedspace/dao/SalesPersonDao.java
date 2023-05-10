package com.promineotech.confinedspace.dao;

import java.util.List;
import com.promineotech.confinedspace.entity.SalesPerson;

public interface SalesPersonDao {

//GET
  List<SalesPerson> fetchAllSalesPerson();

  //GET
  List<SalesPerson> fetchSalesPersonById(String salesPersonId);

  //POST
  SalesPerson createSalesPerson(String salesPersonId, String lastName, 
      String firstName);

  //PUT

  SalesPerson updateSalesPerson(String salesPersonId, String lastName, 
      String firstName);
  
  //DELETE

  void deleteSalesPerson(String SalesPersonId);



}
  

