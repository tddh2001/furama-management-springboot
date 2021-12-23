package com.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.codegym.model.Position;

@Service
public interface PositionRepository extends JpaRepository<Position, Integer> {
}
