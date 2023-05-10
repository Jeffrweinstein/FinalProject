package com.promineotech.confinedspace.service;

import java.util.Date;
import java.util.List;
import com.promineotech.confinedspace.entity.Orders;

public interface OrdersService {

  //Get all orders
  List<Orders> fetchAllOrders();
  
  //Get orders by customerId
  List<Orders> fetchOrderByCustomerId(String customerId);
  
  //Create orders
  Orders createOrder(String customerId, String jobId, Date date,
       String orderPerson, String poNumber, String salesPersonId, String orderId);

  //Update orders
  Orders updateOrder(String customerId, String jobId, Date date,
      String orderPerson, String poNumber, String salesPersonId, String OrderId);

  //Delete orders

  void deleteOrder(String orderId);
}
