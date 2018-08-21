package com.poc.realestate.demo.repository;

import com.poc.realestate.demo.model.PropertyEnlistment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyEnlistmentRepository extends JpaRepository<PropertyEnlistment, Long> {
}
