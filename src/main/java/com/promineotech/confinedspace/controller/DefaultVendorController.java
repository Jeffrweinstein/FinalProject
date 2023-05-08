package com.promineotech.confinedspace.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.confinedspace.entity.Vendor;
import com.promineotech.confinedspace.entity.dto.VendorDto;
import com.promineotech.confinedspace.service.VendorService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultVendorController implements VendorController {

  @Autowired
  private VendorService vendorService;
  
  //Gets all vendors
  @Override
  public List<Vendor> fetchAllVendor() {
    
    return vendorService.fetchAllVendor();
  }
 
  
  //Gets vendor by name
  @Override
  public List<Vendor> fetchVendorByName(String customerName) {
    return vendorService.fetchAllVendor();
  }
  
  //Creates vendor
  @Override
  public Vendor createVendor(@Valid VendorDto vendorDto) {
    return vendorService.createVendor
        (vendorDto.getVendorId(), vendorDto.getVendorName(),
        vendorDto.getVendorAddress(), vendorDto.getVendorPhoneNumber());
  }
  //Updates vendor
  @Override
  public Vendor updateVendor(@Valid VendorDto vendorDto) {
    return vendorService.updateVendor
        (vendorDto.getVendorId(), vendorDto.getVendorName(),
            vendorDto.getVendorAddress(), vendorDto.getVendorPhoneNumber());
   
  }
  //Deletes Vendor
  @Override
  public void deleteVendor(@Valid VendorDto vendorDto) {
      log.debug("Customer ID Deleted = {}", vendorDto.getVendorId());
      vendorService.deleteVendor(vendorDto.getVendorId());

  }

 

}