package com.epam.third.task.repository.specifications;

import com.epam.third.task.entities.SphereWithId;
import com.epam.third.task.logic.SphereCalculator;

public abstract class SphereRangeSpecification implements SphereSpecification {

    private final double minimum;
    private final double maximum;
    private final SphereCalculator calculator;

    public SphereRangeSpecification(double minimum, double maximum, SphereCalculator calculator) {
        this.calculator = calculator;
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public SphereCalculator getCalculator() {
        return calculator;
    }

    @Override
    public boolean specified(SphereWithId sphere) {
        double specifiedParameter = getParameter(sphere);
        return specifiedParameter >= minimum && specifiedParameter <= maximum;
    }

    protected abstract double getParameter(SphereWithId sphere);
}
