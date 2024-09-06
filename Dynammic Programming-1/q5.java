import java.util.*;

public class q5 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        // Dynamic programming approach
        int[] dp = new int[n + 1]; // Use one extra row for bottom boundary case
        
        // Bottom-up approach to calculate the minimum path sum
        for (int row = n - 1; row >= 0; row--) {
            List<Integer> currentRow = triangle.get(row);
            for (int i = 0; i < currentRow.size(); i++) {
                dp[i] = currentRow.get(i) + Math.min(dp[i], dp[i + 1]); // Update dp array with minimum path sum
            }
        }
        
        return dp[0]; // Return the minimum path sum starting from the top
    }

    public static void main(String[] args) {
        q5 solution = new q5();

        // Example usage
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        
        int minPathSum = solution.minimumTotal(triangle);
        System.out.println("Minimum path sum from top to bottom: " + minPathSum);
    }
}
