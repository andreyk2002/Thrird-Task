package com.epam.third.task.comparators;

import com.epam.third.task.entities.Sphere;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

public abstract class SphereComparatorTest {
    private final Comparator<Sphere> sphereComparator = getComparator();
    private final Sphere EVERYTHING_SMALLER = new Sphere(3,2,2,2);
    private final Sphere EVERYTHING_BIGGER = new Sphere(15, 10,10,10);

    protected abstract Comparator<Sphere> getComparator();

    @Test
    public void testCompareShouldReturnZeroWhenSpheresAreEquals(){
        //when
        int result = sphereComparator.compare(EVERYTHING_BIGGER,EVERYTHING_BIGGER);
        //then
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testCompareShouldReturnMinusOneWhenFirstSphereIsLessThanSecond(){
        //when
        int result = sphereComparator.compare(EVERYTHING_SMALLER,EVERYTHING_BIGGER);
        //then
        Assert.assertEquals(result, -1);
    }

    @Test
    public void testCompareShouldReturnOneWhenFirstSphereIsLessThanSecond(){
        //when
        int result = sphereComparator.compare(EVERYTHING_BIGGER,EVERYTHING_SMALLER);
        //then
        Assert.assertEquals(result, 1);
    }
}
