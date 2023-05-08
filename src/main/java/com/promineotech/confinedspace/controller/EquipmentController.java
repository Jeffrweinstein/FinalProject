package com.promineotech.confinedspace.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.confinedspace.entity.Equipment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@Validated
@RequestMapping("/Equipment")

public interface EquipmentController {
//@formatter:off
  @Operation(
      summary = "Returns a list of equipment",
      description = "Returns a list of equipment given a required equipment group, size, and type",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of equipment is returned.", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Equipment.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No addresses were found with the input criteria.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
      }
          
                  )
        @GetMapping("/getsAllEquipment")
            @ResponseStatus(code= HttpStatus.OK)
            List<Equipment> fetchAllEquipment();
              
              
      
  

}
