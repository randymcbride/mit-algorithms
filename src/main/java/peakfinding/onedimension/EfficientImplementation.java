package peakfinding.onedimension;

import java.util.List;

import static peakfinding.utils.PeakFinder.*;

public class EfficientImplementation {
    public static Integer findAPeak(List<Integer> values){
        return checkPeak(values, 0, values.size());
    }

    private static Integer checkPeak(List<Integer> values, Integer start, Integer end){
        Integer mid = getMiddle(start, end);
        Integer value = values.get(mid);
        Integer previous = tryGetValue(values, mid-1);
        Integer next = tryGetValue(values, mid+1);

        if(isPeak(value, previous, next)|| previous == null || next == null){
            return mid;
        }else if( value < previous){
            return checkPeak(values, start, mid);
        }else{
            return checkPeak(values, mid, end);
        }
    }
}
