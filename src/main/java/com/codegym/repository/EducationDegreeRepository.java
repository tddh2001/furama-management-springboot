package com.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.codegym.model.EducationDegree;

@Service
public interface EducationDegreeRepository  extends JpaRepository<EducationDegree, Integer> {
}
