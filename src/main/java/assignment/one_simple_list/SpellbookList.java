package assignment.one_simple_list;

/**
 * Copyright (c) 11.12.23, 14:47
 * Since: Dezember 2023
 *   <p>
 * Author: dustin
 *  <p>
 * Name: SpellbookList.java
 *  <p>
 * Project-name: HarryPotter
 *
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

