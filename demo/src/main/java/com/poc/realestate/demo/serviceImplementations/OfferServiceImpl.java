package com.poc.realestate.demo.serviceImplementations;

import com.poc.realestate.demo.model.Offer;
import com.poc.realestate.demo.repository.OfferRepository;
import com.poc.realestate.demo.serviceInterfaces.OfferService;
import com.poc.realestate.demo.tos.OfferTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "offerService")
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

//    @Autowired
//    @Qualifier("mapperFacade")
//    private MapperFacade mapperFacade;

    @Override
    @Transactional
    public Offer createOffer(String offererName, String offererEmail, long amount) {

        try {
            Offer postOffer = new Offer(offererName, offererEmail, amount);
            Offer savedOffer = offerRepository.save(postOffer);
            //   return mapperFacade.map(savedOffer, OfferTO.class);
            return savedOffer;

        } catch (final Exception ex) {
            throw new DataIntegrityViolationException("");
        }
    }
}