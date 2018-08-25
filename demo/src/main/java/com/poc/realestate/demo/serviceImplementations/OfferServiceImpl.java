package com.poc.realestate.demo.serviceImplementations;

import com.poc.realestate.demo.model.Offer;
import com.poc.realestate.demo.model.PropertyEnlistment;
import com.poc.realestate.demo.repository.OfferRepository;
import com.poc.realestate.demo.serviceInterfaces.OfferService;
import com.poc.realestate.demo.serviceInterfaces.PropertyEnlistmentService;
import com.poc.realestate.demo.serviceInterfaces.PropertyEnlistmentSmartContractService;
import com.poc.realestate.demo.tos.OfferTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service(value = "offerService")
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private PropertyEnlistmentSmartContractService contractService;

    @Autowired
    private PropertyEnlistmentService propertyEnlistmentService;

    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public boolean createOffer(long enlistmentId, OfferTO offer) {
        String response = null;
        Optional<PropertyEnlistment> enlistment = propertyEnlistmentService.getPropertyEnlistmentById(enlistmentId);
        if (enlistment.isPresent()) {
            response = contractService.sendOfferToSmartContract(enlistment.get().getContractAddress(), offer);
        }
        //        offerRepository.save(offer);???
        return response != null;
    }

    @Override
    @Transactional
    public OfferTO getOffer(long enlistmentId, String tenantEmail) {

        OfferTO response = null;
        Optional<PropertyEnlistment> enlistment = propertyEnlistmentService.getPropertyEnlistmentById(enlistmentId);
        if (enlistment.isPresent()) {
            response = contractService.getOfferFromSmartContract(enlistment.get().getContractAddress(), tenantEmail);
        }
        return response;
    }

    @Override
    @Transactional
    public String reviewOffer(long enlistmentId, String tenantEmail, boolean approved) {
        String response = null;
        Optional<PropertyEnlistment> enlistment = propertyEnlistmentService.getPropertyEnlistmentById(enlistmentId);
        if (enlistment.isPresent()) {
            response = contractService.reviewOfferFromSmartContract(enlistment.get().getContractAddress(), tenantEmail, approved);
        }
        return response;
    }

    public Offer getOfferFromRepository(long offerId, long id) {
        Optional<Offer> property = offerRepository.findById(offerId);

        if (property.isPresent()) {
            return property.get();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Offer reviewOfferFromRepository(long offerId, String tenantCnp, boolean approved) {
        Optional<Offer> property = offerRepository.findById(offerId);

        if (property.isPresent()) {
            return property.get();
        } else {
            throw new IllegalArgumentException();
        }
    }
}