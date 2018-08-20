package com.poc.realestate.demo.controller;

import com.poc.realestate.demo.model.Offer;
import com.poc.realestate.demo.serviceInterfaces.OfferService;
import com.poc.realestate.demo.tos.OfferTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

    @Autowired
    OfferService offerService;

    @ApiOperation(value = "Create new offer",
            notes = "Create new offer")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 409, message = "Conflict")
    })
    @RequestMapping(
            value = {"/offer"},
            method = RequestMethod.POST
            //produces = MediaType.APPLICATION_JSON.APPLICATION_JSON)
    )
    public ResponseEntity<Offer> createWorkspace(@RequestBody String offererName, String offererEmail, long amount) {
        Offer offerTO = offerService.createOffer(offererName, offererEmail, amount);
        return new ResponseEntity<>(offerTO, HttpStatus.CREATED);
    }

}
