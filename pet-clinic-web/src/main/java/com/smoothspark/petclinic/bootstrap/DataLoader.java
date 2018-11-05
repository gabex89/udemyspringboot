package com.smoothspark.petclinic.bootstrap;

import com.smoothspark.petclinic.model.Owner;
import com.smoothspark.petclinic.model.Pet;
import com.smoothspark.petclinic.model.PetType;
import com.smoothspark.petclinic.model.Vet;
import com.smoothspark.petclinic.service.OwnerService;
import com.smoothspark.petclinic.service.PetTypeService;
import com.smoothspark.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by SmoothSpark in 03/11/2018
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Creating owners....");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Jackson");
        owner1.setAddress("123 Brickler");
        owner1.setCity("Miami");
        owner1.setTelephone("123123123123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Jackson");
        owner2.setAddress("123 Brickler");
        owner2.setCity("Miami");
        owner2.setTelephone("123123123123");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("JustACat");
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Creating vets....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Max");

        vetService.save(vet2);
    }
}
