package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;
import com.codegym.service.CustomerService;
import com.codegym.service.DuplicateIDException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer create(Customer customer) throws DuplicateIDException{
        try {
            customerRepository.save(customer);
            return customer;
        }catch (DataIntegrityViolationException e){
            throw new DuplicateIDException();
        }
    }

    @Override
    public Customer edit(Customer customer) throws DuplicateIDException {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer remove(String id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        customerRepository.deleteById(id);
        return customer;
    }

    @Override
    public boolean existId(String id) {
        return customerRepository.existsById(id);
    }

    @Override
    public Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable) {
        return customerRepository.findAllByCustomerNameContaining(name, pageable);
    }


}
