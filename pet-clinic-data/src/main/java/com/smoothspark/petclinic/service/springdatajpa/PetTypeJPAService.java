package com.smoothspark.petclinic.service.springdatajpa;

import com.smoothspark.petclinic.model.PetType;
import com.smoothspark.petclinic.repository.PetTypeRepository;
import com.smoothspark.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SmoothSpark in 03/12/2018
 */
@Service
@Profile("springdatajpa")
public class PetTypeJPAService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeJPAService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElseGet(PetType::new);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long aLong) {
        deleteById(aLong);
    }
}
