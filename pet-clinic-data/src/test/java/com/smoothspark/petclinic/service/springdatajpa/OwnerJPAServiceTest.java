package com.smoothspark.petclinic.service.springdatajpa;

import com.smoothspark.petclinic.model.Owner;
import com.smoothspark.petclinic.repository.OwnerRepository;
import com.smoothspark.petclinic.repository.PetRepository;
import com.smoothspark.petclinic.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

    private static final String LAST_NAME = "Smith";
    private static final Owner RETURNED_OWNER = Owner.builder().id(1L).lastName(LAST_NAME).build();

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJPAService ownerJPAService;


    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(RETURNED_OWNER);

        Owner owner = ownerJPAService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnedOwnerSet = new HashSet<>();
        returnedOwnerSet.add(Owner.builder().id(1L).build());
        returnedOwnerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnedOwnerSet);

        Set<Owner> owners = ownerJPAService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(RETURNED_OWNER));

        Owner owner = ownerJPAService.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(RETURNED_OWNER);

        Owner owner = ownerJPAService.save(Owner.builder().id(1L).build());

        assertNotNull(owner);
    }

    @Test
    void delete() {
        ownerJPAService.delete(Owner.builder().id(1L).build());

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerJPAService.deleteById(1L);

        verify(ownerRepository).deleteById(any());
    }
}