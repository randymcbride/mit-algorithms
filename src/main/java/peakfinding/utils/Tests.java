package peakfinding.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static peakfinding.utils.PeakFinder.getMiddle;

public class Tests {
    @Test
    public void getMiddle_Tests(){
        assertEquals(2, getMiddle(0,5));
        assertEquals(1, getMiddle(0,2));
        assertEquals(0, getMiddle(0,1));

        assertEquals(2, getMiddle(0,5));
        assertEquals(3, getMiddle(2,5));
        assertEquals(4, getMiddle(3,5));
        assertEquals(5, getMiddle(4,5));
    }
}
