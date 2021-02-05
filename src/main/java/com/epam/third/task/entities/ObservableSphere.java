package com.epam.third.task.entities;

import com.epam.third.task.observer.Observer;
import com.epam.third.task.observer.SphereEvent;

import java.util.ArrayList;
import java.util.List;

public class ObservableSphere extends Sphere implements Observable {


    private final List<Observer> observerList = new ArrayList<>();

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

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
        observer.addObservable(this);
    }

    @Override
    public void detach(Observer observer) {
        observer.removeObservable(this);
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observerList){
            observer.handleEvent(new SphereEvent(this));
        }
    }
}
