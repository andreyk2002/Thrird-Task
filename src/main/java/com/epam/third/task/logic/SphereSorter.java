package com.epam.third.task.logic;


import com.epam.third.task.entities.SphereWithId;

import java.util.Comparator;
import java.util.List;

public class SphereSorter {

    public void sort(List<SphereWithId> spheres, Comparator<SphereWithId> comparator) {
        spheres.sort(comparator);
    }
}
