public class MaximumSumOf3NonOverlappingSubarrays {
    class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int n = nums.length;
            // Tinh tong cua moi subarray co do dai k
            int[] sums = new int[n - k + 1];
            int windowSum = 0;
            for (int i = 0; i < k; i++) {
                windowSum += nums[i];
            }
            sums[0] = windowSum;

            for (int i = 1; i <= n - k; i++) {
                windowSum = windowSum - nums[i - 1] + nums[i + k - 1];
                sums[i] = windowSum;
            }

            // Tim ben trai de chon subarray tot nhat
            int[] left = new int[sums.length];
            int bestLeft = 0;

            for (int i = 0; i < sums.length; i++) {
                if (sums[i] > sums[bestLeft]) {
                    bestLeft = i;
                }
                left[i] = bestLeft;
            }

            // Tim ben phai de chon subarray tot nhat
            int[] right = new int[sums.length];
            int bestRight = sums.length - 1;

            for (int i = sums.length - 1; i >= 0; i--) {
                if (sums[i] >= sums[bestRight]) {
                    bestRight = i;
                }
                right[i] = bestRight;
            }

            // Tim o giua de chon 3 subarray
            int[] result = new int[3];
            int maxSum = 0;

            for (int mid = k; mid <= sums.length - k - 1; mid++) {
                int leftIndex = left[mid - k];
                int rightIndex = right[mid + k];
                int totalSum = sums[leftIndex] + sums[mid] + sums[rightIndex];

                if (totalSum > maxSum) {
                    maxSum = totalSum;
                    result[0] = leftIndex;
                    result[1] = mid;
                    result[2] = rightIndex;
                }
            }

            return result;
        }

    }

    // Test cases để hiểu rõ hơn
    public static void main(String[] args) {
        MaximumSumOf3NonOverlappingSubarrays obj = new MaximumSumOf3NonOverlappingSubarrays();
        Solution sol = obj.new Solution();

        // Test 1: [1,2,1,2,6,7,5,1], k=2 → Output: [0,3,5]
        int[] nums1 = { 10, 20, 30, 5, 15, 50, 40, 20, 5, 10};
        int k1 = 2;
        int[] result1 = sol.maxSumOfThreeSubarrays(nums1, k1);
        System.out.println("Test 1: [" + result1[0] + ", " + result1[1] + ", " + result1[2] + "]"); // [0,3,5]

        // Test 2: [4,5,10,6,11,17,4,5,10,6,11,17], k=3 → Output: [0,3,6]
        int[] nums2 = { 4, 5, 10, 6, 11, 17, 4, 5, 10, 6, 11, 17 };
        int k2 = 3;
        int[] result2 = sol.maxSumOfThreeSubarrays(nums2, k2);
        System.out.println("Test 2: [" + result2[0] + ", " + result2[1] + ", " + result2[2] + "]"); // [0,3,6]
    }
}