class Solution {
    private int rows, cols;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int totalPaths = 0;
    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int startX = 0, startY = 0, emptyCells = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    startX = r;
                    startY = c;
                } else if (grid[r][c] == 0) {
                    emptyCells++;
                }
            }
        }
        dfs(grid, startX, startY, emptyCells + 1);
        return totalPaths;
    }
    private void dfs(int[][] grid, int x, int y, int remainingCells) {
        if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == -1) {
            return;
        }
        if (grid[x][y] == 2) {
            if (remainingCells == 0) {
                totalPaths++;
            }
            return;
        }
        int temp = grid[x][y];
        grid[x][y] = -1; 
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            dfs(grid, newX, newY, remainingCells - 1);
        }
        grid[x][y] = temp; 
    }
}