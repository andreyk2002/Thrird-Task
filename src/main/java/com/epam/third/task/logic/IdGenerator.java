package com.epam.third.task.logic;

public class IdGenerator {
    private static int nextId = 0;

    public int generateNextId() {
        nextId++;
        return nextId;
    }

}
