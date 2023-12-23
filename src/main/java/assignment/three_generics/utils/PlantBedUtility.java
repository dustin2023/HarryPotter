package assignment.three_generics.utils;

import assignment.three_generics.collections.MagicalList;
import assignment.three_generics.model.Plant;
import assignment.three_generics.model.PlantBed;
import assignment.three_generics.model.PlantColor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Copyright (c) 23.12.23, 13:54
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: PlantBedUtility.java
 * <p>
 * Project-name: HarryPotter
 */
public abstract class PlantBedUtility {

    public static <T extends Plant> void pecs(MagicalList<? super T> dest, MagicalList<? extends T> source) {

        for (T t : source) {
            dest.add(t);
        }
    }

    public static <T extends Plant> void pecs_with_filter(MagicalList<? super T> dest, MagicalList<? extends T> source, Predicate<T> p) {

        for (T t : source) {
            if (p.test(t)) {
                dest.add(t);
            }
        }
    }

    public static <T extends Plant> Map<PlantColor, MagicalList<T>> splitBedByColor(PlantBed<T> plantBed) {

        Map<PlantColor, MagicalList<T>> result = new HashMap<>();

        for (PlantColor color : PlantColor.values()) {
            result.put(color, plantBed.getPlantsByColor(color));
        }
        return result;
    }

}
