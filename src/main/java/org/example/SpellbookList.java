package org.example;

/**
 * Copyright (c) 29.11.23, 19:57
 * Since: November 2023
 * Author: dustin
 * Name: SpellbookList.java
 * Project-name: HarryPotter
 * <p>
 * aka SimpleList
 */

public interface SpellbookList {
    /**
     * Add a given object to the back of the list.
     */
    void add(Object o);

    /**
     * @return current size of the list
     */
    int size();

    /**
     * Generate a new list using the given filter instance.
     *
     * @return a new, filtered list
     */
    SpellbookList filter(SimpleFilter filter);
}

