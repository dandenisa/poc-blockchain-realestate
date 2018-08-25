package com.poc.realestate.demo.serviceImplementations;

import com.poc.realestate.demo.model.PropertyEnlistment;
import com.poc.realestate.demo.model.RentalAgreement;
import com.poc.realestate.demo.serviceInterfaces.PropertyEnlistmentService;
import com.poc.realestate.demo.serviceInterfaces.PropertyEnlistmentSmartContractService;
import com.poc.realestate.demo.serviceInterfaces.RentalAgreementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service(value = "agreementService")
public class RentalAgreementServiceImpl implements RentalAgreementService {

    @Autowired
    private PropertyEnlistmentSmartContractService contractService;

    @Autowired
    private PropertyEnlistmentService propertyEnlistmentService;

    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public boolean createAgreement(long enlistmentId, RentalAgreement agreement) {
        String response = null;
        Optional<PropertyEnlistment> enlistment = propertyEnlistmentService.getPropertyEnlistmentById(enlistmentId);
        if (enlistment.isPresent()) {
            response = contractService.sendAgreementToSmartContract(enlistment.get().getContractAddress(), agreement);
        }
        return response != null;

    }

    @Override
    @Transactional
    public RentalAgreement getAgreement(long enlistmentId, String tenantEmail) {

        RentalAgreement response = null;
        Optional<PropertyEnlistment> enlistment = propertyEnlistmentService.getPropertyEnlistmentById(enlistmentId);
        if (enlistment.isPresent()) {
            response = contractService.getAgreementFromSmartContract(enlistment.get().getContractAddress(), tenantEmail);
        }
        return response;
    }

    @Override
    @Transactional
    public String reviewAgreement(long enlistmentId, String tenantEmail, boolean approved) {

        String response = null;
        Optional<PropertyEnlistment> enlistment = propertyEnlistmentService.getPropertyEnlistmentById(enlistmentId);
        if (enlistment.isPresent()) {
            response = contractService.reviewAgreementFromSmartContract(enlistment.get().getContractAddress(), tenantEmail, approved);
        }
        return response;
    }

    @Override
    @Transactional
    public String signAgreement(long enlistmentId, String tenantEmail, String signingParty, String signatureHash) {
        return "";
        //todo check ipfs
    }

    @Override
    @Transactional
    public String cancelAgreement(long enlistmentId, String tenantEmail) {

        String response = null;
        Optional<PropertyEnlistment> enlistment = propertyEnlistmentService.getPropertyEnlistmentById(enlistmentId);
        if (enlistment.isPresent()) {
            response = contractService.cancelAgreementFromSmartContract(enlistment.get().getContractAddress(), tenantEmail);
        }
        return response;
    }

}
