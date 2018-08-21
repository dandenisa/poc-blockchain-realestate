package com.poc.realestate.demo.serviceImplementations;

import com.poc.realestate.demo.model.PropertyEnlistment;
import com.poc.realestate.demo.repository.PropertyEnlistmentRepository;
import com.poc.realestate.demo.serviceInterfaces.PropertyEnlistmentService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service(value = "propertyEnlistmentService")
public class PropertyEnlistmentServiceImpl implements PropertyEnlistmentService {

    @Autowired
    private PropertyEnlistmentRepository propertyEnlistmentRepository;

    @Autowired
    @Qualifier("mapperFacade")
    private MapperFacade mapper;

    @Override
    @Transactional
    public PropertyEnlistment createEnlistment(PropertyEnlistment propertyEnlistment) {
        return propertyEnlistmentRepository.save(propertyEnlistment);
    }

    @Override
    @Transactional
    public PropertyEnlistment getEnlistment(long id) {
        Optional<PropertyEnlistment> property = propertyEnlistmentRepository.findById(id);

        if (property.isPresent()) {
            return property.get();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    @Transactional
    public void approveEnlistment(long id) {
        Optional<PropertyEnlistment> property = propertyEnlistmentRepository.findById(id);

        if (property.isPresent()) {
            property.get().approve();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    @Transactional
    public void rejectEnlistment(long id) {
        Optional<PropertyEnlistment> property = propertyEnlistmentRepository.findById(id);

        if (property.isPresent()) {
            property.get().reject();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    @Transactional
    public void cancelEnlistment(long id) {
        Optional<PropertyEnlistment> property = propertyEnlistmentRepository.findById(id);

        if (property.isPresent()) {
            property.get().cancel();
        } else {
            throw new IllegalArgumentException();
        }
    }
}