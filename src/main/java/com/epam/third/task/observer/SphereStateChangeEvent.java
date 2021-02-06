package com.epam.third.task.observer;

import com.epam.third.task.entities.ObservableSphere;

import java.util.EventObject;

public class SphereStateChangeEvent extends EventObject {

    public SphereStateChangeEvent(ObservableSphere source) {
        super(source);
    }

    @Override
    public ObservableSphere getSource() {
        return (ObservableSphere) super.getSource();
    }
}
