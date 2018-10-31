package com.smoothspark.petclinic.service.map;

import com.smoothspark.petclinic.model.Owner;
import com.smoothspark.petclinic.service.CrudService;

import java.util.Set;

/**
 * Created by SmoothSpark in 10/30/2018
 */
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner t) {
        super.delete(t);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
