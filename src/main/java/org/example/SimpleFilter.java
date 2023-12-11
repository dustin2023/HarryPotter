package org.example;

/**
 * Copyright (c) 11.12.23, 14:47
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: SimpleFilter.java
 * <p>
 * Project-name: HarryPotter
 */
@FunctionalInterface
public interface SimpleFilter {
    /**
     * @param item Object to evaluate
     * @return true if the referenced object should be included.
     */
    boolean include(Object item);
}
