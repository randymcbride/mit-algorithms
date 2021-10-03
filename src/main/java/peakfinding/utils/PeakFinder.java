package peakfinding.utils;

import java.util.List;
import java.util.Optional;

public class PeakFinder {
    public static boolean isPeak(Integer value, Integer previous, Integer next){
        return (previous == null || value >= previous)
                && (next == null || value >= next);
    }

    public static <T> T tryGetValue(List<T> values, int index) {
        return index == values.size() || index < 0 ? null : values.get(index);
    }

    public static int getMiddle(Integer start, Integer end) {
        if(end - start ==1 && start != 0)return end;
        return (int) Math.ceil((end - start) / 2)+ start;
    }
}
