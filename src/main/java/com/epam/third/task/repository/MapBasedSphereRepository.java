package com.epam.third.task.repository;

import com.epam.third.task.entities.Sphere;
import com.epam.third.task.entities.SphereWithId;
import com.epam.third.task.repository.specifications.SphereSpecification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapBasedSphereRepository implements SphereRepository {

    private final Map<Integer, SphereWithId> spheres = new HashMap<>();

    @Override
    public void addSphere(SphereWithId sphere) {
        int id = sphere.getId();
        spheres.put(id, sphere);
    }

    @Override
    public void removeSphere(SphereWithId sphere) {
        int id = sphere.getId();
        spheres.remove(id);
    }

    @Override
    public void updateSphere(SphereWithId sphere) {
        int id = sphere.getId();
        Sphere sphereToUpdate = spheres.get(id);
        double newRadius = sphere.getRadius();
        sphereToUpdate.changeRadius(newRadius);
    }

    @Override
    public List<Sphere> query(SphereSpecification specification) {
        List<Sphere> results = new ArrayList<>();
        for (SphereWithId sphere : spheres.values()) {
            if (specification.specified(sphere)) {
                results.add(sphere);
            }
        }
        return results;
    }
}
