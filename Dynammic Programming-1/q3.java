public class q3 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        // Dynamic programming approach
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        return dp[n - 1];
    }

    public static void main(String[] args) {
        q3 solution = new q3();

        // Example usage
        int[] nums = {2, 7, 9, 3, 1}; // Amount of money in each house
        int maxAmount = solution.rob(nums);
        System.out.println("Maximum amount of money you can rob tonight: " + maxAmount);
    }
}
