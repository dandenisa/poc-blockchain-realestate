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
//
//@TypeDef(
//        name = "address",
//        defaultForType = Address.class,
//        typeClass = Address.class
//)

@Entity
@Table(name = "properties")
public class PropertyEnlistment extends AuditModel {
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "landlordName")
    private String landlordName;

    @Column(name = "landlordDetails")
    private String landlordCnp;

//    @Column(name = "propertyAddress")
//    //@Type(type = "address")
//    @Type(type = "com.poc.realestate.demo.model.Address", parameters = @Parameter(name="class", value = "com.poc.realestate.demo.model.Address"))
//    private Address propertyAddress; // todo redo this

    @Column(name = "contractAddress")
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

    public String getLandlordCnp() {
        return landlordCnp;
    }

    public void setLandlordCnp(String landlordCnp) {
        this.landlordCnp = landlordCnp;
    }

//    public Address getPropertyAddress() {
//        return propertyAddress;
//    }
//
//    public void setPropertyAddress(Address propertyAddress) {
//        this.propertyAddress = propertyAddress;
//    }

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

    public PropertyEnlistment(String landlordName, String landlordCnp, Address propertyAddress, String contractAddress, OfferStatus status) {
        this.landlordName = landlordName;
        this.landlordCnp = landlordCnp;
        //  this.propertyAddress = propertyAddress;
        this.contractAddress = contractAddress;
        this.status = OfferStatus.PENDING;
    }

    public PropertyEnlistment() {
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
