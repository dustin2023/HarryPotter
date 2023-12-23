package assignment.two_inheritance.states;

import assignment.two_inheritance.Phoenix;
import assignment.two_inheritance.State;


/**
 * Copyright (c) 12-12.12.23, 20:12
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: Flying.java
 * <p>
 * Project-name: HarryPotter
 */
public class Flying extends State {
    public Flying(int duration) {
        super(duration);
    }

    public State feed(Phoenix phoenix) {
        return new Resting(phoenix.getRest(), duration - time);
    }

    @Override
    protected State successor(Phoenix phoenix) {
        return new Dead();
    }
}
