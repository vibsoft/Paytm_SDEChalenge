package paytmchallenge.solution2;

import java.util.Deque;

/**
 * Interface to calculate Moving average based on assumptions
 * that moving N provided ones (initialized in constructor) and only items used in Moving N calculation are persists.
 *
 * Complexity for getMovingAverage() is O(1)
 *  - add item to the end of Deque to the end is O(1)
 *  - remove first item from head of Deque is O(1)
 *
 * @param <T extends Number> T any type with is extended from Number
 */
public interface MovingAverageEff<T extends Number>{

    /**
     * Function to get all data items
     *
     * @return collection of data item
     */
    Deque<T> getItems();


    /**
     * Function to get Moving N value
     * @return current Moving N value
     */
    int getMovingN();


    /**
     * Function to get sum for current moving window
     * @return current sum for moving window
     */
    Double getMovingSum();

    /**
     * Function to set sum for current moving window
     * @param movingSum current sum for moving window
     */
    void setMovingSum(double movingSum);


    /**
     * Function to add an element to the data collection.
     * Not accept null values
     *
     * @param item value to be added into the list
     * @throws IllegalArgumentException if item null
     */
    default void add(T item){
        if (item == null)
            throw new IllegalArgumentException("Item can not be null");

        // get current moving sum
        Double currentMovingSum = getMovingSum();

        // add item into data collection
        getItems().add(item);

        // add item value to current moving sum
        currentMovingSum += item.doubleValue();

        // if size of queue more than moving N than
        // remove first item from queue
        // and subtract removed item value from moving sum
        if (getSize() > getMovingN()) {
            currentMovingSum -= getItems().remove().doubleValue();
        }

        //set new moving sum for moving window
        setMovingSum(currentMovingSum);
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
     * Function to get moving average.
     * Return null if size of collection less than moving N.
     *
     * @return moving average value
     */
    default Double getMovingAverage() {
        return (getSize() < getMovingN())
                ? null
                : getMovingSum()/getMovingN();
    }
}