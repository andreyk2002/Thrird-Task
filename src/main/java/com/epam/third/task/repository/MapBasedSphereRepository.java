package com.epam.third.task.repository;

import com.epam.third.task.entities.Sphere;
import com.epam.third.task.repository.specifications.SphereSpecification;

import java.util.*;

public class MapBasedSphereRepository implements SphereRepository{

    private final Map<Integer, Sphere> spheres = new HashMap<>();

    @Override
    public void addSphere(Sphere sphere) {
        int id = sphere.getId();
        spheres.put(id, sphere);
    }

    @Override
    public void removeSphere(Sphere sphere) {
        int id = sphere.getId();
        spheres.remove(id);
    }

    @Override
    public void updateSphere(Sphere sphere) {
        int id = sphere.getId();
        Sphere sphereToUpdate = spheres.get(id);
        double newRadius = sphere.getRadius();
        sphereToUpdate.changeRadius(newRadius);
    }

    @Override
    public List<Sphere> query(SphereSpecification specification) {
        List<Sphere> results = new ArrayList<>();
        for(Sphere sphere : spheres.values()){
            if(specification.specified(sphere)){
                results.add(sphere);
            }
        }
        return  results;
    }
}
