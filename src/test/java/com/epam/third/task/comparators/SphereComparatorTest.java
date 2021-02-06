package com.epam.third.task.comparators;

import com.epam.third.task.entities.SphereWithId;
import com.epam.third.task.logic.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

public abstract class SphereComparatorTest {
    private final static IdGenerator GENERATOR = new IdGenerator();
    private final static int SMALLER_ID = GENERATOR.generateNextId();
    private final static int BIGGER_ID = GENERATOR.generateNextId();
    private final static SphereWithId EVERYTHING_SMALLER = new SphereWithId(SMALLER_ID, 3, 2, 2, 2);
    private final static SphereWithId EVERYTHING_BIGGER = new SphereWithId(BIGGER_ID, 15, 10, 10, 10);
    private final Comparator<SphereWithId> sphereComparator = getComparator();

    protected abstract Comparator<SphereWithId> getComparator();

    @Test
    public void testCompareShouldReturnZeroWhenSpheresAreEquals() {
        //when
        int result = sphereComparator.compare(EVERYTHING_BIGGER, EVERYTHING_BIGGER);
        //then
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testCompareShouldReturnMinusOneWhenFirstSphereIsLessThanSecond() {
        //when
        int result = sphereComparator.compare(EVERYTHING_SMALLER, EVERYTHING_BIGGER);
        //then
        Assert.assertEquals(result, -1);
    }

    @Test
    public void testCompareShouldReturnOneWhenFirstSphereIsLessThanSecond() {
        //when
        int result = sphereComparator.compare(EVERYTHING_BIGGER, EVERYTHING_SMALLER);
        //then
        Assert.assertEquals(result, 1);
    }
}
