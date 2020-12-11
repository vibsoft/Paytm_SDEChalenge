package paytmchallenge.solution2;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MovingAverageEffImplTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddItemNull()  {
        MovingAverageEff<Integer> eff = new MovingAverageEffImpl<>(3);

        eff.add(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMovingNNegative()  {
        MovingAverageEff<Integer> eff = new MovingAverageEffImpl<>(-1);
    }

    @Test
    public void testGetMovingAverageInteger() {

        // Moving Average N = 3
        MovingAverageEff<Integer> eff = new MovingAverageEffImpl<>(3);

        // 5
        eff.add(5);
        assertEquals(eff.getSize(), 1);
        assertEquals(eff.getMovingAverage(), null);

        // 5, 15
        eff.add(15);
        assertEquals(eff.getSize(), 2);
        assertEquals(eff.getMovingAverage(), null);

        // 5, 15, 20
        eff.add(20);
        assertEquals(eff.getSize(), 3);
        assertEquals(eff.getMovingAverage(), Double.valueOf((5d+15d+20d)/3), 0.01);

        // 15, 20, 31
        eff.add(31);
        assertEquals(eff.getSize(), 3);
        assertEquals(eff.getItems().stream().findFirst().get(), Integer.valueOf(15));
        assertEquals(eff.getMovingAverage(), Double.valueOf((15d+20d+31d)/3), 0.01);

        // 20, 31, 42
        eff.add(42);
        assertEquals(eff.getSize(), 3);
        assertEquals(eff.getItems().stream().findFirst().get(), Integer.valueOf(20));
        assertEquals(eff.getMovingAverage(), Double.valueOf((20d+31d+42)/3), 0.01);
    }


    @Test
    public void testGetMovingAverageDouble() {

        // Moving Average N = 3
        MovingAverageEff<Double> eff = new MovingAverageEffImpl<>(3);

        // 5.25
        eff.add(5.25);
        assertEquals(eff.getSize(), 1);
        assertEquals(eff.getMovingAverage(), null);

        // 5.25, 15.50
        eff.add(15.50);
        assertEquals(eff.getSize(), 2);
        assertEquals(eff.getMovingAverage(), null);

        // 5.25, 15.50, 20.75
        eff.add(20.75);
        assertEquals(eff.getSize(), 3);
        assertEquals(eff.getMovingAverage(), Double.valueOf((5.25+15.50+20.75)/3), 0.01);

        // 15.50, 20.75, 27.45
        eff.add(27.45);
        assertEquals(eff.getSize(), 3);
        assertEquals(eff.getItems().stream().findFirst().get(), Double.valueOf(15.50));
        assertEquals(eff.getMovingAverage(), Double.valueOf((15.50+20.75+27.45 )/3), 0.01);

        // 20.75, 27.45, 30.50
        eff.add(30.50);
        assertEquals(eff.getSize(), 3);
        assertEquals(eff.getItems().stream().findFirst().get(), Double.valueOf(20.75));
        assertEquals(eff.getMovingAverage(), Double.valueOf((20.75+27.45+30.50)/3), 0.01);
    }
}