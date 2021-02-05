package com.epam.third.task.repository.specifications;

import com.epam.third.task.entities.Sphere;

public class SphereIdSpecification implements SphereSpecification {

    private final int id;

    public SphereIdSpecification(int id){
        this.id = id;
    }

    @Override
    public boolean specified(Sphere sphere) {
        int sphereId = sphere.getId();
        return sphereId == id;
    }
}
