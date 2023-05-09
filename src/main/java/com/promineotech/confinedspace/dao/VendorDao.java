package com.promineotech.confinedspace.dao;

import java.util.List;
import com.promineotech.confinedspace.entity.Vendor;

public interface VendorDao {

//GET
  List<Vendor> fetchAllVendor();

  //GET
  List<Vendor> fetchVendorByName(String vendorName);

  //POST
  Vendor createVendor(String vendorId, String vendorName, 
      String vendorPhoneNumber, String vendorAddress);

  //PUT

  Vendor updateVendor(String vendorId, String vendorName, 
      String vendorPhoneNumber, String vendorAddress);
  
  //DELETE

  void deleteVendor(String vendorId);



}

