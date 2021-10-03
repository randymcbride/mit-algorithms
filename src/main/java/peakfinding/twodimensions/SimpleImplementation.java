package peakfinding.twodimensions;

import java.awt.Point;
import java.util.List;

import static peakfinding.utils.PeakFinder.isPeak;
import static peakfinding.utils.PeakFinder.tryGetValue;

public class SimpleImplementation {

    public static Point findAPeak(List<List<Integer>> matrix){
        for(int i = 0; i < matrix.size(); i++){
            for (int j = 0; j < matrix.size(); j++){
                List<Integer> row = matrix.get(i);
                List<Integer> rowAbove = tryGetValue(matrix, i - 1);
                List<Integer> rowBelow = tryGetValue(matrix, i +1);

                Integer value = row.get(j);
                Integer above = rowAbove == null ? null : rowAbove.get(j);
                Integer below = rowBelow == null ? null : rowBelow.get(j);
                Integer previous = tryGetValue(row, j-1);
                Integer next = tryGetValue(row, j+1);

                if(isPeak(value, above, below) && isPeak(value, previous, next)){
                    return new Point(j, i);
                }

            }
        }
        return new Point(0,0);
    }
}
