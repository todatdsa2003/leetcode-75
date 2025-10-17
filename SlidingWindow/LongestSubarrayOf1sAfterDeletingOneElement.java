class Solution {
    public int longestSubarray(int[] nums) {
        int windowStart = 0;
        int maxLength = 0;
        int count = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 0) {
                count++;
            }

            while (count > 1) {
                if (nums[windowStart] == 0) {
                    count--;
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart);
        }

        return maxLength;
    }
}