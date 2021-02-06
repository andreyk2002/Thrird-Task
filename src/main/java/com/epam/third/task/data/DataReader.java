package com.epam.third.task.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private final static Logger LOGGER = LogManager.getLogger(DataReader.class);

    public List<String> readData(String filename) throws DataException {
        List<String> result = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new DataException(e.getMessage(), e);
        } finally {
            closeResource(reader);
        }
        return result;
    }

    private void closeResource(BufferedReader reader) throws DataException {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
                throw new DataException(e.getMessage(), e);
            }
        }
    }
}
