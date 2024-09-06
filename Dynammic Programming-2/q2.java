public class q2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0]; // If there's only one house, rob it
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]); // If there are two houses, rob the one with more money
        }
        
        // Rob the first house and skip the last house
        int maxAmount1 = robHelper(nums, 0, n - 2);
        
        // Skip the first house and rob the last house
        int maxAmount2 = robHelper(nums, 1, n - 1);
        
        // Return the maximum amount between the two scenarios
        return Math.max(maxAmount1, maxAmount2);
    }
    
    // Helper method to calculate maximum amount using dynamic programming
    private int robHelper(int[] nums, int start, int end) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = start; i <= end; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }
        return currMax;
    }

    public static void main(String[] args) {
        q2 solution = new q2();

        // Example usage
        int[] nums = {2, 3, 2}; // Amount of money in each house
        int maxAmount = solution.rob(nums);
        System.out.println("Maximum amount of money you can rob tonight: " + maxAmount);
    }
}
