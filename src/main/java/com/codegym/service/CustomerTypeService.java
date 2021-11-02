package com.codegym.service;

import com.codegym.model.CustomerType;

public interface CustomerTypeService {
    Iterable<CustomerType> findAll();
    CustomerType findById(int id);
    void save(CustomerType customerType);
    void remove(int id);
}
