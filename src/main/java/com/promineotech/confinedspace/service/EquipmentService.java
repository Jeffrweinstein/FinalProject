package com.promineotech.confinedspace.service;

import java.util.List;
import com.promineotech.confinedspace.entity.Equipment;

public interface EquipmentService {

  //GET all equipment
  
  List<Equipment> fetchAllEquipment();
}
