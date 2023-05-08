package com.promineotech.confinedspace.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.promineotech.confinedspace.entity.Equipment;
import com.promineotech.confinedspace.service.EquipmentService;

public class DefaultEquipmentController implements EquipmentController {

  @Autowired
  private EquipmentService equipmentService;
  
  @Override
  public List<Equipment> fetchAllEquipment() {
    // TODO Auto-generated method stub
    return equipmentService.fetchEquipment();
  }

}