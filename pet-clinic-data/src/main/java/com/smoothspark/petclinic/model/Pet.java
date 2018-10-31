package com.smoothspark.petclinic.model;

import java.time.LocalDate;

/**
 * Created by SmoothSpark in 2018. 10. 12.
 */
public class Pet {

    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
