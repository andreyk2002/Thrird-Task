package com.epam.third.task.comparators;

import com.epam.third.task.entities.SphereWithId;

import java.util.Comparator;

public class SphereCenterYComparator implements Comparator<SphereWithId> {
    @Override
    public int compare(SphereWithId firstSphere, SphereWithId secondSphere) {
        double yFirst = firstSphere.getCenterY();
        double ySecond = secondSphere.getCenterY();
        return Double.compare(yFirst, ySecond);
    }
}
