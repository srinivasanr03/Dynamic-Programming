public class q1 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // Check if the starting or ending cell is an obstacle
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0; // If starting or ending cell is an obstacle, return 0 paths
        }
        
        // Dynamic programming approach
        int[][] dp = new int[m][n];
        dp[0][0] = 1; // There's one way to reach the starting cell
        
        // Initialize first row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1]; // If cell is not an obstacle, the number of paths is same as left cell
            }
        }
        
        // Initialize first column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0]; // If cell is not an obstacle, the number of paths is same as upper cell
            }
        }
        
        // Calculate the number of unique paths for each cell
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // If cell is not an obstacle, the number of paths is sum of paths from above and left cells
                }
            }
        }
        
        return dp[m - 1][n - 1]; // Return the number of unique paths to reach the bottom-right corner
    }

    public static void main(String[] args) {
        q1 solution = new q1();

        // Example usage
        int[][] obstacleGrid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int uniquePaths = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("Number of unique paths: " + uniquePaths);
    }
}
