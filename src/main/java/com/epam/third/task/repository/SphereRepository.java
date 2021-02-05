package com.epam.third.task.repository;

import com.epam.third.task.entities.Sphere;
import com.epam.third.task.repository.specifications.SphereSpecification;

import java.util.List;

public interface SphereRepository {

    void addSphere(Sphere sphere);
    void removeSphere(Sphere sphere);
    void updateSphere(Sphere sphere);

    List<Sphere> query(SphereSpecification specification);
}
