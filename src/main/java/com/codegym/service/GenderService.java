package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Gender;

public interface GenderService {
    Iterable<Gender> findAll();
}
