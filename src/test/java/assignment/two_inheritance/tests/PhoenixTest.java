package assignment.two_inheritance.tests;

import assignment.two_inheritance.Phoenix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Copyright (c) 12.12.23, 20:16
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: PhoenixTest.java
 * <p>
 * Project-name: HarryPotter
 */
public class PhoenixTest {

    private static final int Sleep = 10;
    private static final int Awake = 15;
    private static final int Digest = 10;

    private Phoenix animal;

    @BeforeEach
    void setUp() {
        animal = new Phoenix("Horst", Sleep, Awake, Digest);
    }

    @Test
    void testFeedHungryAnimal() {
        for (int i = 0; i < Sleep; i++) {
            animal.tick();
        }

        assertTrue(animal.isFlying());
        animal.fly();
        assertTrue(animal.isResting());
    }

    @Test
    void testFeedNotHungryAnimal() {
        assertFalse(animal.isFlying());
        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                animal.fly();
            }
        });
    }

    @Test
    void testAnimalGettingPlayful() {
        //Waiting while animal is sleeping
        for (int i = 0; i < Sleep; i++) {
            animal.tick();
        }
        animal.fly();
        //Waiting while animal is digesting
        for (int i = 0; i < Digest; i++) {
            animal.tick();
        }
        assertTrue(animal.isPlayful());
    }

    @Test
    void testAnimalDying() {
        //Waiting while animal is sleeping and awake before it's going to die
        for (int i = 0; i < Sleep + Awake; i++) {
            animal.tick();
        }
        assertTrue(animal.isDead());
    }

    @Test
    void testAnimalIsGoingToSleepAgain() {
        //Waiting while animal is sleeping
        for (int i = 0; i < Sleep; i++) {
            animal.tick();
        }

        animal.fly();
        for (int i = 0; i < Awake; i++) {
            animal.tick();
        }
        assertTrue(animal.isAsleep());
    }
}
