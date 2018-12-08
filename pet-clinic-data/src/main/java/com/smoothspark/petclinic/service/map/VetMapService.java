package com.smoothspark.petclinic.service.map;

import com.smoothspark.petclinic.model.Specialty;
import com.smoothspark.petclinic.model.Vet;
import com.smoothspark.petclinic.service.SpecialtyService;
import com.smoothspark.petclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by SmoothSpark in 10/30/2018
 */
@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

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
        Set<Specialty> specialities = vet.getSpecialties();
        if (specialities.size() > 0) {
            specialities.forEach(speciality -> {
                if (speciality.getId() == null) {
                    Specialty savedSpec = specialtyService.save(speciality);
                    speciality.setId(savedSpec.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
