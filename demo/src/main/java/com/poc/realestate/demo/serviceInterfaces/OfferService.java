package com.poc.realestate.demo.serviceInterfaces;

import com.poc.realestate.demo.model.Offer;
import com.poc.realestate.demo.tos.OfferTO;

public interface OfferService {

    boolean createOffer(long enlistmentId, OfferTO offer);

    OfferTO getOffer(long enlistmentId, String tenantEmail);

    String reviewOffer(long enlistmentId, String tenantEmail, boolean approved);

    Offer getOfferFromRepository(long offerId, long id);

    Offer reviewOfferFromRepository(long offerId, String tenantCnp, boolean approved);

}
