package com.epam.third.task.repository.specifications;

import com.epam.third.task.entities.SphereWithId;
import com.epam.third.task.logic.SphereCalculator;

public class SphereAreaSpecification extends SphereRangeSpecification {

    public SphereAreaSpecification(double minimum, double maximum, SphereCalculator calculator) {
        super(minimum, maximum, calculator);
    }

    @Override
    protected double getParameter(SphereWithId sphere) {
        SphereCalculator calculator = super.getCalculator();
        return calculator.countSurfaceArea(sphere);
    }
}
