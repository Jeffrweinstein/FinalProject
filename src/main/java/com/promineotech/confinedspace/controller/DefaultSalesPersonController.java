package com.promineotech.confinedspace.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.confinedspace.entity.SalesPerson;
import com.promineotech.confinedspace.entity.dto.SalesPersonDto;
import com.promineotech.confinedspace.service.SalesPersonService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
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
  public SalesPerson createSalesPerson(@Valid SalesPersonDto salesPersonDto) {
    return salesPersonService.updateSalesPerson(salesPersonDto.getSalesPersonId(), 
        salesPersonDto.getLastName(),salesPersonDto.getFirstName());
  }
  //UPDATE/PUT a sales person
  @Override
  public SalesPerson updateSalesPerson(@Valid SalesPersonDto salesPersonDto) {
    return salesPersonService.updateSalesPerson(salesPersonDto.getSalesPersonId(),
    salesPersonDto.getLastName(), salesPersonDto.getLastName());
  }
  //DELETE a sales person
  @Override
  public void deleteSalesPerson(@Valid SalesPersonDto salesPersonDto) {
    log.debug("Sales Person ID Deleted = {}", salesPersonDto.getSalesPersonId());
    salesPersonService.deleteSalesPerson(salesPersonDto.getSalesPersonId());

  }

}
