package com.epam.third.task.comparators;

import com.epam.third.task.entities.Sphere;

import java.util.Comparator;

public class SphereIdComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere firstSphere, Sphere secondSphere) {
        int firstId = firstSphere.getId();
        int secondId = secondSphere.getId();
        return Integer.compare(firstId, secondId);
    }
}
