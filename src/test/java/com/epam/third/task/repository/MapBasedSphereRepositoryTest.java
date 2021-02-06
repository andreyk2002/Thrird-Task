package com.epam.third.task.repository;

import com.epam.third.task.entities.Sphere;
import com.epam.third.task.entities.SphereWithId;
import com.epam.third.task.logic.IdGenerator;
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
    private final IdGenerator generator = new IdGenerator();
    private final int FIRST_ID = generator.generateNextId();
    private final int SECOND_ID = generator.generateNextId();
    private final int THIRD_ID = generator.generateNextId();

    private final SphereWithId FIRST_SPHERE = new SphereWithId(FIRST_ID, 1, 1, 1, 1);
    private final SphereWithId SECOND_SPHERE = new SphereWithId(SECOND_ID, 3, 0, 0, 0);
    private final SphereWithId THIRD_SPHERE = new SphereWithId(THIRD_ID, 15, -1, -2, -1);

    @BeforeClass
    public void fillRepository() {
        repository.addSphere(FIRST_SPHERE);
        repository.addSphere(SECOND_SPHERE);
        repository.addSphere(THIRD_SPHERE);
    }

    @Test
    public void testQueryShouldReturnEmptyListWhenNothingSpecifiesSpecification() {
        //given
        SphereSpecification specification = Mockito.mock(SphereSpecification.class);
        when(specification.specified(any(SphereWithId.class))).thenReturn(false);

        //when
        List<Sphere> actual = repository.query(specification);

        //then
        List<Sphere> expected = Collections.emptyList();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testQueryShouldReturnAllItemsWhenAllItemsSpecifySpecification() {
        //given
        SphereSpecification specification = Mockito.mock(SphereSpecification.class);
        when(specification.specified(any(SphereWithId.class))).thenReturn(true);

        //when
        List<Sphere> actual = repository.query(specification);

        //then
        List<Sphere> expected = Arrays.asList(FIRST_SPHERE, SECOND_SPHERE, THIRD_SPHERE);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testQueryShouldReturnItemsWhenSomeItemsSpecifySpecification() {
        //given
        SphereSpecification specification = Mockito.mock(SphereSpecification.class);
        when(specification.specified(FIRST_SPHERE)).thenReturn(true);
        when(specification.specified(SECOND_SPHERE)).thenReturn(false);
        when(specification.specified(THIRD_SPHERE)).thenReturn(false);

        //when
        List<Sphere> actual = repository.query(specification);

        //then
        List<Sphere> expected = Collections.singletonList(FIRST_SPHERE);
        Assert.assertEquals(actual, expected);
    }
}
