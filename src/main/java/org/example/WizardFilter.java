package org.example;
@FunctionalInterface
public interface WizardFilter {
	/**
	 * @param item Object to evaluate
	 * @return true if the referenced object should be included.
	 */
	boolean include(Object item);
}
