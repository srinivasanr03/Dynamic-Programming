public class q4 {

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // If the total sum is odd, it cannot be partitioned into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int targetSum = totalSum / 2;
        
        // Dynamic programming approach
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true; // Base case: the empty subset has a sum of 0
        
        // Iterate through the nums array
        for (int num : nums) {
            // Start from the target sum and move backwards
            for (int j = targetSum; j >= num; j--) {
                dp[j] |= dp[j - num]; // Update dp array if the current number can contribute to the sum
            }
        }
        
        return dp[targetSum]; // Return true if the target sum can be achieved
    }

    public static void main(String[] args) {
        q4 solution = new q4();

        // Example usage
        int[] nums = {1, 5, 11, 5}; // Integer array
        boolean canPartition = solution.canPartition(nums);
        System.out.println("Can partition the array into two subsets with equal sum: " + canPartition);
    }
}
