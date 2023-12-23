package assignment.three_generics.model;

/**
 * Copyright (c) 23.12.23, 13:54
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: Shrub.java
 * <p>
 * Project-name: HarryPotter
 */
public class Shrub extends Plant {
    private final PlantColor plantColor;

    public Shrub(String family, String name, double height) {
        super(family, name, height);
        plantColor = PlantColor.GREEN;
    }

    @Override
    public PlantColor getColor() {
        return plantColor;
    }
}
