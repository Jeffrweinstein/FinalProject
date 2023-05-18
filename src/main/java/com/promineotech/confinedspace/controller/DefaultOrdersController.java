package com.promineotech.confinedspace.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.confinedspace.entity.Orders;
import com.promineotech.confinedspace.service.OrdersService;

@RestController
@Service
public class DefaultOrdersController implements OrdersController {

  @Autowired
  private OrdersService orderService;
  
  //GET all orders
  @Override
  public List<Orders> fetchAllOrders() {
    
    return orderService.fetchAllOrders();
  }
  //GET orders by customer id
  @Override
  public List<Orders> fetchOrderByCustomerId(String customerId) {
   return orderService.fetchOrderByCustomerId(customerId);
  }
  //CREATE/POST new orders
  @Override
  public Orders createOrder(@Valid Orders order) {
    return orderService.createOrder(order.getCustomerId(),
        order.getJobId(), order.getOrderDate(),
        order.getOrderPerson(), order.getPoNumber(),
        order.getSalesPersonId(), order.getOrderId());
  }
  //UPDATE/PUT orders
  @Override
  public Orders updateOrder(@Valid Orders order) {
    return orderService.updateOrder(order.getCustomerId(),
        order.getJobId(), order.getOrderDate(), 
        order.getOrderPerson(), order.getPoNumber(),
        order.getSalesPersonId(), order.getOrderId());
  }
  
  //DELETE orders
  @Override
  public void deleteOrder(@Valid Orders order) {
    orderService.deleteOrder(order.getOrderId());
  }

}
