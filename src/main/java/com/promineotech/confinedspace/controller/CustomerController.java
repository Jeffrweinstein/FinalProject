package com.promineotech.confinedspace.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.confinedspace.entity.Customer;
import com.promineotech.confinedspace.entity.dto.CustomerDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated
@RequestMapping("/customer")
@OpenAPIDefinition(info = @Info(title = "Confined Space Customer Service"),
servers = { @Server(url = "http://localhost:8080", description = "Local server.")})
public interface CustomerController {
//@formatter:off
  @Operation(
      summary = "Returns a list of customers", 
      description = "Returns the list of customers",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A list of customers gets returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Customer.class))),
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "No customers were found", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          }
      )
  @GetMapping("/getsCustomers")
  @ResponseStatus(code= HttpStatus.OK)
  List<Customer> fetchCustomers();
  
  //GETS customer by name
      
  @Operation(
      summary = "Returns a list of customer by name", 
      description = "Returns the list of customers",
      
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A list of customers gets returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Customer.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "No customers were found", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          }  , 
      parameters = {
          @Parameter(
              name = "customerName", 
              allowEmptyValue = false,
              required = false,
              description = "The customer name to be found")
      }
      )
    
       @GetMapping("/getsCustomerByName")
        @ResponseStatus(code= HttpStatus.OK)
        List<Customer> fetchCustomerByName(String customerName);
  
//POST/ CREATE new customer
  @Operation(
      summary = "Creates a new customer", 
      description = "Returns the created customer",
      responses = {
          @ApiResponse(
              responseCode= "201", 
              description= "A customer was created", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Customer.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "Unable to create a new customer with the given input", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          } 
      )
      @PostMapping("/createCustomer")
      @ResponseStatus(code= HttpStatus.CREATED)
      
      Customer createCustomer(@Valid @RequestBody CustomerDto customerDto);
      
    //Update/PUT a customer
      
      @Operation(
          summary = "Updates a customer", 
          description = "Returns the updated customer",
          responses = {
              @ApiResponse(
                  responseCode= "200", 
                  description= "A customer was updated", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = Customer.class))), 
              @ApiResponse(
                  responseCode= "400", 
                  description = "The parameters requested are not valid", 
                  content= @Content(mediaType = "application/json")), 
              @ApiResponse(
                  responseCode= "404", 
                  description = "Unable to update customer with the given input", 
                  content= @Content(mediaType = "application/json")), 
              @ApiResponse(
                  responseCode= "500", 
                  description = "An unplanned error occurred", 
                  content= @Content(mediaType = "application/json"))
              } 
          )
      
      @PutMapping("/updateCustomer")
      @ResponseStatus(code= HttpStatus.OK)
      Customer updateCustomer(@Valid @RequestBody CustomerDto customerDto);
      
    //DELETE a customer
      @Operation(
          summary = "Deletes a customer", 
          description = "Deletes a customer",
          responses = {
              @ApiResponse(
                  responseCode= "200", 
                  description= "A customer was deleted", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = Customer.class))), 
              @ApiResponse(
                  responseCode= "400", 
                  description = "The parameters requested are not valid", 
                  content= @Content(mediaType = "application/json")), 
              @ApiResponse(
                  responseCode= "404", 
                  description = "Unable to delete customer with the given input", 
                  content= @Content(mediaType = "application/json")), 
              @ApiResponse(
                  responseCode= "500", 
                  description = "An unplanned error occurred", 
                  content= @Content(mediaType = "application/json"))
              } 
    
          )
      @DeleteMapping("/deleteCustomer")
      @ResponseStatus(code= HttpStatus.OK)
      void deleteCustomer(@Valid @RequestBody CustomerDto customerDto);
      
      
      
      
      
      //@formatter:on
}
