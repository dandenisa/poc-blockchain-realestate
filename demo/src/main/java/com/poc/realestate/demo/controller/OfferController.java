package com.poc.realestate.demo.controller;

import com.poc.realestate.demo.serviceInterfaces.OfferService;
import com.poc.realestate.demo.tos.OfferTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping(value = {"/enlistments/{enlistmentId}/offers"})
    public ResponseEntity<String> createOffer(@PathVariable long enlistmentId,
                                              @RequestBody OfferTO offer) {
        if (offerService.createOffer(enlistmentId, offer)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Get offer",
            notes = "Get offer")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 409, message = "Conflict")
    })
    @GetMapping(value = {"/enlistments/{enlistmentId}/offers/{tenantEmail}"})
    public ResponseEntity<OfferTO> getOffer(@PathVariable long enlistmentId,
                                            @PathVariable String tenantEmail) {
        OfferTO offer = offerService.getOffer(enlistmentId, tenantEmail);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @ApiOperation(value = "Review offer",
            notes = "Review offer")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @PostMapping(value = {"/enlistments/{enlistmentId}/offers/{tenantId}/review"})
    public ResponseEntity<String> reviewOffer(@PathVariable long enlistmentId,
                                              @PathVariable String tenantId,
                                              @RequestBody boolean approved) {
        String status = offerService.reviewOffer(enlistmentId, tenantId, approved);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    //todo use mapping dtos
}
