package assignment.one_simple_list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Copyright (c) 29.11.23, 20:18
 * Since: November 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: HogwartsToolkit.java
 * <p>
 * Project-name: HarryPotter
 */

public class SpellbookListImpl implements SpellbookList, Iterable<Object> {
    private Spellbook head;
    private int size;

    public SpellbookListImpl() {
        this.head = null;
    }

    @Override
    public Iterator<Object> iterator() {
        return new SpellbookIterator(); // return a new instance of SpellbookIterator
    }

    @Override
    public void add(Object item) {
        if (head == null) {
            head = new Spellbook(item);   // If the list is empty, create the first element and set it as the head.
        } else {
            // traverse to the end and add the new element there.
            Spellbook current = head;
            while (current.next != null) {    // Iterate through the list until we reach the end.
                current = current.next; // Move to the next element.
            }
            current.next = new Spellbook(item);  // Set the next element to the new element. This is the end of the list.
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public SpellbookList filter(SimpleFilter filter) {
        SpellbookListImpl filteredList = new SpellbookListImpl(); // Create a new list to store filtered elements.
        Spellbook current = head; // Start at the head of the list.
        while (current != null) {    // Iterate through the list until we reach the end.
            if (filter.include(current.item)) {  // If the current element should be included in the filtered list...
                filteredList.add(current.item); // ...add it to the filtered list.
            }
            current = current.next; // Move to the next element.
        }
        return filteredList;
    }

    // inner class because it needs access to the outer class (SpellbookListImpl)
    // This class will allow us to iterate through the elements of the linked list.
    private class SpellbookIterator implements Iterator<Object> {
        private Spellbook current = head; // start at the head of the list

        @Override
        public boolean hasNext() {
            return current != null; // if current is null, we are at the end of the list
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object item = current.item; // get the item from the current element
            current = current.next;     // move to the next element
            return item;
        }
    }

    // represent the elements in our linked List
    // static class because it does not need access to the outer class (SpellbookListImpl)
    private static class Spellbook {
        private Object item; // store data for this element
        private Spellbook next; // reference to next element

        public Spellbook(Object item) {
            this.item = item; // store item
            this.next = null; // next element is null for now
        }
    }
}
