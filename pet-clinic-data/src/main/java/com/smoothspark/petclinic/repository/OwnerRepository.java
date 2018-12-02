package com.smoothspark.petclinic.repository;

import com.smoothspark.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by SmoothSpark in 02/12/2018
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
