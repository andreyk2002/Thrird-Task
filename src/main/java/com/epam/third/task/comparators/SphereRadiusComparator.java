package com.epam.third.task.comparators;

import com.epam.third.task.entities.Sphere;

import java.util.Comparator;

public class SphereRadiusComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere firstSphere, Sphere secondSphere) {
        double radiusFirst = firstSphere.getRadius();
        double radiusSecond = secondSphere.getRadius();
        return Double.compare(radiusFirst, radiusSecond);
    }
}
