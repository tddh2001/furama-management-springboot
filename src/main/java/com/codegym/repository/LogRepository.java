package com.codegym.repository;

import com.codegym.model.Log;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LogRepository extends PagingAndSortingRepository<Log, Long> {
}
