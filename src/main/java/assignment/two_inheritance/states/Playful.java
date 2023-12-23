package assignment.two_inheritance.states;

import assignment.two_inheritance.Phoenix;
import assignment.two_inheritance.State;

/**
 * Copyright (c) 12.12.23, 20:12
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: Playful.java
 * <p>
 * Project-name: HarryPotter
 */
public class Playful extends State {
    protected Playful(int duration) {
        super(duration);
    }

    @Override
    protected State successor(Phoenix phoenix) {
        return new Sleeping(phoenix.getSleeping());
    }
}
