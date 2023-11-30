package org.example.tests;

import org.example.SimpleFilter;
import org.example.SpellbookListImple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Copyright (c) 29.11.23, 20:05
 * Since: November 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: SimpleFilter.java
 * <p>
 * Project-name: HarryPotter
 */
public class SpellbookListImpleTest {

    private SpellbookListImple testList;

    @BeforeEach
    void setup() {
        testList = new SpellbookListImple();

        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
    }

    @Test
    void testAddElements() {
        int counter = 0;
        for (Object o : testList) {
            counter++;
        }
        assertEquals(5, counter);
    }

    @Test
    void testSize() {
        assertEquals(5, testList.size());
    }

    @Test
    void testFilterAnonymousClass() {
        SpellbookListImple result = (SpellbookListImple) testList.filter(new SimpleFilter() {    // create a new SimpleListImpl called result, which will hold the filtered elements.

            @Override
            public boolean include(Object item) {    // You use an anonymous class to implement the SimpleFilter interface and override the include method to define the filter logic.
                // In this case, you're filtering elements greater than 2.
                int current = (int) item;
                return current > 2;
            }
        });

        for (Object o : result) {
            int i = (int) o;
            assertTrue(i > 2);
        }
    }

    @Test
    void testFilterEveryThirdNumber() {
        SpellbookListImple result = (SpellbookListImple) testList.filter(new SimpleFilter() {    // create a new SimpleListImpl called result, which will hold the filtered elements.
            @Override
            public boolean include(Object item) {
                int current = (int) item;
                return current % 3 == 0;
            }
        });
        for (Object o : result) {
            int i = (int) o;
            assertTrue(i % 3 == 0);
        }
    }

    @Test
    void testFilterEvenNumbers() {
        SpellbookListImple result = (SpellbookListImple) testList.filter(new SimpleFilter() {
            @Override
            public boolean include(Object item) {
                int current = (int) item;
                return current % 2 == 0;
            }
        });

        for (Object o : result) {
            int i = (int) o;
            assertTrue(i % 2 == 0);
        }
    }

    @Test
    void testFilterLambda() {
        SpellbookListImple result = (SpellbookListImple) testList.filter(o -> ((int) o) % 2 == 0);
        for (Object o : result) {
            int i = (int) o;
            assertTrue(i % 2 == 0);
        }
    }

    @Test
    void testFilterThirdNumbersLambda() {
        SpellbookListImple result = (SpellbookListImple) testList.filter(o -> ((int) o) % 3 == 0);
        for (Object o : result) {
            int i = (int) o;
            assertTrue(i % 3 == 0);
        }
    }
}
