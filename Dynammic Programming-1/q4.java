public class q4 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Base cases
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1; // There's only one way to reach any cell in the leftmost column
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1; // There's only one way to reach any cell in the top row
        }
        
        // Calculate the number of unique paths for each cell
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Unique paths to reach current cell = paths from above + paths from left
            }
        }
        
        return dp[m - 1][n - 1]; // Return the number of unique paths to reach the bottom-right corner
    }

    public static void main(String[] args) {
        q4 solution = new q4();

        // Example usage
        int m = 3; // Number of rows
        int n = 7; // Number of columns
        int uniquePaths = solution.uniquePaths(m, n);
        System.out.println("Number of unique paths: " + uniquePaths);
    }
}
