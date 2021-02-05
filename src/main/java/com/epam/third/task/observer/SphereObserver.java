package com.epam.third.task.observer;

import com.epam.third.task.entities.ObservableSphere;
import com.epam.third.task.entities.Sphere;
import com.epam.third.task.entities.SphereParams;
import com.epam.third.task.logic.SphereCalculator;

import java.util.HashMap;
import java.util.Map;

public class SphereObserver implements Observer{

    private final Map<Integer, SphereParams> observableSpheres =
            new HashMap<>();

    private final SphereCalculator calculator;

    public SphereObserver(SphereCalculator calculator){
        this.calculator = calculator;
    }

    public SphereParams getSphereParams(Sphere sphere){
        int id = sphere.getId();
        return observableSpheres.get(id);
    }

    @Override
    public void addObservable(ObservableSphere sphere){
        double volume = calculator.countVolume(sphere);
        double area = calculator.countSurfaceArea(sphere);
        SphereParams params = new SphereParams(volume, area);
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

        SphereParams params = getSphereParams(sphere);
        params.setArea(newArea);
        params.setVolume(newVolume);
    }
}
