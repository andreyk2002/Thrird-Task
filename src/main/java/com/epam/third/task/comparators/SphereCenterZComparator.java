package com.epam.third.task.comparators;

import com.epam.third.task.entities.SphereWithId;

import java.util.Comparator;

public class SphereCenterZComparator implements Comparator<SphereWithId> {
    @Override
    public int compare(SphereWithId firstSphere, SphereWithId secondSphere) {
        double zFirst = firstSphere.getCenterZ();
        double zSecond = secondSphere.getCenterZ();
        return Double.compare(zFirst, zSecond);
    }
}
