package com.epam.third.task.repository.specifications;

import com.epam.third.task.entities.SphereWithId;

public interface SphereSpecification {

    boolean specified(SphereWithId sphere);
}
