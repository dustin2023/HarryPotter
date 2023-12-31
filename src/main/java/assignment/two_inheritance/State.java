package assignment.two_inheritance;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Copyright (c) 12.12.23, 20:16
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: State.java
 * <p>
 * Project-name: HarryPotter
 */
public abstract class State {
    private static final Logger logger = LogManager.getLogger(State.class);

    protected int time = 0;
    protected final int duration;

    protected State(int duration) {
        this.duration = duration;
    }

    final State tick(Phoenix cat) {
        if (duration < 0) return this;
        time = time + 1;
        if (time < duration) {
            logger.info("Still in {}", getClass().getSimpleName());
            return this;
        }
        return successor(cat);
    }

    protected abstract State successor(Phoenix cat);
}
