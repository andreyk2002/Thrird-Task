package com.epam.third.task;

import com.epam.third.task.data.DataException;
import com.epam.third.task.data.DataReader;
import com.epam.third.task.entities.Sphere;
import com.epam.third.task.parsing.SphereParser;
import com.epam.third.task.parsing.SphereValidator;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class SphereCreatorTest {

    private final String FILE_NAME = "";
    private final String SPHERE_STRING = "3. -4 5 42.4242";
    private final Sphere CREATED_SPHERE = new Sphere(3. , -4, 5,42.4242);
    private final String FIRST_SPHERE_STRING ="1 2 3 4";
    private final Sphere FIRST_SPHERE = new Sphere(1, 2, 3,4);
    private final String SECOND_SPHERE_STRING = "2 2 2 2";
    private final Sphere SECOND_SPHERE = new Sphere(2, 2, 2,2);
    private final String THIRD_SPHERE_STRING = "42 42 42 42.42";
    private final Sphere THIRD_SPHERE = new Sphere(42, 42, 42,42.42);

    @Test
    public void testCreateShouldReturnEmptyListWhenItIsNothingToCreate() throws DataException {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.readData(anyString()))
                .thenReturn(Collections.singletonList(""));

        SphereValidator validator = Mockito.mock(SphereValidator.class);
        when(validator.validate(anyString()))
                .thenReturn(false);

        SphereParser parser = Mockito.mock(SphereParser.class);

        SphereCreator creator = new SphereCreator(reader, validator, parser);
        //when
        List<Sphere> result = creator.create(FILE_NAME);
        //then
        List<Sphere>expected = new ArrayList<>();
        Assert.assertEquals(result,expected);

    }

    @Test
    public void testCreateShouldCreateWhenOneSphereNeededToBeCreated() throws DataException {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.readData(anyString()))
                .thenReturn(Collections.singletonList(SPHERE_STRING));

        SphereValidator validator = Mockito.mock(SphereValidator.class);
        when(validator.validate(anyString()))
                .thenReturn(true);

        SphereParser parser = Mockito.mock(SphereParser.class);
        when(parser.parse(anyString())).thenReturn(CREATED_SPHERE);

        SphereCreator creator = new SphereCreator(reader, validator, parser);
        //when
        List<Sphere> result = creator.create(FILE_NAME);
        //then
        List<Sphere>expected = Collections.singletonList(CREATED_SPHERE);
        Assert.assertEquals(result,expected);
    }

    @Test
    public void testCreateShouldCreateWhenMoreThanOneSpheresNeededToBeCreated() throws DataException {
        //given
        List<String>spheresString =
                Arrays.asList(FIRST_SPHERE_STRING, SECOND_SPHERE_STRING,THIRD_SPHERE_STRING);
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.readData(anyString()))
                .thenReturn(spheresString);

        SphereValidator validator = Mockito.mock(SphereValidator.class);
        when(validator.validate(anyString()))
                .thenReturn(true);

        SphereParser parser = Mockito.mock(SphereParser.class);
        when(parser.parse(FIRST_SPHERE_STRING)).thenReturn(FIRST_SPHERE);
        when(parser.parse(SECOND_SPHERE_STRING)).thenReturn(SECOND_SPHERE);
        when(parser.parse(THIRD_SPHERE_STRING)).thenReturn(THIRD_SPHERE);

        SphereCreator creator = new SphereCreator(reader, validator, parser);
        //when
        List<Sphere> result = creator.create(FILE_NAME);
        //then
        List<Sphere>expected = Arrays.asList(FIRST_SPHERE, SECOND_SPHERE, THIRD_SPHERE);
        Assert.assertEquals(result,expected);
    }

}
