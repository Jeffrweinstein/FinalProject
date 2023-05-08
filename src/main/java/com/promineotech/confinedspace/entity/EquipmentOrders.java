package com.promineotech.confinedspace.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentOrders {
  
  private String orderId;
  private String equipmentId;
  private Integer quantity;
}
