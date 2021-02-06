package com.epam.third.task.comparators;

import com.epam.third.task.entities.SphereWithId;

import java.util.Comparator;

public class SphereCenterXComparator implements Comparator<SphereWithId> {

    @Override
    public int compare(SphereWithId firstSphere, SphereWithId secondSphere) {
        double xFirst = firstSphere.getCenterX();
        double xSecond = secondSphere.getCenterX();
        return Double.compare(xFirst, xSecond);
    }
}
