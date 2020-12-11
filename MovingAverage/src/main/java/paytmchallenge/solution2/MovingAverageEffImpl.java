package paytmchallenge.solution2;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of MovingAverageEff based on assumptions
 * that moving N provided ones in constructor and only items used in Moving N calculation are persists.
 *
 * Complexity for getMovingAverage() is O(1)
 *  - add item to the end of LinkedList to the end is O(1)
 *  - remove first item from head of LinkedList is O(1)
 *
 * @param <T extends Number> T any type with is extended from Number
 */
public class MovingAverageEffImpl<T extends Number> implements MovingAverageEff<T>{

    private Queue<T> items;
    private int movingN;
    private Double movingSum;

    public MovingAverageEffImpl(int movingN){
        if (movingN < 0)
            throw new IllegalArgumentException("Moving number can not be less then 0");

        this.items = new LinkedList<>();
        this.movingN = movingN;
        this.movingSum = 0d;
    }

    @Override
    public Collection<T> getItems() {
        return items;
    }

    @Override
    public int getMovingN() {
        return movingN;
    }

    @Override
    public void add(T item) {
        MovingAverageEff.super.add(item);

        // add added item value to moving sum
        movingSum = movingSum + item.doubleValue();

        // if size of queue more than moving N than
        // remove first item from queue
        // and subtract removed item value from moving sum which used for moving average calculation
        if (getSize() > movingN) {
            movingSum = movingSum - items.remove().doubleValue();
        }
    }

    @Override
    public Double getMovingAverage() {
        return (getSize() < movingN)
                ? null
                : movingSum/movingN;
    }
}