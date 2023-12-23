/*
 * Copyright (c) 23-23.12.23, 13:54
 * Since: Dezember 2023
 *   <p>
 * Author: dustin
 *  <p>
 * Name: Spell.java
 *  <p>
 * Project-name: HarryPotter
 *
 */

package assignment.three_generics.task1;

enum Spell {
    EXPELLIARMUS("Disarming spell"),
    LUMOS("Illumination spell"),
    ACCIO("Summoning charm"),
    EXPECTO_PATRONUM("Patronus charm"),
    PATRONUS("Patronus charm"),
    DEFAULT("Unknown spell");

    private String incantation;

    Spell(String incantation) {
        this.incantation = incantation;
    }

    public void cast() {
        System.out.println("Casting " + incantation);
    }
}
