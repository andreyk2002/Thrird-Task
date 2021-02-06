package com.epam.third.task.repository.specifications;

import com.epam.third.task.entities.SphereWithId;

public class SphereIdSpecification implements SphereSpecification {

    private final int id;

    public SphereIdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specified(SphereWithId sphere) {
        int sphereId = sphere.getId();
        return sphereId == id;
    }
}
