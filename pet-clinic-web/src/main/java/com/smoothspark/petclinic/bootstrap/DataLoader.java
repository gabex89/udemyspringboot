package com.smoothspark.petclinic.bootstrap;

import com.smoothspark.petclinic.model.Owner;
import com.smoothspark.petclinic.model.Vet;
import com.smoothspark.petclinic.service.OwnerService;
import com.smoothspark.petclinic.service.VetService;
import com.smoothspark.petclinic.service.map.OwnerServiceMap;
import com.smoothspark.petclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by SmoothSpark in 03/11/2018
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) {

        System.out.println("Creating owners....");

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Jackson");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Jackson");

        ownerService.save(owner2);

        System.out.println("Creating vets....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sam");
        vet2.setLastName("Max");

        vetService.save(vet2);
    }
}
