package peakfinding.onedimension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    static List<Integer> worstCase = new ArrayList<>();
    static Integer size = 100000000;

    @BeforeAll
    public static void setup(){
        for(int i = 0; i < size; i++){
            worstCase.add(i);
        }

    }

    //The important thing here is to look at how long the tests take to run
    //This test should be about 250 ms, which is O(n)
    @Test
    public void simpleSolution(){
        Integer peakIndex = SimpleImplementation.findAPeak(worstCase);
        assertEquals(size - 1, peakIndex);
    }

    //The important thing here is to look at how long the tests take to run
    //This test should be about 2 ms, which is O(logn)🎆
    @Test void efficientSolution(){
        Integer peakIndex = EfficientImplementation.findAPeak(worstCase);
        assertEquals(size - 1, peakIndex);
    }
}
