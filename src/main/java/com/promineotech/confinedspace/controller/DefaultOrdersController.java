package com.promineotech.confinedspace.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.confinedspace.entity.Orders;
import com.promineotech.confinedspace.entity.dto.OrdersDto;
import com.promineotech.confinedspace.service.OrdersService;

@RestController
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
  public Orders createOrder(@Valid OrdersDto orderDto) {
    return orderService.createOrder(orderDto.getCustomerId(),
        orderDto.getJobId(), orderDto.getOrderDate(),
        orderDto.getOrderPerson(), orderDto.getPoNumber(),
        orderDto.getSalesPersonID(), orderDto.getOrderId());
  }
  //UPDATE/PUT orders
  @Override
  public Orders updateOrder(@Valid OrdersDto orderDto) {
    return orderService.updateOrder(orderDto.getCustomerId(),
        orderDto.getJobId(), orderDto.getOrderDate(), 
        orderDto.getOrderPerson(), orderDto.getPoNumber(),
        orderDto.getSalesPersonID(), orderDto.getOrderId());
  }
  
  //DELETE orders
  @Override
  public void deleteOrder(@Valid OrdersDto orderDto) {
    orderService.deleteOrder(orderDto.getOrderId());
  }

}
