public class q5 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // Base case: There's one way to make amount 0
        
        // Iterate through the coins
        for (int coin : coins) {
            // Start from the current coin value and move upwards
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin]; // Update dp array with the number of combinations
            }
        }
        
        return dp[amount]; // Return the number of combinations for the given amount
    }

    public static void main(String[] args) {
        q5 solution = new q5();

        // Example usage
        int amount = 5; // Total amount of money
        int[] coins = {1, 2, 5}; // Coins of different denominations
        int combinations = solution.change(amount, coins);
        System.out.println("Number of combinations: " + combinations);
    }
}
