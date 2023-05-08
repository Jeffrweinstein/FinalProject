package com.promineotech.confinedspace.service;

import java.util.List;
import com.promineotech.confinedspace.entity.Vendor;



public interface VendorService {

//GET Vendors
  List<Vendor> fetchAllVendor();

//GET Vendors by name
  List<Vendor> fetchVendorByName(String vendorName);

//CREATE Vendors
  Vendor createVendor(String vendorId, String vendorName, 
      String vendorPhoneNumber, String vendorAddress);

//UPDATE Vendors
  Vendor updateVendor(String vendorId, String vendorName, 
      String vendorPhoneNumber, String vendorAddress);
  
//DELETE Vendors
  void deleteVendor(String vendorId);





}
