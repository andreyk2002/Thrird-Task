package com.epam.third.task.parsing;

import com.epam.third.task.entities.Sphere;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SphereParserTest {

    private final SphereParser parser = new SphereParser();

    private static final String INT_STRING = "1 3 5 2";
    private static final String DOUBLE_STRING = "1.2 3.3 5.4 2.7";
    private static final String MIXED_STRING = "1. 3.3 0 2.7";

    @Test
    public void testParseShouldParseWhenAllParametersAreIntegers() {
        //given
        Sphere expected = new Sphere(1, 3, 5, 2);
        //when
        Sphere actual = parser.parse(INT_STRING);
        //then
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testParseShouldParseWhenAllParametersAreDoubles() {
        //given
        Sphere expected = new Sphere(1.2, 3.3, 5.4, 2.7);
        //when
        Sphere actual = parser.parse(DOUBLE_STRING);
        //then
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testParseShouldParseWhenAreIntegersAndDoubles() {
        //given
        Sphere expected = new Sphere(1., 3.3, 0, 2.7);
        //when
        Sphere actual = parser.parse(MIXED_STRING);
        //then
        Assert.assertEquals(actual, expected);
    }
}
