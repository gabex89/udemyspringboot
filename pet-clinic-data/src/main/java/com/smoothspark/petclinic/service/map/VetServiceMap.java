package com.smoothspark.petclinic.service.map;

import com.smoothspark.petclinic.model.Vet;
import com.smoothspark.petclinic.service.CrudService;

import java.util.Set;

/**
 * Created by SmoothSpark in 10/30/2018
 */
public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
