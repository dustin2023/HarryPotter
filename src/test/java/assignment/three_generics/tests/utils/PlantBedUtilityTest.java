package assignment.three_generics.tests.utils;

import assignment.three_generics.collections.MagicalList;
import assignment.three_generics.collections.MagicalListImpl;
import assignment.three_generics.model.Flower;
import assignment.three_generics.model.PlantBed;
import assignment.three_generics.model.PlantColor;
import assignment.three_generics.model.Plant;
import assignment.three_generics.utils.PlantBedUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
class PlantBedUtilityTest {

    private PlantBed<Flower> flowerBed;

    @BeforeEach
    void setup() {

        flowerBed = new PlantBed<>();

        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.4, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Abracadabra", 0.5, PlantColor.RED));
        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.3, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.35, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Abracadabra", 0.35, PlantColor.RED));
        flowerBed.add(new Flower("Rosa", "Rosa chinensis", 0.45, PlantColor.ORANGE));
        flowerBed.add(new Flower("Tulip", "Curly Sue", 0.55, PlantColor.VIOLETTE));
    }

    @Test
    void testSplitByBedByColorResultingSize() {
        Map<PlantColor, MagicalList<Flower>> split = PlantBedUtility.splitBedByColor(flowerBed);
        assertEquals(6, split.keySet().size());
    }

    @Test
    void testSplitByBedByColorPureness() {
        Map<PlantColor, MagicalList<Flower>> split = PlantBedUtility.splitBedByColor(flowerBed);
        for (Flower f : split.get(PlantColor.YELLOW)) {
            assertEquals(PlantColor.YELLOW, f.getColor());
        }
    }

    @Test
    void testSplitByBedByColorPureness2() {
        Map<PlantColor, MagicalList<Flower>> split = PlantBedUtility.splitBedByColor(flowerBed);
        for (Flower f : split.get(PlantColor.YELLOW)) {
            assertEquals(PlantColor.YELLOW, f.getColor());
        }
    }

    @Test
    void testPECS() {
        MagicalList<Plant> dest = new MagicalListImpl<>();
        PlantBedUtility.pecs(dest, flowerBed.getPlants());
        for (Plant plant : dest) {
            assertTrue(plant instanceof Flower);
        }
    }

    @Test
    void testPecs_with_filter() {
        MagicalList<Plant> dest = new MagicalListImpl<>();
        PlantBedUtility.pecs_with_filter(dest, flowerBed.getPlants(), flower -> flower.getColor().equals(PlantColor.YELLOW));
        for (Plant plant : dest) {
            assertEquals(PlantColor.YELLOW, plant.getColor());
        }
    }

}