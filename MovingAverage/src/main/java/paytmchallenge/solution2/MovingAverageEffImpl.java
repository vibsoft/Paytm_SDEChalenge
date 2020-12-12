package paytmchallenge.solution2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Implementation of MovingAverageEff based on assumptions
 * that moving N provided ones in constructor and only items used in Moving N calculation are persists.
 *
 * @param <T extends Number> T any type with is extended from Number
 */
public class MovingAverageEffImpl<T extends Number> implements MovingAverageEff<T>{

    private Deque<T> items;
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
    public Deque<T> getItems() {
        return items;
    }

    @Override
    public int getMovingN() {
        return movingN;
    }

    @Override
    public Double getMovingSum() {
        return movingSum;
    }

    @Override
    public void setMovingSum(double movingSum) {
        this.movingSum = movingSum;
    }
}