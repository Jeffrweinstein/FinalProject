package com.promineotech.confinedspace.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
  private String customerId;
  private String customerName;
  private String customerAddress;
  private String customerPhoneNumber;

}
