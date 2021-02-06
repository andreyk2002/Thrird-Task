package com.epam.third.task.entities;

public class SphereWithId extends Sphere {
    private final int id;

    public SphereWithId(int id, double radius, Point center) {
        super(radius, center);
        this.id = id;
    }

    public SphereWithId(int id, double radius, double x, double y, double z) {
        this(id, radius, new Point(x, y, z));
    }

    public int getId() {
        return id;
    }
}
