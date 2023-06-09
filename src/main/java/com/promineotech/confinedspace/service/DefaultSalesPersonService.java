package com.promineotech.confinedspace.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.confinedspace.dao.SalesPersonDao;
import com.promineotech.confinedspace.entity.SalesPerson;

@Service
public class DefaultSalesPersonService implements SalesPersonService {

  @Autowired
  private SalesPersonDao salesPersonDao;
  
  //GET all sales people
  @Transactional(readOnly = true)
  @Override
  public List<SalesPerson> fetchAllSalesPerson() {
    List<SalesPerson> salesPerson = salesPersonDao.fetchAllSalesPerson();
    return salesPerson;   
  }
  //GET sales person by ID
  @Transactional(readOnly = true)
  @Override
  public List<SalesPerson> fetchSalesPersonBySalesPersonId(String salesPersonId) {
    List<SalesPerson> salesPerson = salesPersonDao.fetchSalesPersonById(salesPersonId);
    return salesPerson;
    }
  @Transactional(readOnly = true)
  @Override
  public SalesPerson createSalesPerson(String salesPersonId, String lastName, String firstName) {
    
    return salesPersonDao.createSalesPerson(salesPersonId, lastName, firstName);
  }

  @Override
  public SalesPerson updateSalesPerson(String salesPersonId, String lastName, String firstName) {
    return salesPersonDao.updateSalesPerson(salesPersonId, lastName, firstName);
  }  

  @Override
  public void deleteSalesPerson(String salesPersonId) {
    salesPersonDao.deleteSalesPerson(salesPersonId);

  }

}
