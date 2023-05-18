package com.promineotech.confinedspace.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.confinedspace.entity.SalesPerson;
import com.promineotech.confinedspace.service.SalesPersonService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@Service
public class DefaultSalesPersonController implements SalesPersonController {

 
  private SalesPersonService salesPersonService;
  
  //GET all sales people
  @Override
  public List<SalesPerson> fetchAllSalesPerson() {
    
    return salesPersonService.fetchAllSalesPerson();
  }
 
  //GET sales person by sales person id
  @Override
  public List<SalesPerson> fetchSalesPersonById(String salesPersonId) {
   
    return salesPersonService.fetchSalesPersonBySalesPersonId(salesPersonId);
  }
  
  //CREATE/POST new sales person
  @Override
  public SalesPerson createSalesPerson(@Valid SalesPerson salesPerson) {
    return salesPersonService.updateSalesPerson(salesPerson.getSalesPersonId(), 
        salesPerson.getLastName(),salesPerson.getFirstName());
  }
  //UPDATE/PUT a sales person
  @Override
  public SalesPerson updateSalesPerson(@Valid SalesPerson salesPerson) {
    return salesPersonService.updateSalesPerson(salesPerson.getSalesPersonId(),
    salesPerson.getLastName(), salesPerson.getLastName());
  }
  //DELETE a sales person
  @Override
  public void deleteSalesPerson(@Valid SalesPerson salesPersonDto) {
    log.debug("Sales Person ID Deleted = {}", salesPersonDto.getSalesPersonId());
    salesPersonService.deleteSalesPerson(salesPersonDto.getSalesPersonId());

  }

}
