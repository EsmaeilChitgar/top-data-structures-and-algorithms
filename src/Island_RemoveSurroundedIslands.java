public class Island_RemoveSurroundedIslands {
    static int numRows, numCols;

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}};

        numRows = grid.length;
        numCols = grid[0].length;

        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            for (int colIndex = 0; colIndex < numCols; colIndex++) {
                if (rowIndex == 0 || rowIndex == numRows - 1 || colIndex == 0 || colIndex == numCols - 1) {
                    if (grid[rowIndex][colIndex] == 1)
                        grid[rowIndex][colIndex] = 2;
                }
            }
        }

        boolean[][] visited = new boolean[numRows][numCols];

        Island_RemoveSurroundedIslands problem = new Island_RemoveSurroundedIslands();
        problem.markBoundary(grid, visited);

        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            for (int colIndex = 0; colIndex < numCols; colIndex++) {
                System.out.print(grid[rowIndex][colIndex] + " ");
            }
            System.out.println("");
        }
    }

    private void markBoundary(int[][] grid, boolean[][] visited) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }

        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            for (int colIndex = 0; colIndex < numCols; colIndex++) {
                if (grid[rowIndex][colIndex] != 0) {
                    markDfs(rowIndex, colIndex, grid, visited);
                }
            }
        }
    }

    private boolean markDfs(int rowIndex, int colIndex, int[][] grid, boolean[][] visited) {
        if (rowIndex < 0 || rowIndex >= grid.length || colIndex < 0 || colIndex >= grid[0].length) {
            return false;
        }

        if (grid[rowIndex][colIndex] == 0) {
            return false;
        }

        if (grid[rowIndex][colIndex] == 2) {
            return true;
        }

        if (visited[rowIndex][colIndex]) {
            return false;
        }

        visited[rowIndex][colIndex] = true;

        boolean isPartOfBoundary = markDfs(rowIndex, colIndex - 1, grid, visited) ||
                markDfs(rowIndex, colIndex + 1, grid, visited) ||
                markDfs(rowIndex - 1, colIndex, grid, visited) ||
                markDfs(rowIndex + 1, colIndex, grid, visited);

        if (isPartOfBoundary) {
            grid[rowIndex][colIndex] = 2;
            return true;
        }

        grid[rowIndex][colIndex] = 0;
        return false;
    }
}