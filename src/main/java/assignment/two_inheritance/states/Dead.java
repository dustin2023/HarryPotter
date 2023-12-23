package assignment.two_inheritance.states;

import assignment.two_inheritance.Phoenix;
import assignment.two_inheritance.State;

/**
 * Copyright (c) 12.12.23, 20:14
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: Dead.java
 * <p>
 * Project-name: HarryPotter
 */
public class Dead extends State {
    public Dead() {
        super(-1);
    }

    @Override
    protected State successor(Phoenix phoenix) {
        return this;
    }
}
