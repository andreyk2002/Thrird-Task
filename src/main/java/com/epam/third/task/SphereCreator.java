package com.epam.third.task;

import com.epam.third.task.data.DataException;
import com.epam.third.task.data.DataReader;
import com.epam.third.task.entities.Sphere;
import com.epam.third.task.parsing.SphereParser;
import com.epam.third.task.parsing.SphereValidator;

import java.util.ArrayList;
import java.util.List;

public class SphereCreator {

    private final DataReader reader;
    private final SphereValidator validator;
    private final SphereParser parser;

    public SphereCreator(DataReader reader, SphereValidator validator, SphereParser parser) {
        this.reader = reader;
        this.validator = validator;
        this.parser = parser;
    }

    public List<Sphere> create(String filename) throws DataException {
        List<String> lines = reader.readData(filename);
        List<Sphere> createdSpheres = new ArrayList<>();
        for (String line : lines) {
            if (validator.validate(line)) {
                Sphere createdSphere = parser.parse(line);
                createdSpheres.add(createdSphere);
            }
        }
        return createdSpheres;
    }
}
