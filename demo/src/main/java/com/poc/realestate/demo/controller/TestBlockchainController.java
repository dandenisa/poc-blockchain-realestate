package com.poc.realestate.demo.controller;


import com.poc.realestate.demo.model.TestBlockchainTransaction;
import com.poc.realestate.demo.serviceInterfaces.TestBlockchainService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController

public class TestBlockchainController {

    private final TestBlockchainService service;

    public TestBlockchainController(TestBlockchainService service) {
        this.service = service;
    }

    @PostMapping("/transaction")
    public TestBlockchainTransaction execute(@RequestBody TestBlockchainTransaction transaction) throws IOException {
        return service.process(transaction);
    }
}
