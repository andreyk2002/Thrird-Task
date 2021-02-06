package com.epam.third.task.comparators;

import com.epam.third.task.entities.SphereWithId;

import java.util.Comparator;

public class SphereIdComparator implements Comparator<SphereWithId> {

    @Override
    public int compare(SphereWithId firstSphere, SphereWithId secondSphere) {
        int firstId = firstSphere.getId();
        int secondId = secondSphere.getId();
        return Integer.compare(firstId, secondId);
    }
}
