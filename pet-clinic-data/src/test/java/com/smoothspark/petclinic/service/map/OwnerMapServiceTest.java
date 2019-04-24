package com.smoothspark.petclinic.service.map;

import com.smoothspark.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {

    private static final Long OWNER_ID = 1L;
    private static final String LAST_NAME = "smith";

    private OwnerMapService ownerMapService;

    @BeforeEach
    public void setup() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        Owner owner = new Owner();
        owner.setId(OWNER_ID);
        owner.setLastName(LAST_NAME);

        ownerMapService.save(owner);

    }

    @Test
    public void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(OWNER_ID);

        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void save() {
        long id = 2L;
        Owner owner = Owner.builder().id(OWNER_ID).build();
        Owner savedOwner = ownerMapService.save(owner);
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(LAST_NAME);

        assertNotNull(owner);

        assertEquals(LAST_NAME, owner.getLastName());
    }
}