package com.epam.third.task.parsing;

import com.epam.third.task.entities.Sphere;

public class SphereParser {

    private static final String DELIMITERS = " ";

    public Sphere parse(String line) {
        String[] data = line.split(DELIMITERS);

        double radius = Double.parseDouble(data[0]);
        double x = Double.parseDouble(data[1]);
        double y = Double.parseDouble(data[2]);
        double z = Double.parseDouble(data[3]);

        return new Sphere(radius, x, y, z);
    }
}
