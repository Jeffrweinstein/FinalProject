package com.promineotech.confinedspace.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.confinedspace.entity.Equipment;
import com.promineotech.confinedspace.service.EquipmentService;

@RestController
public class DefaultEquipmentController implements EquipmentController {

  @Autowired
  private EquipmentService equipmentService;
  
  @Override
  public List<Equipment> fetchAllEquipment() {
    return equipmentService.fetchEquipment();
  }

}
