package com.promineotech.confinedspace.entity.dto;

public class OrdersDto {

  private String orderId;
  private String customerId;
  private String salesPersonId;
  private String orderDate;
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
  public String getOrderDate() {
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
