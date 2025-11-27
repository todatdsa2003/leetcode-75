
import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
    public class Solution {
        public int maxFrequency(int[] nums, int k) {
            Arrays.sort(nums);
            int left = 0;
            long total = 0;
            int result = 1;
            
            for (int right = 0; right < nums.length; right++) {
                total += nums[right];

                long needed = (long) nums[right] * (right - left + 1) - total;
                while (needed > k) {
                    total -= nums[left];
                    left++;
                }
                result = Math.max(result, right - left + 1);
            }
            return result;
            // Arrays.sort(nums);
            // int left = 1;
            // int right = nums.length;
            // int result = 1;

            // while (left <= right) {
            // int mid = left + (right - left) / 2;

            // if (canMakeFrequency(nums, k, mid)) {
            // result = mid;
            // left = mid + 1;
            // } else {
            // right = mid - 1;
            // }
            // }
            // return result;
        }

        // private boolean canMakeFrequency(int[] nums, int k, int length) {
        // long sum = 0;

        // for (int i = 0; i < length; i++) {
        // sum += nums[i];
        // }

        // long res = (long) nums[length - 1] * length - sum;
        // if (res <= k) {
        // return true;
        // }

        // for(int right = length; right < nums.length; right++) {
        // sum += nums[right];
        // sum -= nums[right - length];
        // long cost = (long) nums[right] * length - sum;
        // if (cost <= k) {
        // return true;
        // }
        // }
        // return false;
        // }
    }

    public static void main(String[] args) {
        Solution solution = new FrequencyOfTheMostFrequentElement().new Solution();
        int[] nums = { 1, 2, 4 };
        int k = 5;
        int result = solution.maxFrequency(nums, k);
        System.out.println(result); // Expected output: 3
    }
}
