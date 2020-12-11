package paytmchallenge.solution1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Implementation of MovingAverage interface based on assumption
 * that moving N provided as function's parameter and we persist all added items.
 *
 * Complexity for getMovingAverage(int MovingN) is O(n) - we will scan all items in the list
 *
 * @param <T extends Number> for any numeric Data Type
 */
public class MovingAverageImpl<T extends Number> implements MovingAverage<T>{

    private List<T> items;

    public MovingAverageImpl(){
        this.items = new ArrayList<>();
    }

    @Override
    public Collection<T> getItems() {
        return this.items;
    }
}
