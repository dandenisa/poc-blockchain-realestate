package com.poc.realestate.demo.controller;

import com.poc.realestate.demo.model.PropertyEnlistment;
import com.poc.realestate.demo.serviceInterfaces.PropertyEnlistmentService;
import com.poc.realestate.demo.tos.PropertyEnlistmentTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    @Qualifier("mapperFacade")
    private MapperFacade mapper;

    @ApiOperation(value = "Create new enlistment",
            notes = "Create new enlistment")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 409, message = "Conflict")
    })
    @PostMapping(value = {"/enlistments"})

    public ResponseEntity<PropertyEnlistment> createEnlistment(@RequestBody PropertyEnlistment propertyEnlistment) {
        // PropertyEnlistment pe = mapper.map(propertyEnlistmentTO, PropertyEnlistment.class);
        PropertyEnlistment property = propertyEnlistmentService.createEnlistment(propertyEnlistment);
        return new ResponseEntity<>(property, HttpStatus.CREATED);
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
