package com.codegym.repository;

import com.codegym.model.Gender;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GenderRepository extends PagingAndSortingRepository<Gender, Integer> {
}
