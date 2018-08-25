package com.poc.realestate.demo.serviceInterfaces;

import com.poc.realestate.demo.model.RentalAgreement;
import com.poc.realestate.demo.tos.OfferTO;

public interface PropertyEnlistmentSmartContractService {

    String sendOfferToSmartContract(String contractAddress, OfferTO offer);

    OfferTO getOfferFromSmartContract(String contractAddress, String tenantEmail);

    String reviewOfferFromSmartContract(String contractAddress, String tenantEmail, boolean approved);

    String sendAgreementToSmartContract(String contractAddress, RentalAgreement agreement);

    RentalAgreement getAgreementFromSmartContract(String contractAddress, String tenantEmail);

    String reviewAgreementFromSmartContract(String contractAddress, String tenantEmail, boolean approved);

    String cancelAgreementFromSmartContract(String contractAddress, String tenantEmail);
}
