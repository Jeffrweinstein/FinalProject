package com.promineotech.confinedspace.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.confinedspace.entity.Equipment;

public class DefaultEquipmentService implements EquipmentService {

  @Autowired EquipmentDao equipmentDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Equipment> fetchEquipment() {
    List<Equipment> equipment = equipmentDao.fetchEquipment();
    
    return equipment;
  }
}
