package assignment.three_generics.collections;

import java.util.function.Predicate;

/**
 * Copyright (c) 23.12.23, 13:54
 * Since: Dezember 2023
 *   <p>
 * Author: dustin
 *  <p>
 * Name: MagicalList.java
 *  <p>
 * Project-name: HarryPotter
 *
 */
public interface MagicalList<T> extends Iterable<T> {

    int size();

    T get(int index);

    void set(int index, T item);

    void add(T item);

    default MagicalList<T> filter(Predicate<T> predicate) {
        MagicalList<T> filteredList = new MagicalListImpl<>();
        for (T item : this) {
            if (predicate.test(item)) {
                filteredList.add(item);
            }
        }

        return filteredList;
    }
}

