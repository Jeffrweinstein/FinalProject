package com.promineotech.confinedspace.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
  private String orderId;
  private String customerId;
  private String salesPersonId;
  private String orderDate;
  private String orderPerson;
  private String jobId;
  private String poNumber;

}
