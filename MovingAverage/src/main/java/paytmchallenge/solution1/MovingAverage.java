package paytmchallenge.solution1;

import java.util.Collection;

/**
 * Interface to calculate Moving average based on assumptions
 * that moving N  provided as function's parameter and we persist all added items.
 * - get all elements
 * - add element
 * - get moving average based on moving N parameter
 *
 * Complexity for getMovingAverage(int MovingN) is O(n) - we will scan all items in the list
 *
 * @param <T extends Number> T any type with is extended from Number
 */
public interface MovingAverage<T extends Number>{

    /**
     * Function to get all data items
     */
    Collection<T> getItems();


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


    /**
     * Function to get moving average. Not accept negative moving N.
     * Return null if size of collection less than movingN.
     *
     * @param movingN moving N value to calculate
     * @return moving average value for defined movingN
     * @throws IllegalArgumentException
     */
    default Double getMovingAverage(int movingN){
        if (movingN < 0)
            throw new IllegalArgumentException("Moving number can not be less then 0");

        int size = getSize();

        if (size < movingN){
            return null;
        } else {
            double movingSum = getItems().stream()
                    .skip(Math.max(0, size - movingN))
                    .mapToDouble(Number::doubleValue)
                    .sum();

            return movingSum/movingN;
        }
    }
}
