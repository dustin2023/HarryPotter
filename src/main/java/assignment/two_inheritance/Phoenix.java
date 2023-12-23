package assignment.two_inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static assignment.two_inheritance.Phoenix.State.*;

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
    private static final Logger logger = LoggerFactory.getLogger(Phoenix.class);
    // valid states
    public enum State {SLEEPING, FLYING, RESTING, PLAYFUL, DEAD}

    // initially, animals are sleeping
    private Phoenix.State state = Phoenix.State.SLEEPING;

    // state durations (set via constructor), ie. the number of ticks in each state
    private final int sleep;
    private final int awake;
    private final int rest;

    private final String name;

    private int time = 0;
    private int timeResting = 0;

    public Phoenix(String name, int sleep, int awake, int rest) {
        this.name = name;
        this.sleep = sleep;
        this.awake = awake;
        this.rest = rest;
    }

    public void tick(){
        logger.info("tick()");
        time = time + 1;

        switch (state) {
            case SLEEPING:
                if (time == sleep) {
                    logger.info("Yoan... getting hungry!");
                    state = FLYING;
                    time = 0;
                }
                break;
            case FLYING:
                if(time == awake){
                    logger.info("I've starved for a too long time...good bye...");
                    state = DEAD;
                }
                break;
            case RESTING:
                timeResting = timeResting + 1;
                if (timeResting == rest) {
                    logger.info("Getting in a playful mood!");
                    state = PLAYFUL;
                }
                break;
            case PLAYFUL:
                if (time >= awake) {
                    logger.info("Yoan... getting tired!");
                    state = SLEEPING;
                    time = 0;
                }
                break;

            case DEAD:
                break;
            default:
                throw new IllegalStateException("Unknown cat state " + state.name());
        }

        logger.info(state.name());

    }


    /**
     * This would be a user interaction: feed the cat to change its state!
     */
    public void fly() {
        if (!isFlying())
            throw new IllegalStateException("Can't stuff a phoenix...");

        logger.info("You feed the phoenix...");

        // change state and reset the timer
        state = Phoenix.State.RESTING;
        timeResting = 0;
    }

    public boolean isAsleep() {
        return state.equals(Phoenix.State.SLEEPING);
    }

    public boolean isPlayful() {
        return state.equals(Phoenix.State.PLAYFUL);
    }

    public boolean isFlying() {
        return state.equals(FLYING);
    }

    public boolean isResting() {
        return state.equals(State.RESTING);
    }

    public boolean isDead() {
        return state == Phoenix.State.DEAD;
    }

    @Override
    public String toString() {
        return name;
    }
}
