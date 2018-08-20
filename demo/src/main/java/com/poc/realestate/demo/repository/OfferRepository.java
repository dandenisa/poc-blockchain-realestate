package com.poc.realestate.demo.repository;

import com.poc.realestate.demo.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
