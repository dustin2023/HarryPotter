package assignment.two_inheritance;

import assignment.two_inheritance.states.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Copyright (c) 12.12.23, 20:15
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: Phoenix.java
 * <p>
 * Project-name: HarryPotter
 */
public class Phoenix {
    private static final Logger logger = LogManager.getLogger(Phoenix.class);
    private State currentState;

    // state durations (set via constructor), ie. the number of ticks in each state
    private final int sleep;
    private final int awake;
    private final int digest;

    private final String name;

    public Phoenix(String name, int sleep, int awake, int digest) {
        this.name = name;
        this.sleep = sleep;
        this.awake = awake;
        this.digest = digest;
        currentState = new Sleeping(sleep);
    }

    public void tick() {
        logger.info("tick()");
        this.currentState = currentState.tick(this);
    }

    /**
     * This would be a user interaction: feed the cat to change its state!
     */
    public void fly() {
        if (!isFlying())
            throw new IllegalStateException("Can't stuff a cat...");

        logger.info("You feed the cat...");

        // change state and reset the timer
        this.currentState = ((Flying) currentState).feed(this);
    }

    public boolean isAsleep() {
        return currentState instanceof Sleeping;
    }

    public boolean isPlayful() {
        return currentState instanceof Playful;
    }

    public boolean isFlying() {
        return currentState instanceof Flying;
    }

    public boolean isResting() {
        return currentState instanceof Resting;
    }

    public boolean isDead() {
        return currentState instanceof Dead;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getSleeping() {
        return sleep;
    }

    public int getAwake() {
        return awake;
    }

    public int getRest() {
        return digest;
    }
}
