package com.epam.third.task.comparators;

import com.epam.third.task.entities.SphereWithId;

import java.util.Comparator;

public class SphereRadiusComparator implements Comparator<SphereWithId> {

    @Override
    public int compare(SphereWithId firstSphere, SphereWithId secondSphere) {
        double radiusFirst = firstSphere.getRadius();
        double radiusSecond = secondSphere.getRadius();
        return Double.compare(radiusFirst, radiusSecond);
    }
}
