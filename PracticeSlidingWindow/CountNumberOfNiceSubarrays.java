
public class CountNumberOfNiceSubarrays {
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            return atMostK(nums, k) - atMostK(nums, k - 1);
        }

        private int atMostK(int[] nums, int k) {
            if (k < 0)
                return 0;

            int left = 0; 
            int result = 0;
            int oddCount = 0; 

            for (int right = 0; right < nums.length; right++) {
                if (nums[right] % 2 == 1) {
                    oddCount++;
                }
                while (oddCount > k) {
                    if (nums[left] % 2 == 1) {
                        oddCount--;
                    }
                    left++;
                }
                result += (right - left + 1);
            }

            return result;
        }
    }

    // Test cases để hiểu rõ hơn
    public static void main(String[] args) {
        CountNumberOfNiceSubarrays obj = new CountNumberOfNiceSubarrays();
        Solution sol = obj.new Solution();

        // Test 1: [1,1,2,1,1], k=3 → Output: 2
        int[] nums1 = { 1, 1, 2, 1, 1 };
        System.out.println("Test 1: " + sol.numberOfSubarrays(nums1, 3)); // 2

        // Test 2: [2,4,6], k=1 → Output: 0
        int[] nums2 = { 2, 4, 6 };
        System.out.println("Test 2: " + sol.numberOfSubarrays(nums2, 1)); // 0

        // Test 3: [2,2,2,1,2,2,1,2,2,2], k=2 → Output: 16
        int[] nums3 = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        System.out.println("Test 3: " + sol.numberOfSubarrays(nums3, 2)); // 16
    }
}