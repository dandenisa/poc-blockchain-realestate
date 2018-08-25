package com.poc.realestate.demo.controller;

import com.poc.realestate.demo.model.PropertyEnlistment;
import com.poc.realestate.demo.serviceInterfaces.PropertyEnlistmentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyEnlistmentController {

    @Autowired
    PropertyEnlistmentService propertyEnlistmentService;

    private static final Logger log = LoggerFactory.getLogger(PropertyEnlistmentController.class.getName());

    @ApiOperation(value = "Create new enlistment",
            notes = "Create new enlistment")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 409, message = "Conflict")
    })
    @PostMapping(value = {"/enlistments"})

    public ResponseEntity<PropertyEnlistment> createEnlistment(@RequestBody PropertyEnlistment propertyEnlistment) {
        PropertyEnlistment enlistment = null;
        try {
            enlistment = propertyEnlistmentService.createEnlistment(propertyEnlistment);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(enlistment, HttpStatus.CREATED);
    }

    @ApiOperation(value = "getEnlistment", notes = "getEnlistment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 409, message = "Conflict")
    })
    @GetMapping(value = {"/enlistments/{enlistmentId}"})
    public ResponseEntity<PropertyEnlistment> getEnlistment(@PathVariable long enlistmentId) {
        PropertyEnlistment property = propertyEnlistmentService.getEnlistment(enlistmentId);
        return new ResponseEntity<>(property, HttpStatus.OK);
    }


//    @ApiOperation(value = "getEnlistment", notes = "getEnlistment")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "OK"),
//            @ApiResponse(code = 400, message = "Bad Request"),
//            @ApiResponse(code = 409, message = "Conflict")
//    })
//    @GetMapping(value = {"/enlistments/test"})
//    public ResponseEntity<String> getAccountsTests() {
//        String result = null;
//        try {
//            result = propertyEnlistmentService.getEthAccountsTEST().get().getBalance().toString();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "getEnlistment", notes = "getEnlistment")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "OK"),
//            @ApiResponse(code = 400, message = "Bad Request"),
//            @ApiResponse(code = 409, message = "Conflict")
//    })
//    @GetMapping(value = {"/enlistments/transactiontest"})
//    public ResponseEntity<String> getTransactionTests() {
//        String result = propertyEnlistmentService.getTransactionTEST();
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "getEnlistment", notes = "getEnlistment")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "OK"),
//            @ApiResponse(code = 400, message = "Bad Request"),
//            @ApiResponse(code = 409, message = "Conflict")
//    })
//    @GetMapping(value = {"/enlistments/deploy/smartcontract"})
//    public ResponseEntity<String> deploySmartContractTest() {
//        String result = propertyEnlistmentService.loadSmartContract();
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "getEnlistment", notes = "getEnlistment")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "OK"),
//            @ApiResponse(code = 400, message = "Bad Request"),
//            @ApiResponse(code = 409, message = "Conflict")
//    })
//    @GetMapping(value = {"/enlistments/deploy/smartcontractdeployed"})
//    public ResponseEntity<String> getDeployedSmartContractTest() {
//        String result = propertyEnlistmentService.loadSmartContractDeployed();
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    @ApiOperation(value = "approveEnlistment", notes = "approveEnlistment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 409, message = "Conflict")
    })
    @PostMapping(value = {"/enlistments/{enlistmentId}/approve"})
    public ResponseEntity<PropertyEnlistment> approveEnlistment(@PathVariable long enlistmentId) {
        propertyEnlistmentService.approveEnlistment(enlistmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "cancelEnlistment", notes = "cancelEnlistment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 409, message = "Conflict")
    })
    @PostMapping(value = {"/enlistments/{enlistmentId}/cancel"})
    public ResponseEntity<PropertyEnlistment> cancelEnlistment(@PathVariable long enlistmentId) {
        propertyEnlistmentService.cancelEnlistment(enlistmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "rejectEnlistment", notes = "rejectEnlistment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 409, message = "Conflict")
    })
    @PostMapping(value = {"/enlistments/{enlistmentId}/reject"})
    public ResponseEntity<PropertyEnlistment> rejectEnlistment(@PathVariable long enlistmentId) {
        propertyEnlistmentService.rejectEnlistment(enlistmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // todo handle errors
}
