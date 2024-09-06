public class q2 {

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        q2 solution = new q2();

        // Example usage
        int n = 4; // Given n
        int tribonacciNumber = solution.tribonacci(n);
        System.out.println("The " + n + "th Tribonacci number is: " + tribonacciNumber);
    }
}
