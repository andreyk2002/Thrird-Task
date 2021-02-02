package com.epam.third.task.parsing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SphereValidatorTest {

    private final SphereValidator validator = new SphereValidator();

    private final static String EMPTY = "";
    private final static String VALID_INTEGER = "1 2 3 4";
    private final static String VALID_DOUBLE = "1.327 2.22 3.1 2.091";
    private final static String VALID_MIXED = "1 6. 0 2.32323";
    private final static String VALID_NEGATIVE = "6. -1 -4242 -6.4242";
    private final static String INVALID_ARGUMENTS = "1 g 3 4";
    private final static String NOT_ENOUGH_ARGUMENTS = "1 2 3";
    private final static String TOO_MANY_ARGUMENTS = "2.5 6.66 42 42 42";
    private final static String NEGATIVE_RADIUS = "-1 0 2.32323 4";


    @Test
    public void testValidateShouldNotValidateWhenStringIsEmpty() {
        //when
        boolean isValid = validator.validate(EMPTY);
        //then
        Assert.assertFalse(isValid);
    }

    @Test
    public void testValidateShouldValidateWhenStringContainsOnlyIntegers() {
        //when
        boolean isValid = validator.validate(VALID_INTEGER);
        //then
        Assert.assertTrue(isValid);
    }

    @Test
    public void testValidateShouldValidateWhenStringContainsOnlyDoubles() {
        //when
        boolean isValid = validator.validate(VALID_DOUBLE);
        //then
        Assert.assertTrue(isValid);
    }

    @Test
    public void testValidateShouldValidateWhenStringContainsIntegersAndDouble() {
        //when
        boolean isValid = validator.validate(VALID_MIXED);
        //then
        Assert.assertTrue(isValid);
    }

    @Test
    public void testValidateShouldValidateWhenCoordinatesAreNegative() {
        //when
        boolean isValid = validator.validate(VALID_NEGATIVE);
        //then
        Assert.assertTrue(isValid);
    }

    @Test
    public void testValidateShouldNotValidateWhenRadiusIsNegative() {
        //when
        boolean isValid = validator.validate(NEGATIVE_RADIUS);
        //then
        Assert.assertFalse(isValid);
    }

    @Test
    public void testValidateShouldNotValidateWhenArgumentsAreNotNumbers() {
        //when
        boolean isValid = validator.validate(INVALID_ARGUMENTS);
        //then
        Assert.assertFalse(isValid);
    }

    @Test
    public void testValidateShouldNotValidateWhenLessThanNecessaryArgumentsApplied() {
        //when
        boolean isValid = validator.validate(NOT_ENOUGH_ARGUMENTS);
        //then
        Assert.assertFalse(isValid);
    }

    @Test
    public void testValidateShouldNotValidateWhenMoreThanNecessaryArgumentsApplied() {
        //when
        boolean isValid = validator.validate(TOO_MANY_ARGUMENTS);
        //then
        Assert.assertFalse(isValid);
    }
}
