package com.promineotech.confinedspace.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.promineotech.confinedspace.entity.EquipmentOrders;

@Service
public class DefaultEquipmentOrdersService implements EquipmentOrdersService {

  @Autowired
  private EquipmentOrdersDao equipmentOrdersDao;

  @Override
  public List<EquipmentOrders> fetchAllEquipmentOrders() {
    // TODO Auto-generated method stub
    return null;
  }
}
