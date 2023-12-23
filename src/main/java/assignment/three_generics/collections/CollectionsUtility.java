package assignment.three_generics.collections;

/**
 * Copyright (c) 23.12.23, 13:54
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: CollectionsUtility.java
 * <p>
 * Project-name: HarryPotter
 */
public abstract class CollectionsUtility {

    private CollectionsUtility() {

    }

    public static <T extends Comparable<T>> void sort(MagicalList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                int cmpResult = list.get(i).compareTo(list.get(j));
                if (cmpResult < 0) {
                    T tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
    }
}

