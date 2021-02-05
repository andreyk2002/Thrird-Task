package com.epam.third.task.entities;

import com.epam.third.task.observer.Observer;
import com.epam.third.task.observer.SphereObserver;

public interface Observable {

    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
