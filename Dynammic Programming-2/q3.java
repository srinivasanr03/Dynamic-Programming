public class q3 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Dynamic programming approach
        int[][] dp = new int[m][n];
        
        // Base cases
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0]; // Initialize first column
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j]; // Initialize first row
        }
        
        // Calculate the minimum path sum for each cell
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]); // Minimum path sum to reach current cell = value of current cell + minimum of paths from above and left cells
            }
        }
        
        return dp[m - 1][n - 1]; // Return the minimum path sum to reach the bottom-right corner
    }

    public static void main(String[] args) {
        q3 solution = new q3();

        // Example usage
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        int minPathSum = solution.minPathSum(grid);
        System.out.println("Minimum path sum: " + minPathSum);
    }
}
