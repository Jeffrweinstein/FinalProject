package com.promineotech.confinedspace.entity.dto;

import java.util.Date;
public class OrdersDto {

  private String orderId;
  private String customerId;
  private String salesPersonId;
  private Date orderDate;
  private String orderPerson;
  private String jobId;
  private String poNumber;
  
  public String getOrderId() {
    return orderId;
  } 
  public String getCustomerId() {
    return customerId;
  }
  public String getSalesPersonID() {
    return salesPersonId;
  }
  public Date getOrderDate() {
    return orderDate;
  } 
  public String getOrderPerson() {
    return orderPerson;
  }
  public String getJobId() {
    return jobId;
  }
  public String getPoNumber() {
    return poNumber;
  }
}
