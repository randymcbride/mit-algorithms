package peakfinding.onedimension;

import peakfinding.utils.PeakFinder;

import java.util.List;
import java.util.Optional;

import static peakfinding.utils.PeakFinder.tryGetValue;

public class SimpleImplementation {
    /**
     * This implementation is O(n) because in the worst case we will iterate through every
     * value in the array.
     */
    public static Integer findAPeak(List<Integer> values){
        for(int i = 0; i<values.size(); i++){
            Integer previous = tryGetValue(values, i-1);
            Integer next = tryGetValue(values, i+1);

            if(PeakFinder.isPeak(values.get(i), previous, next )){
                return i;
            }
        }
        return -1;
    }
}
