package com.poc.realestate.demo.model;

import com.poc.realestate.demo.model.enums.AgreementStatus;

import java.math.BigInteger;

public class RentalAgreement {

    String landlordName; // for simplicity, there is only one landlord
    String tenantName; // for simplicity, there is only one tenant and occupants are omitted
    String tenantEmail;
    int amount;
    BigInteger leaseStart;
    BigInteger handoverDate;
    BigInteger leasePeriod;
    String otherTerms;
    String hash;
    String landlordSignedHash;
    String tenantSignedHash;
    AgreementStatus status;

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public BigInteger getLeaseStart() {
        return leaseStart;
    }

    public void setLeaseStart(BigInteger leaseStart) {
        this.leaseStart = leaseStart;
    }

    public BigInteger getHandoverDate() {
        return handoverDate;
    }

    public void setHandoverDate(BigInteger handoverDate) {
        this.handoverDate = handoverDate;
    }

    public BigInteger getLeasePeriod() {
        return leasePeriod;
    }

    public void setLeasePeriod(BigInteger leasePeriod) {
        this.leasePeriod = leasePeriod;
    }

    public String getOtherTerms() {
        return otherTerms;
    }

    public void setOtherTerms(String otherTerms) {
        this.otherTerms = otherTerms;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getLandlordSignedHash() {
        return landlordSignedHash;
    }

    public void setLandlordSignedHash(String landlordSignedHash) {
        this.landlordSignedHash = landlordSignedHash;
    }

    public String getTenantSignedHash() {
        return tenantSignedHash;
    }

    public void setTenantSignedHash(String tenantSignedHash) {
        this.tenantSignedHash = tenantSignedHash;
    }

    public AgreementStatus getStatus() {
        return status;
    }

    public void setStatus(AgreementStatus status) {
        this.status = status;
    }
}
