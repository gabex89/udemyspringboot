package com.smoothspark.petclinic.repository;

import com.smoothspark.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by SmoothSpark in 02/12/2018
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
