package com.epam.third.task.repository;

import com.epam.third.task.entities.Sphere;
import com.epam.third.task.repository.specifications.SphereSpecification;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class MapBasedSphereRepositoryTest {
    private final MapBasedSphereRepository repository = new MapBasedSphereRepository();
    private final Sphere FIRST_SPHERE = new Sphere(1, 1,1,1);
    private final Sphere SECOND_SPHERE = new Sphere(3,0,0,0);
    private final Sphere THIRD_SPHERE = new Sphere(15, -1,-2,-1);

    @BeforeClass
    public void fillRepository(){
        repository.addSphere(FIRST_SPHERE);
        repository.addSphere(SECOND_SPHERE);
        repository.addSphere(THIRD_SPHERE);
    }

    @Test
    public void testQueryShouldReturnEmptyListWhenNothingSpecifiesSpecification(){
        //given
        SphereSpecification specification = Mockito.mock(SphereSpecification.class);
        when(specification.specified(any(Sphere.class))).thenReturn(false);

        //when
        List<Sphere> actual = repository.query(specification);

        //then
        List<Sphere>expected = Collections.emptyList();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testQueryShouldReturnAllItemsWhenAllItemsSpecifySpecification(){
        //given
        SphereSpecification specification = Mockito.mock(SphereSpecification.class);
        when(specification.specified(any(Sphere.class))).thenReturn(true);

        //when
        List<Sphere> actual = repository.query(specification);

        //then
        List<Sphere>expected = Arrays.asList(FIRST_SPHERE,SECOND_SPHERE, THIRD_SPHERE);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testQueryShouldReturnItemsWhenSomeItemsSpecifySpecification(){
        //given
        SphereSpecification specification = Mockito.mock(SphereSpecification.class);
        when(specification.specified(FIRST_SPHERE)).thenReturn(true);
        when(specification.specified(SECOND_SPHERE)).thenReturn(false);
        when(specification.specified(THIRD_SPHERE)).thenReturn(false);

        //when
        List<Sphere> actual = repository.query(specification);

        //then
        List<Sphere>expected = Collections.singletonList(FIRST_SPHERE);
        Assert.assertEquals(actual,expected);
    }
}
