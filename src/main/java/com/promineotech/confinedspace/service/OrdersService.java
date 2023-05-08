package com.promineotech.confinedspace.service;

import java.util.List;
import com.promineotech.confinedspace.entity.Orders;

public interface OrdersService {

  //Get all orders
  List<Orders> fetchAllOrders();
  
  //Get orders by customerId
  List<Orders> fetchOrderByCustomerId(String customerId);
  
  //Create orders
  Orders createOrder(String customerId, String jobId, String orderDate,
      String orderId, String orderPerson, String poNumber, String salesPersonId);

  //Update orders
  Orders updateOrder(String customerId, String jobId, String orderDate,
      String orderId, String orderPerson, String poNumber, String salesPersonId);

  //Delete orders

  void deleteOrder(String orderId);
}
