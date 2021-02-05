package com.epam.third.task.entities;

import com.epam.third.task.observer.Observer;
import com.epam.third.task.observer.SphereEvent;

import java.util.ArrayList;
import java.util.List;

public class ObservableSphere extends Sphere {


    private final List<Observer> observers = new ArrayList<>();

    public ObservableSphere( double radius, Point center) {
        super(radius, center);
    }

    public ObservableSphere(double radius, double x, double y, double z) {
        super(radius, x, y, z);
    }


    @Override
    public void changeRadius(double radius){
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
        for(Observer observer : observers){
            observer.handleEvent(new SphereEvent(this));
        }
    }
}
