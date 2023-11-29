/*
 * Copyright (c) 29-29.11.23, 20:05
 * Since: November 2023
 * Author: dustin
 * Name: WizardToolkitTest.java
 * Project-name: HarryPotter
 *
 */

package org.example.tests;

import org.example.HogwartsToolkit;
import org.example.WizardFilter;
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
 * Name: WizardFilter.java
 * <p>
 * Project-name: HarryPotter
 */
public class WizardToolkitTest {

    private HogwartsToolkit testList;

    @BeforeEach
    void setup() {
        testList = new HogwartsToolkit();

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
        HogwartsToolkit result = (HogwartsToolkit) testList.filter(new WizardFilter() {    // create a new SimpleListImpl called result, which will hold the filtered elements.

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
        HogwartsToolkit result = (HogwartsToolkit) testList.filter(new WizardFilter() {    // create a new SimpleListImpl called result, which will hold the filtered elements.
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
        HogwartsToolkit result = (HogwartsToolkit) testList.filter(new WizardFilter() {
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
        HogwartsToolkit result = (HogwartsToolkit) testList.filter(o -> ((int) o) % 2 == 0);
        for (Object o : result) {
            int i = (int) o;
            assertTrue(i % 2 == 0);
        }
    }

    @Test
    void testFilterThirdNumbersLambda() {
        HogwartsToolkit result = (HogwartsToolkit) testList.filter(o -> ((int) o) % 3 == 0);
        for (Object o : result) {
            int i = (int) o;
            assertTrue(i % 3 == 0);
        }
    }
}
