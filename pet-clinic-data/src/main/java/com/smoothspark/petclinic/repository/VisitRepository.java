package com.smoothspark.petclinic.repository;

import com.smoothspark.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by SmoothSpark in 02/12/2018
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
