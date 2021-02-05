package com.epam.third.task.comparators;

import com.epam.third.task.entities.Point;
import com.epam.third.task.entities.Sphere;

import java.util.Comparator;

public class  SphereCenterXComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere firstSphere, Sphere secondSphere) {
        double xFirst = firstSphere.getCenterX();
        double xSecond = secondSphere.getCenterX();
        return Double.compare(xFirst, xSecond);
    }
}
