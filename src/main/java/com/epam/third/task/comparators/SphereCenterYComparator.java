package com.epam.third.task.comparators;

import com.epam.third.task.entities.Sphere;

import java.util.Comparator;

public class SphereCenterYComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere firstSphere, Sphere secondSphere) {
        double yFirst = firstSphere.getCenterY();
        double ySecond = secondSphere.getCenterY();
        return Double.compare(yFirst, ySecond);
    }
}
