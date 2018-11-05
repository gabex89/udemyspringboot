package com.smoothspark.petclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SmoothSpark in 2018. 10. 12.
 */
public class Vet extends Person {

    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
