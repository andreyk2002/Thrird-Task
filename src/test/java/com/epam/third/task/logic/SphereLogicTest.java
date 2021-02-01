package com.epam.third.task.logic;

import com.epam.third.task.entities.Point;
import com.epam.third.task.entities.Sphere;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Math.PI;

public class SphereLogicTest {

    private final SphereLogic logic = new SphereLogic();

    private final static Point CENTER = new Point(6, 0, 0);
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
        Sphere sphere = new Sphere(CENTER, INTEGER_RADIUS);
        double expected = PI * 36;
        //when
        double volume = logic.countVolume(sphere);
        //then
        Assert.assertEquals(volume, expected, DELTA);
    }

    @Test
    public void testCountVolumeShouldCountWhenRadiusIsDouble() {
        //given
        Sphere sphere = new Sphere(CENTER, DOUBLE_RADIUS);
        double expected = PI * 121.5;
        //when
        double volume = logic.countVolume(sphere);
        //then
        Assert.assertEquals(volume, expected, DELTA);
    }

    @Test(enabled = false)
    public void testCountVolumeShouldCountWhenRadiusIsVeryBig() {
        //given
        double bigRadius = 1.5e35;
        Sphere sphere = new Sphere(CENTER, bigRadius);
        double expected = 4.5e105 * PI;
        //when
        double volume = logic.countVolume(sphere);
        //then
        Assert.assertEquals(volume, expected, DELTA);
    }

    @Test
    public void testCountSurfaceAreaShouldCountWhenRadiusIsInteger() {
        //given
        Sphere sphere = new Sphere(CENTER, INTEGER_RADIUS);
        double expected = 36 * PI;
        //when
        double actual = logic.countSurfaceArea(sphere);
        //then
        Assert.assertEquals(actual, expected, DELTA);
    }

    @Test
    public void testCountSurfaceAreaShouldCountWhenRadiusIsDouble() {
        //given
        Sphere sphere = new Sphere(CENTER, DOUBLE_RADIUS);
        double expected = 81 * PI;
        //when
        double actual = logic.countSurfaceArea(sphere);
        //then
        Assert.assertEquals(actual, expected, DELTA);
    }

    @Test(enabled = false)
    public void testCountSurfaceAreaShouldCountWhenRadiusIsVeryBig() {
        //given
        double bigRadius = 1.0e35;
        Sphere sphere = new Sphere(CENTER, bigRadius);
        double expected = 4.0e70 * PI;
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
    public void testIsTouchesCoordinatePlatesShouldNotConfirmWhenRadiusIsVeryBig() {
        //given
        double x = -1.1e52;
        double y = -19;
        double z = -7;
        double radius = 1.1e52;
        Sphere touchesSomething = new Sphere( radius, x, y, z);
        //when
        boolean isTouches = logic.isTouchesCoordinatePlates(touchesSomething);
        //then
        Assert.assertTrue(isTouches);
    }

    @Test
    public void testCountVolumeRatioByCrossingPlaneWhenCenterBelongsToCrossingPane(){
        //given
        Sphere sphere = new Sphere(CENTER, INTEGER_RADIUS);
        double expected = 1.;
        //when
        double actual = logic.countVolumeRatioByCrossingPlane(sphere, 0);
        //then
        Assert.assertEquals(actual,expected,DELTA);
    }

    @Test
    public void testCountVolumeRatioByCrossingPlaneWhenCrossingPanePointBelongsToSphere(){
        //given
        double radius = 9;
        Sphere sphere = new Sphere(CENTER, radius);
        double distanceFromCenter = 3;
        double expected = 12.5;
        //R = 9; h = 3 => ratio = 4 * R^3 /3 * h^2(R - h/3) - 1
        //ratio = 4 * 9^3 / 3^3 / 8 - 1 = 12.5

        //when
        double actual = logic.countVolumeRatioByCrossingPlane(sphere, distanceFromCenter);
        //then
        Assert.assertEquals(actual,expected,DELTA);
    }

    @Test
    public void testCountVolumeRationByCrossingPlaneWhenCrossingPaneNotBelongsToSphere(){
        //given
        double radius = 2;
        Sphere sphere = new Sphere(CENTER, radius);
        double distanceFromCenter = 4;
        double expected = Double.POSITIVE_INFINITY;
        //when
        double actual = logic.countVolumeRatioByCrossingPlane(sphere, distanceFromCenter);
        //then
        Assert.assertEquals(actual,expected);
    }
}
