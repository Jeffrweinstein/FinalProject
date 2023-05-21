package com.promineotech.confinedspace.dao;

import java.util.List;
import com.promineotech.confinedspace.entity.Equipment;

public interface EquipmentDao {

  List<Equipment> fetchAllEquipment();
}
