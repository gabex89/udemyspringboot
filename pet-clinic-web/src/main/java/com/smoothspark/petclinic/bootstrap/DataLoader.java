package com.smoothspark.petclinic.bootstrap;

import com.smoothspark.petclinic.model.Owner;
import com.smoothspark.petclinic.model.Pet;
import com.smoothspark.petclinic.model.PetType;
import com.smoothspark.petclinic.model.Specialty;
import com.smoothspark.petclinic.model.Vet;
import com.smoothspark.petclinic.model.Visit;
import com.smoothspark.petclinic.service.OwnerService;
import com.smoothspark.petclinic.service.PetTypeService;
import com.smoothspark.petclinic.service.SpecialtyService;
import com.smoothspark.petclinic.service.VetService;
import com.smoothspark.petclinic.service.VisitService;
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
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Specialty specialty1 = new Specialty();
        specialty1.setDescription("Radiology");
        Specialty savedSpecialty1 = specialtyService.save(specialty1);

        Specialty specialty2 = new Specialty();
        specialty2.setDescription("Surgery");
        Specialty savedSpecialty2 = specialtyService.save(specialty2);

        Specialty specialty3 = new Specialty();
        specialty3.setDescription("Dentistry");
        Specialty savedSpecialty3 = specialtyService.save(specialty3);

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

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setLocalDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedSpecialty1);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Max");
        vet1.getSpecialties().add(savedSpecialty2);

        vetService.save(vet2);
    }
}
