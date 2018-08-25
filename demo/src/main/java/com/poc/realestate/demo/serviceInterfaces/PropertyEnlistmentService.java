package com.poc.realestate.demo.serviceInterfaces;

import com.poc.realestate.demo.model.PropertyEnlistment;

import java.util.Optional;

public interface PropertyEnlistmentService {

    PropertyEnlistment createEnlistment(PropertyEnlistment propertyEnlistment);

    PropertyEnlistment getEnlistment(long id);

    Optional<PropertyEnlistment> getPropertyEnlistmentById(long id);

    void approveEnlistment(long id);

    void rejectEnlistment(long id);

    void cancelEnlistment(long id);
}
