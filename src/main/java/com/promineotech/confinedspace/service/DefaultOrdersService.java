package com.promineotech.confinedspace.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.confinedspace.entity.Orders;

@Service
public class DefaultOrdersService implements OrdersService {

  
  @Autowired
  private OrdersDao orderDao;
  
  //Get orders
  @Transactional(readOnly = true)
  @Override
  public List<Orders> fetchAllOrders();
  List<Orders> orders = ordersDao.fetchOrders();
  return orders;
}

//Get orders by Customer Id
@Transactional(readOnly = true)
@Override
public List<Orders> fetchOrderByCustomerId(String customerId) {
  List<Orders> orders = ordersDao.fetchOrdersByCustomerId(customerId);
  return orders;
}
//Create orders
@Override
public Orders createOrder(String customerId) {
  
  return ordersDao.createOrder(customerId);
}
//Update orders
@Override
public Orders updateOrder(String customerId, String orderId) {
  
  return ordersDao.updateOrder(customerId, orderId);
}
//Delete orders
@Override
public void deleteOrder(String orderId) {
  ordersDao.deleteOrder(orderId);
  
}


}
  
  
  
}
