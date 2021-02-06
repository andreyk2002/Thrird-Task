package com.epam.third.task.entities;

import com.epam.third.task.observer.Observer;
import com.epam.third.task.observer.SphereStateChangeEvent;

import java.util.ArrayList;
import java.util.List;

public class ObservableSphere extends SphereWithId {


    private final List<Observer> observers = new ArrayList<>();

    public ObservableSphere(int id, double radius, Point center) {
        super(id, radius, center);
    }

    public ObservableSphere(int id, double radius, double x, double y, double z) {
        super(id, radius, x, y, z);
    }


    @Override
    public void changeRadius(double radius) {
        super.changeRadius(radius);
        notifyObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
        observer.addObservable(this);
    }

    public void detach(Observer observer) {
        observer.removeObservable(this);
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(new SphereStateChangeEvent(this));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObservableSphere)) return false;
        if (!super.equals(o)) return false;

        ObservableSphere sphere = (ObservableSphere) o;

        return observers.equals(sphere.observers);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + observers.hashCode();
        return result;
    }
}
