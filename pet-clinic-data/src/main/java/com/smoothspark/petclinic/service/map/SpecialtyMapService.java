package com.smoothspark.petclinic.service.map;

import com.smoothspark.petclinic.model.Specialty;
import com.smoothspark.petclinic.service.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by SmoothSpark in 10/30/2018
 */
@Service
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty specialty) {
        super.delete(specialty);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return super.save(specialty);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
