package com.epam.third.task.observer;

import com.epam.third.task.entities.Sphere;

import java.util.EventObject;

public class SphereEvent extends EventObject {

    public SphereEvent(Sphere source) {
        super(source);
    }

    @Override
    public Sphere getSource() {
        return (Sphere) super.getSource();
    }
}
