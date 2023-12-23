package assignment.three_generics.tests.collections;

import assignment.three_generics.collections.MagicalList;
import assignment.three_generics.collections.MagicalListImpl;
import org.slf4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Copyright (c) 23.12.23, 20:03
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: MagicalListTest.java
 * <p>
 * Project-name: HarryPotter
 */
class MagicalListTest {

    private final Logger logger = LoggerFactory.getLogger(MagicalListTest.class);
    private MagicalList<Integer> testList;

    @BeforeEach
    void setup() {
        testList = new MagicalListImpl<>();

        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
    }

    @Test
    void testAddElements() {
        logger.info("Testing if adding and iterating elements is implemented correctly");
        int counter = 0;
        for (Object o : testList) {
            counter++;
        }
        assertEquals(5, counter);
    }

    @Test
    void testSize() {
        logger.info("Testing if size() method is implemented correctly");
        assertEquals(5, testList.size());
    }

    @Test
    void testFilterAnonymousClass() {
        logger.info("Testing the filter possibilities by filtering for all elements greater 2");
        MagicalList<Integer> result = testList.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer item) {
                return item > 2;
            }
        });

        for (Integer i : result) {
            assertTrue(i > 2);
        }
    }

    @Test
    void testFilterLambda() {
        logger.info("Testing the filter possibilities by filtering for all elements which are dividable by 2");
        MagicalList<Integer> result = testList.filter(o -> o % 2 == 0);
        for (Integer i : result) {
            assertTrue(i % 2 == 0);
        }
    }
}
