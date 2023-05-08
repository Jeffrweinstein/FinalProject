package com.promineotech.confinedspace.service;

import java.util.List;
import com.promineotech.confinedspace.entity.SalesPerson;


public interface SalesPersonService {

//GET Sales Person
  List<SalesPerson> fetchAllSalesPerson();

//GET Sales Person by id
  List<SalesPerson> fetchSalesPersonBySalesPersonId(String salesPersonId);

//CREATE Sales Person
  SalesPerson createSalesPerson(String salesPersonId, String lastName, 
      String firstName);

//UPDATE Sales Person
  SalesPerson updateSalesPerson(String salesPersonId, String lastName, 
      String firstName);
  
//DELETE Sales Person
  void deleteSalesPerson(String salesPersonId);





}
