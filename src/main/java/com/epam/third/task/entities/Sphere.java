package com.epam.third.task.entities;

import java.util.Objects;

public class Sphere {

    private final Point center;
    private final double radius;

    public Sphere(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Sphere( double radius, double x, double y, double z) {
        this.center = new Point(x,y,z);
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sphere)) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0 && center.equals(sphere.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}
