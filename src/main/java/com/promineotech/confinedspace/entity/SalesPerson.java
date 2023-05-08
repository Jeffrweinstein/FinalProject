package com.promineotech.confinedspace.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesPerson {
  private String salesPersonId;
  private String lastName;
  private String firstName;
}
