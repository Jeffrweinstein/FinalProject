package com.promineotech.confinedspace.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.confinedspace.entity.Vendor;
import com.promineotech.confinedspace.service.VendorService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultVendorController implements VendorController {

  @Autowired
  private VendorService vendorService;
  
  //GET all vendors
  @Override
  public List<Vendor> fetchAllVendor() {
    
    return vendorService.fetchAllVendor();
  }
 
  
  //GET vendor by name
  @Override
  public List<Vendor> fetchVendorByName(String vendorName) {
    return vendorService.fetchVendorByName(vendorName);
  }
  
  //CREATE/POST a vendor
  @Override
  public Vendor createVendor(@Valid Vendor vendorDto) {
    return vendorService.createVendor
        (vendorDto.getVendorId(), vendorDto.getVendorName(),
        vendorDto.getVendorAddress(), vendorDto.getVendorPhoneNumber());
  }
  //UPDATE/PUT a vendor
  @Override
  public Vendor updateVendor(@Valid Vendor vendorDto) {
    return vendorService.updateVendor
        (vendorDto.getVendorId(), vendorDto.getVendorName(),
            vendorDto.getVendorAddress(), vendorDto.getVendorPhoneNumber());
   
  }
  //DELETE a vendor
  @Override
  public void deleteVendor(@Valid Vendor vendor) {
      log.debug("Customer ID Deleted = {}", vendor.getVendorId());
      vendorService.deleteVendor(vendor.getVendorId());

  }

 

}