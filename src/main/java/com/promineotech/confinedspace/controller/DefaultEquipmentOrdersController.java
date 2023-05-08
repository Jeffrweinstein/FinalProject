package com.promineotech.confinedspace.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.confinedspace.entity.EquipmentOrders;
import com.promineotech.confinedspace.service.EquipmentOrdersService;

@RestController
public class DefaultEquipmentOrdersController implements EquipmentOrdersController {

  @Autowired
 private EquipmentOrdersService equipmentOrdersService;
  @Override
  public List<EquipmentOrders> fetchAllEquipmentOrders() {
    // TODO Auto-generated method stub
    return equipmentOrdersService.fetchAllEquipmentOrders();
  }

}
