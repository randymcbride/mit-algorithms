package peakfinding.twodimensions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    private static final Integer dimension = 10000;
    private static final List<List<Integer>> matrix = new ArrayList<>();

    @BeforeAll
    public static void setup(){
        for(int i = 0; i < dimension; i++){
            Integer base = i * dimension;
            ArrayList row = new ArrayList<Integer>();
            for(int j = 0; j < dimension; j++){
                row.add(base+j);
            }
            matrix.add(row);
        }

    }

    //This is O(n2)
    @Test
    public void simpleImplementation(){
        Point peak = SimpleImplementation.findAPeak(matrix);
        assertEquals(dimension - 1, peak.getX());
        assertEquals(dimension - 1, peak.getY());
    }

    //This is O(logn)
    @Test
    public void efficientImplementation(){
        Point peak = EfficientImplementation.findAPeak(matrix);
        assertEquals(dimension - 1, peak.getX());
        assertEquals(dimension - 1, peak.getY());
    }
}
