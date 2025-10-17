public class LongestSubarrayOf1sAfterDeletingOneElement {
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

    public static void main(String[] args) {
        Solution solution = new LongestSubarrayOf1sAfterDeletingOneElement().new Solution();
        int[] nums = {1, 1, 0, 1, 1, 1, 1, 1, 1};
        int result = solution.longestSubarray(nums);
        System.out.println("Longest subarray of 1s after deleting one element: " + result);
    }
}
