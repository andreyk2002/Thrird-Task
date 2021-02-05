package com.epam.third.task.logic;

import com.epam.third.task.entities.Point;
import com.epam.third.task.entities.Sphere;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Math.PI;

public class SphereCalculatorTest {

    private final SphereCalculator logic = new SphereCalculator();

    private final static Point CENTER = new Point(6, 0, 0);
    private final static Point CENTER_ZERO = new Point(0, 0, 0);
    private final static double DELTA = 0.01;
    private final static int INTEGER_RADIUS = 3;
    private final static double DOUBLE_RADIUS = 4.5;

    @Test
    public void testIsSphereShouldReturnFalseWhenRadiusIsNegative() {
        //given
        double negativeRadius = -1;
        //then
        boolean isSphere = logic.isSphere(negativeRadius);
        //when
        Assert.assertFalse(isSphere);
    }

    @Test
    public void testIsSphereShouldReturnFalseWhenRadiusIsZero() {
        //given
        double zeroRadius = 0;
        //then
        boolean isSphere = logic.isSphere(zeroRadius);
        //when
        Assert.assertFalse(isSphere);
    }

    @Test
    public void testIsSphereShouldReturnTrueWhenRadiusIsPositive() {
        //given
        double positiveRadius = 1;
        //then
        boolean isSphere = logic.isSphere(positiveRadius);
        //when
        Assert.assertTrue(isSphere);
    }

    @Test
    public void testCountVolumeShouldCountWhenRadiusIsInteger() {
        //given
        Sphere sphere = new Sphere(INTEGER_RADIUS, CENTER);
        double expected = PI * 36;
        //when
        double volume = logic.countVolume(sphere);
        //then
        Assert.assertEquals(volume, expected, DELTA);
    }

    @Test
    public void testCountVolumeShouldCountWhenRadiusIsDouble() {
        //given
        Sphere sphere = new Sphere(DOUBLE_RADIUS, CENTER);
        double expected = PI * 121.5;
        //when
        double volume = logic.countVolume(sphere);
        //then
        Assert.assertEquals(volume, expected, DELTA);
    }

    @Test
    public void testCountSurfaceAreaShouldCountWhenRadiusIsInteger() {
        //given
        Sphere sphere = new Sphere(INTEGER_RADIUS, CENTER);
        double expected = 36 * PI;
        //when
        double actual = logic.countSurfaceArea(sphere);
        //then
        Assert.assertEquals(actual, expected, DELTA);
    }

    @Test
    public void testCountSurfaceAreaShouldCountWhenRadiusIsDouble() {
        //given
        Sphere sphere = new Sphere(DOUBLE_RADIUS, CENTER);
        double expected = 81 * PI;
        //when
        double actual = logic.countSurfaceArea(sphere);
        //then
        Assert.assertEquals(actual, expected, DELTA);
    }

    @Test
    public void testIsTouchesCoordinatePlatesShouldConfirmWhenSphereTouchesOXY() {
        //given
        double x = 2;
        double y = 2;
        double z = 4;
        double radius = 4;
        Sphere touchesOXY = new Sphere(radius, x, y, z);
        //when
        boolean isTouches = logic.isTouchesCoordinatePlates(touchesOXY);
        //then
        Assert.assertTrue(isTouches);
    }

    @Test
    public void testIsTouchesCoordinatePlatesShouldConfirmWhenSphereTouchesOZY() {
        //given
        double x = 2;
        double y = 4;
        double z = 4;
        double radius = 2;
        Sphere touchesOZY = new Sphere(radius, x, y, z);
        //when
        boolean isTouches = logic.isTouchesCoordinatePlates(touchesOZY);
        //then
        Assert.assertTrue(isTouches);
    }

    @Test
    public void testIsTouchesCoordinatePlatesShouldConfirmWhenSphereTouchesOZX() {
        //given
        double x = -12;
        double y = -10;
        double z = -12;
        double radius = 10;
        Sphere touchesOZX = new Sphere(radius, x, y, z);
        //when
        boolean isTouches = logic.isTouchesCoordinatePlates(touchesOZX);
        //then
        Assert.assertTrue(isTouches);
    }

    @Test
    public void testIsTouchesCoordinatePlatesShouldNotConfirmWhenSphereNotTouches() {
        //given
        double x = -1;
        double y = -19;
        double z = -7;
        double radius = 22;
        Sphere touchesSomething = new Sphere(radius, x, y, z);
        //when
        boolean isTouches = logic.isTouchesCoordinatePlates(touchesSomething);
        //then
        Assert.assertFalse(isTouches);
    }

    @Test
    public void testCountVolumeRatioByCrossingPlaneWhenCenterBelongsToCrossingPane() {
        //given
        Sphere sphere = new Sphere(INTEGER_RADIUS, CENTER);
        double expected = 1.;
        //when
        double actual = logic.countVolumeRatioByCrossingPlane(sphere, 0);
        //then
        Assert.assertEquals(actual, expected, DELTA);
    }

    @Test
    public void testCountVolumeRatioByCrossingPlaneWhenCrossingPanePointBelongsToSphere() {
        //given
        double radius = 9;
        Sphere sphere = new Sphere(radius, CENTER);
        double distanceFromCenter = 3;
        double expected = 12.5;
        //R = 9; h = 3 => ratio = 4 * R^3 /3 * h^2(R - h/3) - 1
        //ratio = 4 * 9^3 / 3^3 / 8 - 1 = 12.5

        //when
        double actual = logic.countVolumeRatioByCrossingPlane(sphere, distanceFromCenter);
        //then
        Assert.assertEquals(actual, expected, DELTA);
    }

    @Test
    public void testCountVolumeRationByCrossingPlaneWhenCrossingPaneNotBelongsToSphere() {
        //given
        double radius = 2;
        Sphere sphere = new Sphere(radius, CENTER);
        double distanceFromCenter = 4;
        double expected = Double.POSITIVE_INFINITY;
        //when
        double actual = logic.countVolumeRatioByCrossingPlane(sphere, distanceFromCenter);
        //then
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCountDistanceFromZeroShouldReturnZeroWhenCenterIsZero() {
        //given
        Sphere sphere = new Sphere(1, CENTER_ZERO);

        //when
        double actual = logic.countDistanceFromZero(sphere);

        //then
        Assert.assertEquals(actual, 0, DELTA);
    }

    @Test
    public void testCountDistanceFromZeroShouldReturnZeroWhenCenterBelongsToSphere() {
        //given
        Point center = new Point(2, 2, 2);
        Sphere sphere = new Sphere(10, CENTER);

        //when
        double actual = logic.countDistanceFromZero(sphere);

        //then
        Assert.assertEquals(actual, 0, DELTA);
    }

    @Test
    public void testCountDistanceFromZeroShouldReturnDistanceWhenCenterOutOfSphere() {
        //given
        Point center = new Point(2, 2, 1);
        Sphere sphere = new Sphere(1, center);

        //when
        double actual = logic.countDistanceFromZero(sphere);

        //then
        Assert.assertEquals(actual, 2, DELTA);
    }
}
