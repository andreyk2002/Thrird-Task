package com.epam.third.task.comparators;

import com.epam.third.task.entities.Sphere;

import java.util.Comparator;

public class SphereCenterZComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere firstSphere, Sphere secondSphere) {
        double zFirst = firstSphere.getCenterZ();
        double zSecond = secondSphere.getCenterZ();
        return Double.compare(zFirst, zSecond);
    }
}
