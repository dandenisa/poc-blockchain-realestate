package com.poc.realestate.demo.serviceInterfaces;

import com.poc.realestate.demo.model.RentalAgreement;

public interface RentalAgreementService {

    boolean createAgreement(long enlistmentId, RentalAgreement agreement);

    RentalAgreement getAgreement(long enlistmentId, String tenantEmail);

    String reviewAgreement(long enlistmentId, String tenantEmail, boolean approved);

    String signAgreement(long enlistmentId, String tenantEmail, String signingParty, String signatureHash);

    String cancelAgreement(long enlistmentId, String tenantEmail);
}
