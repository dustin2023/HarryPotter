package assignment.three_generics.collections;

import java.util.function.Predicate;

/**
 * Copyright (c) 23.12.23, 13:54
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: MagicalList.java
 * <p>
 * Project-name: HarryPotter
 */
public interface MagicalList extends Iterable {
    int size();

    void add(Object item);


    Object get(int index);

    void set(int index, Object item);

    SimpleList filter(Predicate predicate);

}

