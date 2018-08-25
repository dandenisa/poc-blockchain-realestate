package com.poc.realestate.demo.tos;

import java.math.BigInteger;

public class OfferTO {

    private Long id;
    private boolean initialized;
    private BigInteger amount;
    private String tenantName;
    private String tenantEmail;
    private String status;
    private BigInteger idk;

    public OfferTO(boolean initialized, BigInteger amount, String tenantName, String tenantEmail, BigInteger idk) {
        this.initialized = initialized;
        this.amount = amount;
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
        this.idk = idk;
    }

    public OfferTO() {
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getIdk() {
        return idk;
    }

    public void setIdk(BigInteger idk) {
        this.idk = idk;
    }
}
