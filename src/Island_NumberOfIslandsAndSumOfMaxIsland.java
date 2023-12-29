public class Island_NumberOfIslandsAndSumOfMaxIsland {
    private int numOfIslandsMultiplyBy1000PlusMaxSumOfIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;

        int result = 0;
        int max = 0;
        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            for (int colIndex = 0; colIndex < numCols; colIndex++) {
                if (grid[rowIndex][colIndex] != 0) {
                    max = Math.max(max, dfs(rowIndex, colIndex, grid));
                    result++;
                }
            }
        }

        return result * 1000 + max;
    }

    private int dfs(int rowIndex, int colIndex, int[][] grid) {
        if (rowIndex < 0 || rowIndex >= grid.length || colIndex < 0 || colIndex >= grid[0].length) {
            return 0;
        }

        int sum = 0;
        if (grid[rowIndex][colIndex] != 0) {

            sum += grid[rowIndex][colIndex];
            grid[rowIndex][colIndex] = 0;

            sum += dfs(rowIndex - 1, colIndex - 1, grid);
            sum += dfs(rowIndex, colIndex - 1, grid);
            sum += dfs(rowIndex + 1, colIndex - 1, grid);

            sum += dfs(rowIndex - 1, colIndex, grid);
            sum += dfs(rowIndex + 1, colIndex, grid);

            sum += dfs(rowIndex - 1, colIndex + 1, grid);
            sum += dfs(rowIndex, colIndex + 1, grid);
            sum += dfs(rowIndex + 1, colIndex + 1, grid);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {13, 1, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 25, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 8, 1, 1}};

        Island_NumberOfIslandsAndSumOfMaxIsland islandNumberOfIslandsAndSumOfMaxIsland = new Island_NumberOfIslandsAndSumOfMaxIsland();
        System.out.println(islandNumberOfIslandsAndSumOfMaxIsland.numOfIslandsMultiplyBy1000PlusMaxSumOfIslands(grid));
    }
}
