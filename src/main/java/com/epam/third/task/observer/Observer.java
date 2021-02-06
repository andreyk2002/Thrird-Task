package com.epam.third.task.observer;

import com.epam.third.task.entities.ObservableSphere;


public interface Observer {

    void addObservable(ObservableSphere sphere);

    void removeObservable(ObservableSphere sphere);

    void update(SphereStateChangeEvent event);


}
