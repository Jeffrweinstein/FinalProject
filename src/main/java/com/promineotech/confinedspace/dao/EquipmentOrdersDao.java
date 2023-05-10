package com.promineotech.confinedspace.dao;

import java.util.List;
import com.promineotech.confinedspace.entity.EquipmentOrders;

public interface EquipmentOrdersDao {

  List<EquipmentOrders> fetchAllEquipmentOrders();
}
