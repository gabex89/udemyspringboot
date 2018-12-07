package com.smoothspark.petclinic.service.springdatajpa;

import com.smoothspark.petclinic.model.Specialty;
import com.smoothspark.petclinic.repository.SpecialtyRepository;
import com.smoothspark.petclinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SmoothSpark in 03/12/2018
 */
@Service
@Profile("springdatajpa")
public class VetSpecialtyJPAService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public VetSpecialtyJPAService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElseGet(Specialty::new);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
