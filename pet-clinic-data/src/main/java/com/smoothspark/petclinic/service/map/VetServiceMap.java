package com.smoothspark.petclinic.service.map;

import com.smoothspark.petclinic.model.Speciality;
import com.smoothspark.petclinic.model.Vet;
import com.smoothspark.petclinic.service.SpecialityService;
import com.smoothspark.petclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by SmoothSpark in 10/30/2018
 */
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
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
        Set<Speciality> specialities = vet.getSpecialities();
        if (specialities.size() > 0) {
            specialities.forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpec = specialityService.save(speciality);
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
