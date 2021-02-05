package com.epam.third.task.repository.specifications;

import com.epam.third.task.entities.Sphere;
import com.epam.third.task.logic.SphereCalculator;

public class SphereVolumeSpecification extends SphereRangeSpecification {

    public SphereVolumeSpecification(double minimum, double maximum, SphereCalculator calculator) {
        super(minimum, maximum, calculator);
    }

    @Override
    protected double getParameter(Sphere sphere) {
        SphereCalculator calculator = super.getCalculator();
        return calculator.countVolume(sphere);
    }
}
