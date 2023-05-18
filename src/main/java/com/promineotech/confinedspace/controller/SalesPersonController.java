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
import com.promineotech.confinedspace.entity.SalesPerson;
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
@RequestMapping("/salesPerson")
@OpenAPIDefinition(info = @Info(title = "Confined Space Sales Person Service"),
servers = { @Server(url = "http://localhost:8080", description = "Local server.")})
public interface SalesPersonController {
//@formatter:off
  @Operation(
      summary = "Returns a list of sales people", 
      description = "Returns the list of sales person",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A list of sales people gets returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = SalesPerson.class))),
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "No sales people were found", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          }
      )
  @GetMapping("/getsAllSalesPerson")
  @ResponseStatus(code= HttpStatus.OK)
  List<SalesPerson> fetchAllSalesPerson();
  
  //GETS customer by name
      
  @Operation(
      summary = "Returns a list of sales person by Id", 
      description = "Returns the list of sales people",
      
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A list of sales people gets returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = SalesPerson.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "No sales person was found", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          }  , 
      parameters = {
          @Parameter(
              name = "salesPersonId", 
              allowEmptyValue = false,
              required = false,
              description = "The sales person id to be found")
      }
      )
    
       @GetMapping("/getsSalesPersonById")
        @ResponseStatus(code= HttpStatus.OK)
        List<SalesPerson> fetchSalesPersonById(String salesPersonId);
  
//POST/ CREATE new sales person
  @Operation(
      summary = "Creates a new sales person", 
      description = "Returns the created sales person",
      responses = {
          @ApiResponse(
              responseCode= "201", 
              description= "A sales person was created", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = SalesPerson.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "Unable to create a new sales person with the given input", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          } 
      )
      @PostMapping("/createSalesPerson")
      @ResponseStatus(code= HttpStatus.CREATED)
      
      SalesPerson createSalesPerson(@Validated @RequestBody SalesPerson salesPerson);
      
    //Update/PUT a customer
      
      @Operation(
          summary = "Updates a sales person", 
          description = "Returns the updated sales person",
          responses = {
              @ApiResponse(
                  responseCode= "200", 
                  description= "A sales person was updated", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = SalesPerson.class))), 
              @ApiResponse(
                  responseCode= "400", 
                  description = "The parameters requested are not valid", 
                  content= @Content(mediaType = "application/json")), 
              @ApiResponse(
                  responseCode= "404", 
                  description = "Unable to update sales person with the given input", 
                  content= @Content(mediaType = "application/json")), 
              @ApiResponse(
                  responseCode= "500", 
                  description = "An unplanned error occurred", 
                  content= @Content(mediaType = "application/json"))
              } 
          )
      
      @PutMapping("/updateSalesPerson")
      @ResponseStatus(code= HttpStatus.OK)
      SalesPerson updateSalesPerson(@Validated @RequestBody SalesPerson salesPerson);
      
    //DELETE a customer
      @Operation(
          summary = "Deletes a sales person", 
          description = "Deletes a sales person",
          responses = {
              @ApiResponse(
                  responseCode= "200", 
                  description= "A sales person was deleted", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = SalesPerson.class))), 
              @ApiResponse(
                  responseCode= "400", 
                  description = "The parameters requested are not valid", 
                  content= @Content(mediaType = "application/json")), 
              @ApiResponse(
                  responseCode= "404", 
                  description = "Unable to delete sales person with the given input", 
                  content= @Content(mediaType = "application/json")), 
              @ApiResponse(
                  responseCode= "500", 
                  description = "An unplanned error occurred", 
                  content= @Content(mediaType = "application/json"))
              } 
    
          )
      @DeleteMapping("/deleteSalesPerson")
      @ResponseStatus(code= HttpStatus.OK)
      void deleteSalesPerson(@Valid @RequestBody SalesPerson salesPerson);
      
      
      
      
      
      
}
