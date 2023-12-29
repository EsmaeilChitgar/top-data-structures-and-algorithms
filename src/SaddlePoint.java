import java.util.ArrayList;
import java.util.List;

public class SaddlePoint {
    public List<Integer> points(int[][] grid) {
        List<Integer> resultList = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return resultList;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;

        for (int row = 0; row < numRows; row++) {
            int maxInCurrentRow = grid[row][0];
            int colIndexOfMaxInCurrentRow = 0;

            for (int col = 1; col < numCols; col++) {
                if (grid[row][col] > maxInCurrentRow) {
                    maxInCurrentRow = grid[row][col];
                    colIndexOfMaxInCurrentRow = col;
                }
            }

            boolean found = true;
            for (int k = 0; k < numRows; k++) {
                if (grid[k][colIndexOfMaxInCurrentRow] < maxInCurrentRow) {
                    found = false;
                    break;
                }
            }

            if (found) {
                resultList.add(row);
                resultList.add(colIndexOfMaxInCurrentRow);
                return resultList;
            }
        }

        return resultList;
    }


    public static void main(String[] args) {
        SaddlePoint saddlePoint = new SaddlePoint();
        int[][] grid = new int[][]{
                {1, 2, 3, 4},
                {2, 7, 8, 6},
                {9, 5, 1, 7}
        };

        System.out.println(saddlePoint.points(grid));
    }
}