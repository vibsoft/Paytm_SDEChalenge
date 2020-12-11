package paytmchallenge.solution2;

import java.util.Collection;

/**
 * Interface to calculate Moving average based on assumptions
 * that moving N provided ones (initialized in constructor) and only items used in Moving N calculation are persists.
 * - get all elements
 * - add element
 * - get moving average
 *
 * @param <T extends Number> T any type with is extended from Number
 */
public interface MovingAverageEff<T extends Number>{

    /**
     * Function to get all data items
     *
     * @return collection of data item
     */
    Collection<T> getItems();

    /**
     * Function to get get current Moving N value
     * @return current moving N value
     */
    int getMovingN();

    /**
     * Function to get moving average.
     * Return null if size of collection less than moving N.
     *
     * @return moving average value
     */
    Double getMovingAverage();


    /**
     * Function to add an element to the list.
     * Not accept null values
     *
     * @param item value to be added into the list
     * @throws IllegalArgumentException if item null
     */
    default void add(T item){
        if (item == null)
            throw new IllegalArgumentException("Item can not be null");

        getItems().add(item);
    }

    /**
     * Function to get size of data collection.
     *
     * @return size of data collection
     */
    default int getSize(){
        return getItems().size();
    }
}