package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.model.Gender;
import com.codegym.repository.GenderRepository;
import com.codegym.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    GenderRepository genderRepository;
    @Override
    public Iterable<Gender> findAll() {
        return genderRepository.findAll();
    }
}
