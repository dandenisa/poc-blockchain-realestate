package com.poc.realestate.demo.model;

import com.poc.realestate.demo.model.enums.OfferStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "properties")
public class PropertyEnlistment extends AuditModel {
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(name = "question_generator", sequenceName = "question_sequence", initialValue = 1000)
    private Long id;

    @Column(name = "landlord_name")
    private String landlordName;

    @Column(name = "landlord_email")
    private String landlordEmail;


    @Column(name = "landlord_identifier")
    private String landlordIdentifier;

    @Column(name = "property_address")
    private String propertyAddress;

    @Column(name = "details")
    private String details;

    @Column(name = "contract_address")
    private String contractAddress;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OfferStatus status;

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getLandlordIdentifier() {
        return landlordIdentifier;
    }

    public void setLandlordIdentifier(String landlordIdentifier) {
        this.landlordIdentifier = landlordIdentifier;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public OfferStatus getStatus() {
        return status;
    }

    public void setStatus(OfferStatus status) {
        this.status = status;
    }

    public PropertyEnlistment(String contractAddress, String landlordName, String landlordEmail, String landlordIdentifier, String propertyAddress, String details) {
        this.contractAddress = contractAddress;
        this.landlordName = landlordName;
        this.landlordIdentifier = landlordIdentifier;
        this.propertyAddress = propertyAddress;
        this.landlordEmail = landlordEmail;
        this.details = details;
        this.status = OfferStatus.PENDING;
    }

    public PropertyEnlistment() {
    }

    public String getLandlordEmail() {
        return landlordEmail;
    }

    public void setLandlordEmail(String landlordEmail) {
        this.landlordEmail = landlordEmail;
    }

    public void approve() {
        this.status = OfferStatus.APPROVED;
    }

    public void reject() {
        this.status = OfferStatus.REJECTED;
    }

    public void cancel() {
        this.status = OfferStatus.CANCELLED;
    }

}
