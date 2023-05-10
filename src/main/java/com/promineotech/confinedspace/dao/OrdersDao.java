package com.promineotech.confinedspace.dao;

import java.util.Date;
import java.util.List;
import com.promineotech.confinedspace.entity.Orders;

public interface OrdersDao {

  //GET orders
  List<Orders> fetchAllOrders();
  
  //GET orders by customer ID
  List<Orders> fetchOrdersByCustomerId(String customerId);
  
  //CREATE orders
  Orders createOrder(String customerId, String jobId, Date orderDate,
      String orderPerson, String poNumber, String salesPersonId, String orderId);
  
  //UPDATE orders
  Orders updateOrder(String customerId, String jobId, Date orderDate,
       String orderPerson, String poNumber, String salesPersonId);
  
  //DELETE orders
  void deleteOrder(String orderId);
} 
