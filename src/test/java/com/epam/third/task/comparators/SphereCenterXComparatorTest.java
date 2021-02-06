package com.epam.third.task.comparators;

import com.epam.third.task.entities.SphereWithId;

import java.util.Comparator;

public class SphereCenterXComparatorTest extends SphereComparatorTest{
    @Override
    protected Comparator<SphereWithId> getComparator() {
        return new SphereCenterXComparator();
    }

}
