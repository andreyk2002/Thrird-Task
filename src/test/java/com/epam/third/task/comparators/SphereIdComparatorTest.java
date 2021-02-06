package com.epam.third.task.comparators;

import com.epam.third.task.entities.SphereWithId;

import java.util.Comparator;

public class SphereIdComparatorTest extends SphereComparatorTest{
    @Override
    protected Comparator<SphereWithId> getComparator() {
        return new SphereIdComparator();
    }
}
