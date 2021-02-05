package com.epam.third.task.logic;


import com.epam.third.task.entities.Sphere;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class SphereSorter {

    public void sort(List<Sphere> spheres, Comparator<Sphere>comparator){
        spheres.sort(comparator);
    }
}
