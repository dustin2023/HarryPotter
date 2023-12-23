package assignment.three_generics.model;

import assignment.three_generics.collections.MagicalList;
import assignment.three_generics.collections.MagicalListImpl;

/**
 * Copyright (c) 23-23.12.23, 19:29
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: PlantBed.java
 * <p>
 * Project-name: HarryPotter
 */
public class PlantBed<T extends Plant> {
    private final MagicalList<T> plants;

    public PlantBed() {
        this.plants = new MagicalListImpl<>();
    }

    public void add(T plant) {
        plants.add(plant);
    }

    public int size() {
        return plants.size();
    }

    public MagicalList<T> getPlantsByColor(PlantColor color) {
        return plants.filter(o -> o.getColor() == color);
    }

    public MagicalList<T> getPlants() {
        return plants;
    }
}
