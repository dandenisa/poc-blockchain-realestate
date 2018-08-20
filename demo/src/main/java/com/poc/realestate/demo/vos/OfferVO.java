package com.poc.realestate.demo.vos;

public class OfferVO {

    private Long id;
    int amount;
    String tenantName;

    String tenantEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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


    public OfferVO(int amount, String tenantName, String tenantEmail) {
        this.amount = amount;
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
    }
}
