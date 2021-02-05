package com.epam.third.task.observer;

import com.epam.third.task.entities.ObservableSphere;
import com.epam.third.task.entities.Point;
import com.epam.third.task.entities.SphereParams;
import com.epam.third.task.logic.SphereCalculator;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Math.PI;
import static org.mockito.Mockito.when;

public class SphereObserverTest {

    private final static Point CENTER = new Point(0, 0, 0);

    private final static double DEFAULT_RADIUS = 3;
    private final static double DEFAULT_VOLUME = 36 * PI;
    private final static double DEFAULT_AREA = 36 * PI;

    private final static double NEW_RADIUS = 6;
    private final static double NEW_VOLUME = 288 * PI;
    private final static double NEW_AREA = 144 * PI;

    private ObservableSphere defaultSphere;
    private ObservableSphere newSphere;
    private SphereCalculator calculatorMock;

    @BeforeMethod
    public void init() {
        defaultSphere = new ObservableSphere(DEFAULT_RADIUS, CENTER);
        newSphere = new ObservableSphere(NEW_RADIUS, CENTER);
        calculatorMock = Mockito.mock(SphereCalculator.class);
        when(calculatorMock.countSurfaceArea(defaultSphere)).thenReturn(DEFAULT_AREA);
        when(calculatorMock.countVolume(defaultSphere)).thenReturn(DEFAULT_VOLUME);
        when(calculatorMock.countSurfaceArea(newSphere)).thenReturn(NEW_AREA);
        when(calculatorMock.countVolume(newSphere)).thenReturn(NEW_VOLUME);
    }

    @Test
    public void testHandleEventShouldNotChangeParametersWhenRadiusNotChanged() {
        //given
        SphereObserver observer = new SphereObserver(calculatorMock);
        defaultSphere.attach(observer);
        SphereParams oldParams = observer.getSphereParams(defaultSphere);

        //when
        defaultSphere.changeRadius(DEFAULT_RADIUS);

        //then
        SphereParams newParams = observer.getSphereParams(defaultSphere);
        Assert.assertEquals(oldParams, newParams);
    }

    @Test
    public void testHandleEventShouldChangeParametersWhenRadiusIsChanged() {
        //given
        SphereObserver observer = new SphereObserver(calculatorMock);
        defaultSphere.attach(observer);

        //when
        defaultSphere.changeRadius(NEW_RADIUS);

        //then
        SphereParams expectedParams = new SphereParams(NEW_VOLUME, NEW_AREA);
        SphereParams actualParams = observer.getSphereParams(defaultSphere);
        Assert.assertEquals(actualParams, expectedParams);
    }

    @Test
    public void testHandleEventShouldNotChangeFirstSphereParamsWhenSecondSphereStateIsChanged() {
        //given
        ObservableSphere constantSphere = new ObservableSphere(DEFAULT_RADIUS, CENTER);
        SphereObserver observer = new SphereObserver(calculatorMock);
        defaultSphere.attach(observer);
        constantSphere.attach(observer);

        //when
        defaultSphere.changeRadius(NEW_RADIUS);
        //then
        SphereParams expectedParams = new SphereParams(DEFAULT_VOLUME, DEFAULT_AREA);
        SphereParams actualParams = observer.getSphereParams(constantSphere);
        Assert.assertEquals(actualParams, expectedParams);
    }

}
