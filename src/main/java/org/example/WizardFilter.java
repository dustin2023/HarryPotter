package org.example;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
@FunctionalInterface
public interface WizardFilter {
	/**
	 * @param item Object to evaluate
	 * @return true if the referenced object should be included.
	 */
	boolean include(Object item);
}
