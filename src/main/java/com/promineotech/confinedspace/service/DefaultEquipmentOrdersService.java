package com.promineotech.confinedspace.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.confinedspace.dao.EquipmentOrdersDao;
import com.promineotech.confinedspace.entity.EquipmentOrders;

@Service
public class DefaultEquipmentOrdersService implements EquipmentOrdersService {

  @Autowired
  private EquipmentOrdersDao equipmentOrdersDao;

  @Override
  public List<EquipmentOrders> fetchAllEquipmentOrders() {
    List<EquipmentOrders> equipmentOrders = equipmentOrdersDao.fetchAllEquipmentOrders();
    return equipmentOrders;
  }
}
