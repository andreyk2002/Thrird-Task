package com.epam.third.task.comparators;

import com.epam.third.task.entities.Sphere;

import java.util.Comparator;

public class SphereCenterXComparatorTest extends SphereComparatorTest{
    @Override
    protected Comparator<Sphere> getComparator() {
        return new SphereCenterXComparator();
    }

}