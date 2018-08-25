package com.poc.realestate.demo.controller;

import com.poc.realestate.demo.model.RentalAgreement;
import com.poc.realestate.demo.serviceInterfaces.RentalAgreementService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalAgreementController {

    @Autowired
    RentalAgreementService agreementService;

    @ApiOperation(value = "Create new agreement draft",
            notes = "Create new offer")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @PostMapping(value = {"/enlistments/{enlistmentId}/agreements"})
    public ResponseEntity<String> createAgreement(@PathVariable long enlistmentId,
                                                  @RequestBody RentalAgreement agreement) {
        if (agreementService.createAgreement(enlistmentId, agreement)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Get agreement draft",
            notes = "Get agreement draft")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request")})

    @GetMapping(value = {"/enlistments/{enlistmentId}/agreements"})
    public ResponseEntity<RentalAgreement> getAgreement(@PathVariable long enlistmentId,
                                                        @RequestParam String tenantEmail) {
        RentalAgreement agreement = agreementService.getAgreement(enlistmentId, tenantEmail);
        return new ResponseEntity<>(agreement, HttpStatus.OK);
    }

    @ApiOperation(value = "Review agreement draft",
            notes = "Review agreement draft")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request")})

    @PostMapping(value = {"/enlistments/{enlistmentId}/agreements/review"})
    public ResponseEntity<String> reviewAgreement(@PathVariable long enlistmentId,
                                                  @RequestBody String tenantEmail, boolean approved) {
        String status = agreementService.reviewAgreement(enlistmentId, tenantEmail, approved);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Cancel agreement draft",
            notes = "Cancel agreement draft")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request")})

    @PostMapping(value = {"/enlistments/{enlistmentId}/agreements/cancel"})
    public ResponseEntity<String> cancelAgreement(@PathVariable long enlistmentId,
                                                  @RequestBody String tenantEmail) {
        String status = agreementService.cancelAgreement(enlistmentId, tenantEmail);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Cancel agreement draft",
            notes = "Cancel agreement draft")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request")})

    @PostMapping(value = {"/enlistments/{enlistmentId}/agreements/sign"})
    public ResponseEntity<String> signAgreement(@PathVariable long enlistmentId,
                                                @RequestBody String tenantEmail, String signingParty, String signatureHash) {
        String status = agreementService.signAgreement(enlistmentId, tenantEmail, signingParty, signatureHash);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

}
