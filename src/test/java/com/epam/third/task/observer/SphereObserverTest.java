package com.epam.third.task.observer;

import com.epam.third.task.entities.ObservableSphere;
import com.epam.third.task.entities.Point;
import com.epam.third.task.entities.SphereParameters;
import com.epam.third.task.logic.IdGenerator;
import com.epam.third.task.logic.SphereCalculator;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Math.PI;
import static org.mockito.Mockito.when;

@Deprecated
public class SphereObserverTest {

    private final static IdGenerator generator = new IdGenerator();

    private final static Point CENTER = new Point(0, 0, 0);

    private final static double DEFAULT_RADIUS = 3;
    private final static double DEFAULT_VOLUME = 36 * PI;
    private final static double DEFAULT_AREA = 36 * PI;

    private final static double NEW_RADIUS = 6;
    private final static double NEW_VOLUME = 288 * PI;
    private final static double NEW_AREA = 144 * PI;

    private ObservableSphere defaultSphere;
    private SphereObserver observer;

    @BeforeMethod
    public void init() {
        int idFirst = generator.generateNextId();
        int idSecond = generator.generateNextId();
        defaultSphere = new ObservableSphere(idFirst, DEFAULT_RADIUS, CENTER);
        ObservableSphere newSphere = new ObservableSphere(idSecond, NEW_RADIUS, CENTER);
        SphereCalculator calculatorMock = Mockito.mock(SphereCalculator.class);
        when(calculatorMock.countSurfaceArea(newSphere)).thenReturn(NEW_AREA);
        when(calculatorMock.countVolume(newSphere)).thenReturn(NEW_VOLUME);
        when(calculatorMock.countSurfaceArea(defaultSphere)).thenReturn(DEFAULT_AREA);
        when(calculatorMock.countVolume(defaultSphere)).thenReturn(DEFAULT_VOLUME);

        observer = SphereObserver.getInstance();
        observer.setCalculator(calculatorMock);
    }

    @Test
    public void testHandleEventShouldNotChangeParametersWhenRadiusNotChanged() {
        //given;
        defaultSphere.attach(observer);
        SphereParameters oldParams = observer.getSphereParams(defaultSphere);

        //when
        defaultSphere.changeRadius(DEFAULT_RADIUS);

        //then
        SphereParameters newParams = observer.getSphereParams(defaultSphere);
        Assert.assertEquals(oldParams, newParams);
    }

    @Test
    public void testHandleEventShouldChangeParametersWhenRadiusIsChanged() {
        //given
        defaultSphere.attach(observer);

        //when
        defaultSphere.changeRadius(NEW_RADIUS);

        //then
        SphereParameters expectedParams = new SphereParameters(NEW_VOLUME, NEW_AREA);
        SphereParameters actualParams = observer.getSphereParams(defaultSphere);
        Assert.assertEquals(actualParams, expectedParams);
    }

    @Test
    public void testHandleEventShouldNotChangeFirstSphereParamsWhenSecondSphereStateIsChanged() {
        //given
        int id = generator.generateNextId();
        ObservableSphere constantSphere = new ObservableSphere(id, DEFAULT_RADIUS, CENTER);
        defaultSphere.attach(observer);
        constantSphere.attach(observer);

        //when
        defaultSphere.changeRadius(NEW_RADIUS);
        //then
        SphereParameters expectedParams = new SphereParameters(DEFAULT_VOLUME, DEFAULT_AREA);
        SphereParameters actualParams = observer.getSphereParams(constantSphere);
        Assert.assertEquals(actualParams, expectedParams);
    }

}
