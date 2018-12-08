package com.smoothspark.petclinic.service.map;

import com.smoothspark.petclinic.model.PetType;
import com.smoothspark.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by SmoothSpark in 05/11/2018
 */
@Service
@Profile({"default", "map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType t) {
        super.delete(t);
    }

    @Override
    public PetType save(PetType t) {
        return super.save(t);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
