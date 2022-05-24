package com.portfolio.repo;

import com.portfolio.domain.PotentialEmployer;
import org.springframework.data.repository.CrudRepository;

public interface EmployerRepository extends CrudRepository<PotentialEmployer,Long> {
}
