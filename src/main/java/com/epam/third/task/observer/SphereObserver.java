package com.epam.third.task.observer;

import com.epam.third.task.entities.ObservableSphere;
import com.epam.third.task.entities.Sphere;
import com.epam.third.task.entities.SphereParameters;
import com.epam.third.task.logic.SphereCalculator;

import java.util.HashMap;
import java.util.Map;

public class SphereObserver implements Observer{

    private final static SphereObserver INSTANCE = new SphereObserver();
    private SphereObserver(){}
    public static SphereObserver getInstance(){
        return INSTANCE;
    }

    private final Map<Integer, SphereParameters> observableSpheres =
            new HashMap<>();
    private SphereCalculator calculator;

    public void setCalculator(SphereCalculator calculator){
        this.calculator = calculator;
    }

    public SphereParameters getSphereParams(Sphere sphere){
        int id = sphere.getId();
        return observableSpheres.get(id);
    }

    @Override
    public void addObservable(ObservableSphere sphere){
        double volume = calculator.countVolume(sphere);
        double area = calculator.countSurfaceArea(sphere);
        SphereParameters params = new SphereParameters(volume, area);
        int id = sphere.getId();
        observableSpheres.put(id, params);
    }


    @Override
    public void removeObservable(ObservableSphere sphere){
        int id = sphere.getId();
        observableSpheres.remove(id);
    }

    @Override
    public void handleEvent(SphereEvent sphereEvent) {
        Sphere sphere = sphereEvent.getSource();
        double newVolume = calculator.countVolume(sphere);
        double newArea = calculator.countSurfaceArea(sphere);

        SphereParameters params = getSphereParams(sphere);
        params.setArea(newArea);
        params.setVolume(newVolume);
    }
}
