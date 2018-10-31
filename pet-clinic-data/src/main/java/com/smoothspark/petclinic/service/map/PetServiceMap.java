package com.smoothspark.petclinic.service.map;

import com.smoothspark.petclinic.model.Pet;
import com.smoothspark.petclinic.service.CrudService;

import java.util.Set;

/**
 * Created by SmoothSpark in 10/30/2018
 */
public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet t) {
        super.delete(t);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
