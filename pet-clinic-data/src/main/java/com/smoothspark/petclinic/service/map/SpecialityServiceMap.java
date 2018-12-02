package com.smoothspark.petclinic.service.map;

import com.smoothspark.petclinic.model.Speciality;
import com.smoothspark.petclinic.service.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by SmoothSpark in 10/30/2018
 */
@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
