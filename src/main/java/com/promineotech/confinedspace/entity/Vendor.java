package com.promineotech.confinedspace.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {

  private String vendorId;
  private String vendorName;
  private String vendorAddress;
  private String vendorPhoneNumber;
  }
