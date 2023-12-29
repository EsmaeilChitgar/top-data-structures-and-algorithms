import java.util.ArrayList;

public class TargetSum {
    // Function to find the number of ways to calculate
    // a target number using only array elements and
    // addition or subtraction operator.
    static int findTotalWays(ArrayList<Integer> arr,
                             int[][] dp, int i, int s,
                             int target, int totalSum) {

        // If target is reached, return 1
        if (s == target && i == arr.size()) {
            return 1;
        }

        // If all elements are processed and
        // target is not reached, return 0
        if (i >= arr.size()) {
            return 0;
        }

        // If the result for the current state (i, s +
        // totalSum) has already been computed,
        // return it from the DP table to avoid redundant
        // calculations.
        if (dp[i][s + totalSum] != -1) {
            return dp[i][s + totalSum];
        }

        // Return total count of two cases
        // 1. Consider the current element and add it to the
        // current sum
        // to reach the target.
        // 2. Consider the current element and subtract it
        // from
        // the current sum.
        return dp[i][s + totalSum]
                = findTotalWays(arr, dp, i + 1, s + arr.get(i),
                target, totalSum)
                + findTotalWays(arr, dp, i + 1,
                s - arr.get(i), target,
                totalSum);
    }

    // Driver Program
    public static void main(String[] args)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);

        int totalSum = 0;
        for (int i = 0; i < arr.size(); i++)
            totalSum += arr.get(i);

        // Target number
        int target = 3;

        int[][] dp = new int[arr.size()][2 * totalSum + 1];
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < 2 * totalSum + 1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(
                findTotalWays(arr, dp, 0, 0, target, totalSum));
    }
}