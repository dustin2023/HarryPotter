package assignment.one_simple_list.tests;

import assignment.one_simple_list.SimpleFilter;
import assignment.one_simple_list.SpellbookListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Copyright (c) 29.11.23, 20:05
 * Since: November 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: SimpleFilter.java
 * <p>
 * Project-name: HarryPotter
 */
class SpellbookListImplTest {

    private SpellbookListImpl testList;

    @BeforeEach
    void setup() {
        testList = new SpellbookListImpl();

        testList.add("The Standard Book of Spells");
        testList.add("A Beginner's Guide to Transfiguration");
        testList.add("The Dark Forces: A Guide to Self-Protection");
        testList.add("One Thousand Magical Herbs and Fungi");
        testList.add("Fantastic Beasts and Where to Find Them");
        testList.add("Advanced Potion-Making");
        testList.add("History of Magic");
        testList.add("Magical Drafts and Potions");
        testList.add("Charms of Defence and Deterrence");
        testList.add("Secrets of the Darkest Art");
        testList.add("Unfogging the Future");
        testList.add("The Standard Book of Spells, Grade 1");
        testList.add("Quintessence: A Quest");
    }

    @Test
    void testSpellbooksCount() {
        int counter = 0;
        for (Object o : testList) {
            counter++;
        }
        assertEquals(13, counter);
    }

    @Test
    void testSize() {
        assertEquals(13, testList.size());
    }

    @Test
    void testFilterStandardSpellsAnonymousClass() {
        SpellbookListImpl result = (SpellbookListImpl) testList.filter(new SimpleFilter() {    // create a new SimpleListImpl called result, which will hold the filtered elements.

            @Override
            public boolean include(Object item) {    // You use an anonymous class to implement the SimpleFilter interface and override the include method to define the filter logic.
                // In this case, you're filtering elements contains Spells.
                String spellbook = (String) item;
                return spellbook.contains("Spells");
            }
        });
        int counter = 0;
        for (Object o : result) {
            String spellbook = (String) o;
            counter++;
            assertTrue(spellbook.contains("Spells"));
        }
        System.out.println("There are " + counter + " standard Spellbooks");
    }

    @Test
    void testFilterEveryThirdNumber() {
        SpellbookListImpl result = (SpellbookListImpl) testList.filter(new SimpleFilter() {    // create a new SimpleListImpl called result, which will hold the filtered elements.
            @Override
            public boolean include(Object item) {
                int current = (int) item;
                return current % 3 == 0;
            }
        });
        for (Object o : result) {
            int i = (int) o;
            assertTrue(i % 3 == 0);
        }
    }

    @Test
    void testFilterEveryThirdBook() {
        SpellbookListImpl result = (SpellbookListImpl) testList.filter(new SimpleFilter() {      // create a new SimpleListImpl called result, which will hold the filtered elements.
            int index = 0;

            @Override
            public boolean include(Object item) {
                // Filter every third book in the list.
                index++;
                return index % 3 == 0;
            }
        });
        int bookCount = 0;
        for (Object o : result) {
            bookCount++;
            System.out.println(o);
        }
        assertEquals(4, bookCount);
    }

    @Test
    void testFilterBooksContainingMagical() {
        SpellbookListImpl result = (SpellbookListImpl) testList.filter(new SimpleFilter() {
            @Override
            public boolean include(Object item) {
                String current = (String) item;
                // Filter books that contain the word "Magical".
                return current.contains("Magical");
            }
        });
        for (Object o : result) {
            String book = (String) o;
            assertTrue(book.contains("Magical"));
        }
    }

    @Test
    void testFilterBooksWithLongTitles() {
        SpellbookListImpl result = (SpellbookListImpl) testList.filter(new SimpleFilter() {
            @Override
            public boolean include(Object item) {
                String current = (String) item;
                // Filter books with a title length greater than 25 characters.
                return current.length() > 25;
            }
        });
        for (Object o : result) {
            String book = (String) o;
            System.out.println(book);
            assertTrue(book.length() > 25);
        }
    }

    @Test
    void testFilterLambda() {
        SpellbookListImpl result = (SpellbookListImpl) testList.filter(o -> ((String) o).length() > 20);
        for (Object o : result) {
            String book = (String) o;
            assertTrue(book.length() > 20);
        }
    }

    @Test
    void testFilterThirdNumbersLambda() {
        SpellbookListImpl result = (SpellbookListImpl) testList.filter(o -> ((String) o).startsWith("The"));
        for (Object o : result) {
            String book = (String) o;
            System.out.println(book);
            assertTrue(book.startsWith("The"));
        }
    }

}
