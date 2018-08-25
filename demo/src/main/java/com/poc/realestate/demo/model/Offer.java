package com.poc.realestate.demo.model;

import com.poc.realestate.demo.model.enums.OfferStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "offers")
public class Offer extends AuditModel {

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(name = "question_generator", sequenceName = "question_sequence", initialValue = 1000)
    private Long id;

    @ManyToOne(targetEntity = PropertyEnlistment.class)
    @JoinColumn(name = "enlistment_id", referencedColumnName = "id")
    private long enlistmentId;

    @Column(name = "amount")
    private long amount;

    @Column(name = "tenant_name")
    private String tenantName;

    @Column(name = "tenant_email")
    private String tenantEmail;

    @Column(name = "status")
    private OfferStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
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

    public OfferStatus getStatus() {
        return status;
    }

    public void setStatus(OfferStatus status) {
        this.status = status;
    }

    public Offer(String tenantName, String tenantEmail, long amount) {
        this.amount = amount;
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
        this.status = OfferStatus.PENDING;
    }

    public long getEnlistmentId() {
        return enlistmentId;
    }

    public void setEnlistmentId(long enlistmentId) {
        this.enlistmentId = enlistmentId;
    }
}
