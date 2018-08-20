package com.poc.realestate.demo.serviceInterfaces;

import com.poc.realestate.demo.model.Offer;
import com.poc.realestate.demo.tos.OfferTO;

public interface OfferService {
    // OfferTO createOffer(String offererName, String offererEmail, long amount);
    Offer createOffer(String offererName, String offererEmail, long amount);
}
