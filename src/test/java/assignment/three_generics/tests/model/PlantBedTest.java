package assignment.three_generics.tests.model;

import assignment.three_generics.collections.MagicalList;
import assignment.three_generics.model.Flower;
import assignment.three_generics.model.PlantBed;
import assignment.three_generics.model.PlantColor;
import assignment.three_generics.model.Shrub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Copyright (c) 23.12.23, 20:03
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: MagicalListTest.java
 * <p>
 * Project-name: HarryPotter
 */
class PlantBedTest {

    private PlantBed<Flower> flowerBed;
    private PlantBed<Shrub> shrubBed;

    @BeforeEach
    void setup() {
        flowerBed = new PlantBed<>();
        shrubBed = new PlantBed<>();

        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.4, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Abracadabra", 0.5, PlantColor.RED));
        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.3, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.35, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Abracadabra", 0.35, PlantColor.RED));
        flowerBed.add(new Flower("Rosa", "Rosa chinensis", 0.35, PlantColor.ORANGE));
        flowerBed.add(new Flower("Tulip", "Curly Sue", 0.35, PlantColor.VIOLETTE));

        shrubBed.add(new Shrub("Buxus", "Buxus sempervirens", 1.5));
        shrubBed.add(new Shrub("Buxus", "Buxus sempervirens", 1.1));
        shrubBed.add(new Shrub("Buxus", "Buxus sempervirens", 1.2));
        shrubBed.add(new Shrub("Buxus", "Buxus sempervirens", 1.4));
    }

    @Test
    void testCreateEmptyPlantBed() {
        PlantBed<Flower> plantBed = new PlantBed<>();
        assertEquals(0, plantBed.size());
    }

    @Test
    void testGetSize() {
        assertEquals(4, shrubBed.size());
        assertEquals(7, flowerBed.size());
    }

    @Test
    void testGetPlantsByColorYellow() {
        MagicalList<Flower> flowers = flowerBed.getPlantsByColor(PlantColor.YELLOW);
        assertEquals(3, flowers.size());
        for (Flower f : flowers) {
            assertEquals(PlantColor.YELLOW, f.getColor());
        }
    }

    @Test
    void testGetPlantsByColorRed() {
        MagicalList<Flower> flowers = flowerBed.getPlantsByColor(PlantColor.RED);
        assertEquals(2, flowers.size());
        for (Flower f : flowers) {
            assertEquals(PlantColor.RED, f.getColor());
        }
    }

    @Test
    void testGetPlantsByColorGreen() {
        MagicalList<Flower> flowers = flowerBed.getPlantsByColor(PlantColor.GREEN);
        assertEquals(0, flowers.size());

        MagicalList<Shrub> shrubs = shrubBed.getPlantsByColor(PlantColor.GREEN);
        assertEquals(4, shrubs.size());
    }

}