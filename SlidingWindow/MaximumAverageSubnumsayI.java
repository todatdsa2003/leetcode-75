class Solution {
    // public double findMaxAverage(int[] nums, int k) {
    // if (nums == null || nums.length < k || k <= 0) {
    // return 0;
    // }
    // int maxSum = Integer.MIN_VALUE;
    // int windowSum = 0;
    // int windowStart = 0;

    // for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {

    // windowSum += nums[windowEnd];

    // if (windowEnd >= k - 1) {
    // maxSum = Math.max(maxSum, windowSum);
    // windowSum -= nums[windowStart];
    // windowStart++;
    // }
    // }

    // return maxSum / (double)k;
    // }

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return 0;
        }
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        int maxSum = windowSum;
        for (int windowEnd = k; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd] - nums[windowEnd - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }
}