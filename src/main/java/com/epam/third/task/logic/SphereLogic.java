package com.epam.third.task.logic;

import com.epam.third.task.entities.Point;
import com.epam.third.task.entities.Sphere;

public class SphereLogic {

    public boolean isSphere(double radius) {
        return radius > 0;
    }

    public boolean isTouchesCoordinatePlates(Sphere sphere) {
        Point center = sphere.getCenter();
        double x = center.getX();
        double y = center.getY();
        double z = center.getZ();
        double radius = sphere.getRadius();
        if (Math.abs(x) == radius) {
            return true;
        }
        if (Math.abs(y) == radius) {
            return true;
        }
        return Math.abs(z) == radius;
    }

    public double countVolume(Sphere sphere) {
        double radius = sphere.getRadius();
        double result = Math.pow(radius, 3);
        result *= Math.PI;
        result *= 4;
        result /= 3;
        return result;
    }

    public double countSurfaceArea(Sphere sphere) {
        double radius = sphere.getRadius();
        double result = Math.pow(radius, 2);
        result *= Math.PI;
        result *= 4;
        return result;
    }

    //two of tree points coordinates should match radius coordinates
    //formula : ratio = 4R^3/(3h * (R - 1/3 * h) ) - 1
    public double countVolumeRatioByCrossingPlane(Sphere sphere, double distanceFromCenter) {
        if (distanceFromCenter == 0) {
            return 1;
        }
        double radius = sphere.getRadius();
        if (notBelongsToSphere(distanceFromCenter, radius)) {
            return Double.POSITIVE_INFINITY;
        }
        double ratio = Math.pow(radius, 3);
        ratio *= 4. / 3.;
        ratio /= Math.pow(distanceFromCenter, 2);
        ratio /= radius - 1. / 3. * distanceFromCenter;
        ratio--;
        return ratio;
    }

    private boolean notBelongsToSphere(double h, double radius) {
        return h > radius;
    }
}
