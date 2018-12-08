package com.smoothspark.petclinic.service.map;

import com.smoothspark.petclinic.model.Owner;
import com.smoothspark.petclinic.model.Pet;
import com.smoothspark.petclinic.model.PetType;
import com.smoothspark.petclinic.service.OwnerService;
import com.smoothspark.petclinic.service.PetService;
import com.smoothspark.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by SmoothSpark in 10/30/2018
 */
@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

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
        if (owner != null) {
            if (owner.getPets() != null) {
                owner.getPets().forEach(pet -> {
                    PetType petType = pet.getPetType();
                    if (petType != null) {
                        if (petType.getId() == null) {
                            pet.setPetType(petTypeService.save(petType));
                        }
                    } else {
                        throw new RuntimeException("Pet type cannot be null");
                    }
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
