import java.util.ArrayList;
import java.util.List;

public class Island_RiverSizes {
    private List<Integer> getSizes(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new ArrayList<>();
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        List<Integer> list = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            for (int colIndex = 0; colIndex < numCols; colIndex++) {
                if (grid[rowIndex][colIndex] != 0) {
                   list.add(dfs(rowIndex, colIndex, grid));
                }
            }
        }

        return list;
    }

    private int dfs(int rowIndex, int colIndex, int[][] grid) {
        if (rowIndex < 0 || rowIndex >= grid.length || colIndex < 0 || colIndex >= grid[0].length) {
            return 0;
        }

        int sum = 0;
        if (grid[rowIndex][colIndex] != 0) {

            sum += grid[rowIndex][colIndex];
            grid[rowIndex][colIndex] = 0;

            sum += dfs(rowIndex, colIndex - 1, grid);
            sum += dfs(rowIndex, colIndex + 1, grid);

            sum += dfs(rowIndex - 1, colIndex, grid);
            sum += dfs(rowIndex + 1, colIndex, grid);

        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0}};

        Island_RiverSizes islandRiverSizes = new Island_RiverSizes();
        List<Integer> sizes = islandRiverSizes.getSizes(grid);
        System.out.println(sizes);
    }
}
