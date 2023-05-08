package com.promineotech.confinedspace.entity.dto;

import java.math.BigDecimal;
import com.promineotech.confinedspace.entity.EquipmentGroup;
import com.promineotech.confinedspace.entity.EquipmentSize;
import com.promineotech.confinedspace.entity.EquipmentType;

public class EquipmentDto {

  private String equipmentId;
  private String vendorId;
  private EquipmentGroup group;
  private EquipmentSize size;
  private EquipmentType type;
  private BigDecimal price;
  
  public String getEquipmentId() {
    return equipmentId;
  }
  
  public String getVendorId() {
    return vendorId;
  }
  public EquipmentGroup getGroup() {
    return group;
  }
  public EquipmentSize getSize() {
    return size;
  }
  public EquipmentType getType() {
    return type;
  }
  public BigDecimal getPrice() {
    return price;
  }
    
}
