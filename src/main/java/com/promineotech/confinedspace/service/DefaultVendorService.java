package com.promineotech.confinedspace.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.promineotech.confinedspace.dao.VendorDao;
import com.promineotech.confinedspace.entity.Vendor;

public class DefaultVendorService implements VendorService {

  
  private VendorDao vendorDao;
  
  //GET all vendors
  @Transactional
  @Override
  public List<Vendor> fetchAllVendor(){
  List<Vendor> vendor = vendorDao.fetchAllVendor();
  return vendor;   
  }
  //GET vendor by name

  @Transactional
  @Override
  public List<Vendor> fetchVendorByName(String vendorName) {
  List<Vendor> vendor = vendorDao.fetchVendorByName(vendorName);
  return vendor;
  }
//POST/CREATE create a vendor
  @Override
  public Vendor createVendor(String vendorId, String vendorName, String vendorPhoneNumber,
      String vendorAddress) {
    return vendorDao.createVendor(vendorId, vendorName, vendorPhoneNumber,
            vendorAddress);
    
  }
  //PUT/UPDATE a vendor
  @Override
  public Vendor updateVendor(String vendorId, String vendorName, String vendorPhoneNumber,
      String vendorAddress) {
    return vendorDao.updateVendor(vendorId, vendorName, vendorPhoneNumber,
        vendorAddress);
  }

  @Override
  //DELETE a vendor
  public void deleteVendor(String vendorId) {
    vendorDao.deleteVendor(vendorId);

  }

}
