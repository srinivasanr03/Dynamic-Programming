public class q1 {

    public int countWays(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: 1 way to reach 0th step
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m && j <= i; j++) {
                dp[i] += dp[i - j]; // Add ways to reach (i - j)th step
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        q1 solution = new q1();

        // Example usage
        int n = 5; // Number of stairs
        int m = 3; // Maximum number of steps to climb at a time
        int ways = solution.countWays(n, m);
        System.out.println("Number of ways to reach the top: " + ways);
    }
}
