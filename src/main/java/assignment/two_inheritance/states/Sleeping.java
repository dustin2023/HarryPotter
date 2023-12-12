package assignment.two_inheritance.states;


import assignment.two_inheritance.Phoenix;
import assignment.two_inheritance.State;

/**
 * Copyright (c) 12.12.23, 20:15
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: Sleeping.java
 * <p>
 * Project-name: HarryPotter
 */
public class Sleeping extends State {
    public Sleeping(int duration) {
        super(duration);
    }

    @Override
    protected State successor(Phoenix phoenix) {
        return new Flying(phoenix.getAwake());
    }
}
