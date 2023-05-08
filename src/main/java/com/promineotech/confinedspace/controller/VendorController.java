package com.promineotech.confinedspace.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.confinedspace.entity.Vendor;
import com.promineotech.confinedspace.entity.dto.VendorDto;
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
@RequestMapping("/vendor")
@OpenAPIDefinition(info = @Info(title = "Confined Space Vendor Service"),
servers = { @Server(url = "http://localhost:8080", description = "Local server.")})
public interface VendorController {
//@formatter:off
  @Operation(
      summary = "Returns a list of vendors", 
      description = "Returns the list of vendors",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A list of vendors gets returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Vendor.class))),
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "No vendors were found", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          }
      )
  @GetMapping("/getsAllVendors")
  @ResponseStatus(code= HttpStatus.OK)
  List<Vendor> fetchAllVendor();
  
  //GETS vendor by name
      
  @Operation(
      summary = "Returns a list of vendors by name", 
      description = "Returns the list of vendors",
      
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A list of vendors gets returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Vendor.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "No vendors were found", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          }  , 
      parameters = {
          @Parameter(
              name = "vendorName", 
              allowEmptyValue = false,
              required = false,
              description = "The vendor name to be found")
      }
      )
    
       @GetMapping("/getsVendorByName")
        @ResponseStatus(code= HttpStatus.OK)
        List<Vendor> fetchVendorByName(String vendorName);
  
//POST/ CREATE new vendor
  @Operation(
      summary = "Creates a new vendor", 
      description = "Returns the created vendor",
      responses = {
          @ApiResponse(
              responseCode= "201", 
              description= "A vendor was created", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Vendor.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "Unable to create a new vendor with the given input", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          } 
      )
      @PostMapping("/createVendor")
      @ResponseStatus(code= HttpStatus.CREATED)
      
      Vendor createVendor(@Validated @RequestBody VendorDto vendorDto);
      
    //Update/PUT a vendor
      
      @Operation(
          summary = "Updates a vendor", 
          description = "Returns the updated customer",
          responses = {
              @ApiResponse(
                  responseCode= "200", 
                  description= "A vendor was updated", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = Vendor.class))), 
              @ApiResponse(
                  responseCode= "400", 
                  description = "The parameters requested are not valid", 
                  content= @Content(mediaType = "application/json")), 
              @ApiResponse(
                  responseCode= "404", 
                  description = "Unable to update vendor with the given input", 
                  content= @Content(mediaType = "application/json")), 
              @ApiResponse(
                  responseCode= "500", 
                  description = "An unplanned error occurred", 
                  content= @Content(mediaType = "application/json"))
              } 
          )
      
      @PutMapping("/updateVendor")
      @ResponseStatus(code= HttpStatus.OK)
      Vendor updateVendor(@Validated @RequestBody VendorDto vendorDto);
      
    //DELETE a vendor
      @Operation(
          summary = "Deletes a vendor", 
          description = "Deletes a vendor",
          responses = {
              @ApiResponse(
                  responseCode= "200", 
                  description= "A vendor was deleted", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = Vendor.class))), 
              @ApiResponse(
                  responseCode= "400", 
                  description = "The parameters requested are not valid", 
                  content= @Content(mediaType = "application/json")), 
              @ApiResponse(
                  responseCode= "404", 
                  description = "Unable to delete vendor with the given input", 
                  content= @Content(mediaType = "application/json")), 
              @ApiResponse(
                  responseCode= "500", 
                  description = "An unplanned error occurred", 
                  content= @Content(mediaType = "application/json"))
              } 
    
          )
      @DeleteMapping("/deleteVendor")
      @ResponseStatus(code= HttpStatus.OK)
      void deleteVendor(@Validated @RequestBody VendorDto vendorDto);
      
      
      
      
      
      
}
