package com.epam.third.task.entities;

import com.epam.third.task.logic.IdGenerator;

public class Sphere {

    private final Point center;
    private double radius;
    private final IdGenerator generator = new IdGenerator();

    public Sphere(double radius, Point center) {
        this.center = center;
        this.radius = radius;
    }

    public Sphere(double radius, double x, double y, double z) {
        this(radius, new Point(x, y, z));
    }

    //setRadius
    public void changeRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getCenterX(){
        return center.getX();
    }

    public double getCenterY(){
        return center.getY();
    }

    public double getCenterZ(){
        return center.getZ();
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sphere)) {
            return false;
        }
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0 && center.equals(sphere.center);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((center == null) ? 0 : center.hashCode());
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
