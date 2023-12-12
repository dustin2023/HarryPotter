package assignment.two_inheritance.states;

import assignment.two_inheritance.Phoenix;
import assignment.two_inheritance.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (c) 12.12.23, 20:11
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: Resting.java
 * <p>
 * Project-name: HarryPotter
 */

public class Resting extends State {
    private static final Logger logger = LoggerFactory.getLogger(Resting.class);

    private final int remainingWakeTime;


    protected Resting(int duration, int remainingWakeTime) {
        super(duration);
        this.remainingWakeTime = remainingWakeTime;
    }

    @Override
    protected State successor(Phoenix phoenix) {
        logger.info("Getting in a playful mood!");
        return new Playful(remainingWakeTime - phoenix.getRest());
    }
}
