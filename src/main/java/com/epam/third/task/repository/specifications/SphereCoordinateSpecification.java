package com.epam.third.task.repository.specifications;

import com.epam.third.task.entities.Point;
import com.epam.third.task.entities.Sphere;

public class SphereCoordinateSpecification implements SphereSpecification {

    private final boolean xShouldBeNegative;
    private final boolean yShouldBeNegative;
    private final boolean zShouldBeNegative;

    public SphereCoordinateSpecification(boolean xShouldBeNegative,
                                         boolean yShouldBeNegative, boolean zShouldBeNegative) {
        this.xShouldBeNegative = xShouldBeNegative;
        this.yShouldBeNegative = yShouldBeNegative;
        this.zShouldBeNegative = zShouldBeNegative;
    }


    @Override
    public boolean specified(Sphere sphere) {
        Point center = sphere.getCenter();
        double x = center.getX();
        double y = center.getY();
        double z = center.getZ();

        if ((x < 0) != xShouldBeNegative) {
            return false;
        }
        if ((y < 0) != yShouldBeNegative) {
            return false;
        }
        return (z < 0) == zShouldBeNegative;
    }
}
