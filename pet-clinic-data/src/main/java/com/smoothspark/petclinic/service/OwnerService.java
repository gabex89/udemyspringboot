package com.smoothspark.petclinic.service;

import com.smoothspark.petclinic.model.Owner;

/**
 * Created by SmoothSpark in 2018. 10. 17.
 */
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
