package com.promineotech.confinedspace.entity;


import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Equipment {

  private String equipmentId;
  private String vendorId;
  private EquipmentGroup group;
  private EquipmentSize size;
  private EquipmentType type;
  private BigDecimal price;
  
  
}
