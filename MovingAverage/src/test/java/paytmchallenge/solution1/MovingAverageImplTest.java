package paytmchallenge.solution1;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MovingAverageImplTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddItemNull()  {
        MovingAverage<Integer> simple = new MovingAverageImpl<>();

        simple.add(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetMovingAverageNegative()  {
        MovingAverage<Integer> simple = new MovingAverageImpl<>();

        simple.getMovingAverage(-1);
    }

    @Test
    public void testGetMovingAverageInteger() {
        MovingAverage<Integer> simple = new MovingAverageImpl<>();

        // 5
        simple.add(5);
        assertEquals(simple.getMovingAverage(1), Double.valueOf(5));
        assertEquals(simple.getMovingAverage(2), null);
        assertEquals(simple.getSize(),1);

        // 5, 15
        simple.add(15);
        assertEquals(simple.getMovingAverage(1), Double.valueOf(15));
        assertEquals(simple.getMovingAverage(2), Double.valueOf((5d+15d)/2));
        assertEquals(simple.getMovingAverage(3), null);
        assertEquals(simple.getSize(),2);

        // 5, 15, 20
        simple.add(20);
        assertEquals(simple.getMovingAverage(1), Double.valueOf(20));
        assertEquals(simple.getMovingAverage(2), Double.valueOf((15d+20d)/2));
        assertEquals(simple.getMovingAverage(3), Double.valueOf((5d+15d+20d)/3), 0.01);
        assertEquals(simple.getSize(),3);
    }


    @Test
    public void testGetMovingAverageDouble() {
        MovingAverage<Double> simple = new MovingAverageImpl<>();

        // 5.25
        simple.add(5.25);
        assertEquals(simple.getMovingAverage(1), Double.valueOf(5.25d));
        assertEquals(simple.getMovingAverage(2), null);
        assertEquals(simple.getSize(),1);

        // 5.25, 15.50
        simple.add(15.50);
        assertEquals(simple.getMovingAverage(1), Double.valueOf(15.50), 0.01);
        assertEquals(simple.getMovingAverage(2), Double.valueOf((5.25 + 15.50)/2), 0.01);
        assertEquals(simple.getMovingAverage(3), null);
        assertEquals(simple.getSize(),2);

        // 5.25, 15.50, 20.75
        simple.add(20.75);
        assertEquals(simple.getMovingAverage(1), Double.valueOf(20.75), 0.01);
        assertEquals(simple.getMovingAverage(2), Double.valueOf((15.50 + 20.75)/2), 0.01);
        assertEquals(simple.getMovingAverage(3), Double.valueOf((5.25 + 15.50 + 20.75)/3), 0.01);
        assertEquals(simple.getMovingAverage(4), null);
        assertEquals(simple.getSize(),3);
    }
}