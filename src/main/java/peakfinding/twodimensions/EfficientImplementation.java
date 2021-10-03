package peakfinding.twodimensions;

import java.awt.Point;
import java.util.List;

import static peakfinding.utils.PeakFinder.getMiddle;
import static peakfinding.utils.PeakFinder.isPeak;

public class EfficientImplementation {
    public static Point findAPeak(List<List<Integer>> matrix){
        return checkPeak(matrix, 0, matrix.get(0).size());
    }

    private static Point checkPeak(List<List<Integer>> matrix, Integer startCol, Integer endCol) {
        Integer midCol = getMiddle(startCol, endCol);

        //get max value row for column
        Integer max = matrix.get(0).get(midCol);
        Integer rowIndex = 0;
        for(int i = 1; i < matrix.size(); i++){
            Integer value = matrix.get(i).get(midCol);
            if(value > max){
                max = value;
                rowIndex = i;
            }
        }

        // if is edge column return coordinates
        if(midCol == matrix.get(0).size() - 1 || midCol == 0){
            return new Point(midCol, rowIndex);
        }

        Integer value = matrix.get(rowIndex).get(midCol);
        Integer previousValueInRow = matrix.get(rowIndex).get(midCol - 1);
        Integer nextValueInRow = matrix.get(rowIndex).get(midCol + 1);

        //if is peak in row then return coordinates
        if(isPeak(value, previousValueInRow, nextValueInRow)){
            return new Point(midCol, rowIndex);
        }

        //else if < prev value in row then recursive for half of midCol to left
        else if(value < previousValueInRow){
            return checkPeak(matrix, startCol, midCol);
        }

        // else if < next value in row then recursive for half of midCol to right

        else {
            return checkPeak(matrix, midCol, endCol);
        }
    }
}
