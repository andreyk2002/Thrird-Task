package com.epam.third.task.repository;

import com.epam.third.task.entities.Sphere;
import com.epam.third.task.entities.SphereWithId;
import com.epam.third.task.repository.specifications.SphereSpecification;

import java.util.List;

public interface SphereRepository {

    void addSphere(SphereWithId sphere);

    void removeSphere(SphereWithId sphere);

    void updateSphere(SphereWithId sphere);

    List<Sphere> query(SphereSpecification specification);
}
