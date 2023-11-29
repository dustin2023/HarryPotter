package org.example;

// aka SimpleList
public interface WizardToolkit {
    /**
     * Add a given object to the back of the list.
     */
    void add(Object o);

    /**
     * @return current size of the list
     */
    int size();

    /**
     * Generate a new list using the given filter instance.
     *
     * @return a new, filtered list
     */
    WizardToolkit filter(WizardFilter filter);
}

