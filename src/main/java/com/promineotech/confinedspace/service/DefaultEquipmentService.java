package com.promineotech.confinedspace.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.confinedspace.dao.EquipmentDao;
import com.promineotech.confinedspace.entity.Equipment;

@Service
public class DefaultEquipmentService implements EquipmentService {

  @Autowired EquipmentDao equipmentDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Equipment> fetchAllEquipment() {
    List<Equipment> equipment = equipmentDao.fetchAllEquipment();
    
    return equipment;
  }
}
