package com.promineotech.confinedspace.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.confinedspace.dao.OrdersDao;
import com.promineotech.confinedspace.entity.Orders;

@Service
public class DefaultOrdersService implements OrdersService {

  
  @Autowired
  private OrdersDao orderDao;
  
  //GET orders
 @Transactional(readOnly = true)
  @Override
  public List<Orders> fetchAllOrders() {
  List<Orders> orders = orderDao.fetchAllOrders();
  return orders;
}

//GET orders by Customer Id
@Transactional(readOnly = true)
@Override
public List<Orders> fetchOrderByCustomerId(String customerId) {
  List<Orders> orders = orderDao.fetchOrdersByCustomerId(customerId);
  return orders;
}
//CREATE orders

@Override
public Orders createOrder(String customerId, String jobId, Date orderDate,
    String orderPerson, String poNumber, String salesPersonId, String orderId) {
  
  return orderDao.createOrder(customerId, jobId, orderDate,
      orderPerson, poNumber, salesPersonId, orderId);
}
//UPDATE orders

@Override
public Orders updateOrder(String customerId, String jobId, Date orderDate,
     String orderPerson, String poNumber, String salesPersonId, String orderId)
{
  return orderDao.updateOrder(customerId, jobId, orderDate, orderPerson, poNumber, salesPersonId);
}
//DELETE orders

@Override
public void deleteOrder(String orderId) {
 orderDao.deleteOrder(orderId);
  
}


}


  
  
  

