package assignment.three_generics.model;

/**
 * Copyright (c) 23.12.23, 19:27
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: Flower.java
 * <p>
 * Project-name: HarryPotter
 */
public class Flower extends Plant {
    private final PlantColor plantColor;

    public Flower(String family, String name, double height, PlantColor plantColor) {
        super(family, name, height);

        /* ensure that a flower is never green */
        if (plantColor == PlantColor.GREEN) {
            throw new IllegalStateException("A plant may not be green");
        }
        this.plantColor = plantColor;
    }

    @Override
    public PlantColor getColor() {
        return plantColor;
    }
}
