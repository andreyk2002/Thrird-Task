package com.epam.third.task.data;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private final DataReader reader = new DataReader();

    private final static String EMPTY_FILE = "./src/test/resources/empty.txt";
    private final static String TEST_FILE = "./src/test/resources/input.txt";
    private final static String NOT_EXISTING_FILE = "./src/test/resources/notExistingFile.txt";

    @Test
    public void testReadDataShouldReturnEmptyListWhenFileIsEmpty() throws DataException {
        //when
        List<String> actual = reader.readData(EMPTY_FILE);
        //then
        List<String> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testReadDataShouldReadWhenMultipleLinesFileApplied() throws DataException {
        //when
        List<String> actual = reader.readData(TEST_FILE);
        //then
        List<String> expected = Arrays.asList("1 2 3 4", "2", "3f 5a");
        Assert.assertEquals(actual, expected);
    }

    //then
    @Test(expectedExceptions = DataException.class)
    public void testReadDataShouldThrowADataExceptionWhenFileNotFound() throws DataException {
        //when
        reader.readData(NOT_EXISTING_FILE);
    }
}
