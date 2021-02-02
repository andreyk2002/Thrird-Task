package com.epam.third.task.parsing;

public class SphereValidator {
    private static final String SPHERE_PATTERN = "^(\\d+(\\.\\d*)?\\s)(-?\\d+(\\.\\d*)?\\s){2}(-?\\d+(\\.\\d*)?)$";

    public boolean validate(String string){
        return string.matches(SPHERE_PATTERN);
    }
}
