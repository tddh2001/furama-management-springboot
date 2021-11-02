package com.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codegym.model.Division;
import com.codegym.repository.DivisionRepository;
import com.codegym.service.DivisionService;

import java.util.List;

@Service
public class DivisionServiceImpl  implements DivisionService {
    @Autowired
    DivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
